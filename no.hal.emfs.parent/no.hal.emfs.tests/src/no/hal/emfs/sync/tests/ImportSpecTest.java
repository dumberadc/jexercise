/**
 */
package no.hal.emfs.sync.tests;

import junit.textui.TestRunner;

import no.hal.emfs.sync.ImportSpec;
import no.hal.emfs.sync.SyncFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Import Spec</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImportSpecTest extends PortSpecTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ImportSpecTest.class);
	}

	/**
	 * Constructs a new Import Spec test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportSpecTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Import Spec test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ImportSpec getFixture() {
		return (ImportSpec)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SyncFactory.eINSTANCE.createImportSpec());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ImportSpecTest
