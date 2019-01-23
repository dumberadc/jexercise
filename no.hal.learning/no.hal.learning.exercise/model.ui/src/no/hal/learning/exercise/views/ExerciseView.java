package no.hal.learning.exercise.views;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.swt.widgets.Composite;

import no.hal.emf.ui.parts.EObjectsView;
import no.hal.emf.ui.parts.adapters.EObjectViewerAdapter;
import no.hal.learning.exercise.Exercise;
import no.hal.learning.exercise.ExerciseProposals;
import no.hal.learning.exercise.logging.IExChangeHandler;
import no.hal.learning.exercise.logging.LogUtil;
import no.hal.learning.exercise.provider.ExerciseEditPlugin;
import no.hal.learning.exercise.util.Util;
import no.hal.learning.exercise.views.adapters.ExerciseProposalsUIAdapter;
import no.hal.learning.exercise.views.plot.TaskPlotViewerAdapter;
import no.hal.learning.exercise.views.stringeditors.EditorViewerAdapter;

public class ExerciseView extends EObjectsView {

	public ExerciseView() {
		super((Class<? extends EObjectViewerAdapter<?, ?>>) ExerciseProposalsUIAdapter.class);
		addAdapterClass(TaskPlotViewerAdapter.class, "plot view", "plotview.png");
		addAdapterClass(EditorViewerAdapter.class, "editor view", "stringeditor.png");
	}

	@Override
	protected EObject accept(EObject eObject) {
		if (eObject instanceof Exercise) {
			Exercise ex = (Exercise) eObject;
			Resource resource = ex.eResource();
			URI uri = resource.getURI();
			if (resource != null && "xex".equals(uri.fileExtension())) {
				ResourceSet resourceSet = resource.getResourceSet();
				if (resourceSet == null) {
					resourceSet = new ResourceSetImpl();
				}
				Resource exResource = resourceSet.createResource(uri.trimFileExtension().appendFileExtension("ex"));
				exResource.getContents().addAll(resource.getContents());
				resourceSet.getResources().remove(resource);
				resourceSet.getResources().add(exResource);
			}
			ExerciseProposals proposals = findProposals(ex);
			if (proposals == null) {
				proposals = Util.ensureExerciseProposals(ex, null);
				resource.getContents().add(proposals);
			}
			return proposals;
		} else if (eObject instanceof ExerciseProposals) {
			return eObject;
		}
		return null;
	}

	protected void addEObject(EObject eObject) {
		if (eObject instanceof ExerciseProposals) {
			super.addEObject(eObject);
//			autoSave(eObject, 1, true);
		}
	}

	protected ExerciseProposals findProposals(Exercise ex) {
		for (EObject eObject : ex.eResource().getContents()) {
			if (eObject instanceof ExerciseProposals) {
				ExerciseProposals proposals = (ExerciseProposals) eObject;
				if (proposals.getExercise() == ex) {
					return proposals;
				}
			}
		}
		return null;
	}

	private IResourceChangeListener autoSaveListener = new IResourceChangeListener() {
		@Override
		public void resourceChanged(IResourceChangeEvent event) {
			if (event.getType() == IResourceChangeEvent.POST_BUILD) {
				saveEObjectResources(saveOptions);
				LogUtil.info("Auto-saved resources", null);
			}
		}
	};
	
	private Collection<IExChangeHandler> exChangeHandlers = null;
	
	private void processExChangeHandlersExtensionPoint() {
		exChangeHandlers = new ArrayList<IExChangeHandler>();
		IExtensionPoint ep = Platform.getExtensionRegistry().getExtensionPoint(ExerciseEditPlugin.getPlugin().getBundle().getSymbolicName() + ".exChangeHandler");
		for (IExtension extension : ep.getExtensions()) {
			for (IConfigurationElement ces: extension.getConfigurationElements()) {
				try {
					if ("exChangeHandler".equals(ces.getName())) {
						IExChangeHandler exChangeHandler = (IExChangeHandler) ces.createExecutableExtension("handlerClass");
						exChangeHandlers.add(exChangeHandler);
					}
				} catch (InvalidRegistryObjectException e) {
				} catch (CoreException e) {
				}
			}
		}
	}
	
	private FileChangeHandler exFileChangeHandler = new FileChangeHandler("ex") {
		@Override
		protected void fileChanged(IFile file) {
			Resource resource = getEObjectResource(file.getFullPath());
			if (resource != null) {
				if (exChangeHandlers == null) {
					processExChangeHandlersExtensionPoint();
				}
				for (IExChangeHandler exChangeHandler : exChangeHandlers) {
					exChangeHandler.exResourceChanged(resource);
				}
			}
		}
	};

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		ResourcesPlugin.getWorkspace().addResourceChangeListener(autoSaveListener, IResourceChangeEvent.POST_BUILD);
		ResourcesPlugin.getWorkspace().addResourceChangeListener(exFileChangeHandler, IResourceChangeEvent.POST_CHANGE);
	}
	
	@Override
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(exFileChangeHandler);
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(autoSaveListener);
		super.dispose();
	}

//	private URI createMqttUri(String exPath, String id) {
//		if (exPath.startsWith("/")) {
//			exPath = exPath.substring(1);
//		}
//		if (! exPath.endsWith(".ex")) {
//			exPath = exPath + ".ex";
//		}
//		String prefix = ExerciseView.class.getName();
//		if (! exPath.startsWith(prefix)) {
//			exPath = prefix + "/" + exPath;
//		}
//		return URI.createURI("mqtt://mqtt.idi.ntnu.no:1883/" + exPath + "/" + id);
//	}
//
//	private Action openLoggedExAction = new Action("Open Logged Ex") {
//		public void run() {
//			InputDialog inputDialog = new InputDialog(getSite().getShell(), "Open Logged Ex", "Enter Mqtt Topic", "package/file.ex/ID", new IInputValidator() {
//				
//				private boolean isInt(String s) {
//					Integer i = null;
//					try {
//						i = Integer.valueOf(s);
//					} catch (NumberFormatException e) {
//					}
//					return i != null;
//				}
//				
//				@Override
//				public String isValid(String s) {
//					int pos = s.lastIndexOf("/");
//					if (pos < 3 || (! ".ex".equals(s.substring(pos - 3, pos))) || pos >= s.length() - 1 || (! isInt(s.substring(pos + 1)))) {
//						return "Incorrect format, must be package/file.ex/INT";
//					}
//					return null;
//				}
//			});
//			if (inputDialog.open() != Window.OK) {
//				return;
//			}
//			String s = inputDialog.getValue();
//			int pos = s.lastIndexOf("/");
//			String path = s.substring(0, pos), id = s.substring(pos + 1);
//			URI uri = createMqttUri(path, id);
//			if (uri != null) {
//				Resource resource = new ExerciseResourceFactoryImpl().createResource(uri);
//				try {
//					resource.load(new MqttURIHandlerImpl().createInputStream(uri, logOptions), logOptions);
//				} catch (IOException e) {
//					throw new RuntimeException(e);
//				}
//				addAcceptedEObject(resource);
//			}
//		}
//	};
//	
//	@Override
//	protected void addActions(IActionBars actionBars) {
//		super.addActions(actionBars);
//		actionBars.getMenuManager().add(openLoggedExAction);
//	}
}
