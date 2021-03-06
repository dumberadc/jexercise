package inheritance;

import com.google.common.collect.Iterables;
import inheritance.Asteroid;
import inheritance.SpaceObject;
import inheritance.SpaceShip;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import junit.framework.TestCase;
import no.hal.jex.runtime.JExercise;
import org.eclipse.xtext.xbase.lib.Conversions;

@JExercise(description = "Tests inheritance.SpaceObject")
@SuppressWarnings("all")
public class SpaceObjectTest extends TestCase {
  private SpaceObject spaceObject;
  
  private SpaceObject _init_spaceObject() {
    SpaceObject _spaceObject = new SpaceObject();
    return _spaceObject;
  }
  
  private SpaceObject asteroid1;
  
  private SpaceObject _init_asteroid1() {
    Asteroid _asteroid = new Asteroid(10, 2);
    return _asteroid;
  }
  
  private SpaceObject asteroid2;
  
  private SpaceObject _init_asteroid2() {
    Asteroid _asteroid = new Asteroid(10, 3);
    return _asteroid;
  }
  
  private SpaceObject spaceShip;
  
  private SpaceObject _init_spaceShip() {
    SpaceShip _spaceShip = new SpaceShip();
    return _spaceShip;
  }
  
  private SpaceObject so1;
  
  private SpaceObject _init_so1() {
    SpaceObject _createSpaceObject = this.createSpaceObject(0.0d, 0.0d, 7.0, 0.0d, 7.0, 7.0d, 0.0, 7.0d);
    return _createSpaceObject;
  }
  
  private SpaceObject so2;
  
  private SpaceObject _init_so2() {
    SpaceObject _createSpaceObject = this.createSpaceObject(2.0d, 2.0d, 8.0, 2.0d, 8.0, 8.0d, 2.0, 8.0d);
    return _createSpaceObject;
  }
  
  private SpaceObject so3;
  
  private SpaceObject _init_so3() {
    SpaceObject _createSpaceObject = this.createSpaceObject(5.0d, 1.0d, 9.0, 5.0d, 5.0, 9.0d, 1.0, 5.0d);
    return _createSpaceObject;
  }
  
  private SpaceObject so4;
  
  private SpaceObject _init_so4() {
    SpaceObject _createSpaceObject = this.createSpaceObject(9.0d, 6.0d, 13.0, 10.0d, 9.0, 14.0d, 5.0, 10.0d);
    return _createSpaceObject;
  }
  
  @Override
  protected void setUp() {
    spaceObject = _init_spaceObject();
    asteroid1 = _init_asteroid1();
    asteroid2 = _init_asteroid2();
    spaceShip = _init_spaceShip();
    so1 = _init_so1();
    so2 = _init_so2();
    so3 = _init_so3();
    so4 = _init_so4();
    
  }
  
  private SpaceObject createSpaceObject(final double... xys) {
    SpaceObject _xblockexpression = null;
    {
      final SpaceObject so = new SpaceObject();
      ObservableList<Double> _points = so.getPoints();
      Iterables.<Double>addAll(_points, ((Iterable<? extends Double>)Conversions.doWrapArray(xys)));
      _xblockexpression = so;
    }
    return _xblockexpression;
  }
  
  private boolean operator_equals(final double n1, final double n2) {
    throw new UnsupportedOperationException("Test wouldn't compile, due to missing or erroneous code.");
  }
  
  private void testSpeed(final SpaceObject it, final double vx, final double vy) {
    _test__testSpeed_test(it, vx, vy);
    
  }
  
  private void _test__testSpeed_test(final SpaceObject it, final double vx, final double vy) {
    
    Point2D _speed = it.getSpeed();
    double _x = _speed.getX();
    boolean _equals = this.operator_equals(_x, vx);
    assertTrue("speed.x == vx failed", _equals);
    
    Point2D _speed_1 = it.getSpeed();
    double _y = _speed_1.getY();
    assertTrue("speed.y == vy failed", this.operator_equals(_y, vy));
    
  }
  
  private void testPosition(final SpaceObject it, final double x, final double y) {
    _test__testPosition_test(it, x, y);
    
  }
  
  private void _test__testPosition_test(final SpaceObject it, final double x, final double y) {
    
    Point2D _position = it.getPosition();
    double _x = _position.getX();
    boolean _equals = this.operator_equals(_x, x);
    assertTrue("position.x == x failed", _equals);
    
    Point2D _position_1 = it.getPosition();
    double _y = _position_1.getY();
    assertTrue("position.y == y failed", this.operator_equals(_y, y));
    
  }
  
  @JExercise(tests = "SpaceObject()", description = "Tests \n\t\tinitialization\n")
  public void testMass() {
    _test__mass_transitions0_effects0_state();
    
  }
  
  @JExercise(tests = "SpaceObject();void accelerate(double,double)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>spaceObject.accelerate(2.3, 7.4)</li>\n\t\t<li>asteroid1.accelerate(3.2, 4.7)</li>\n\t\t<li>spaceShip.accelerate(3.3, 7.7)</li>\n\t\t</ul>\n")
  public void testAccelerate() {
    _transition_exprAction__accelerate_transitions0_actions0();
    _test__accelerate_transitions0_effects0_state();
    _transition_exprAction__accelerate_transitions1_actions0();
    _test__accelerate_transitions1_effects0_state();
    _transition_exprAction__accelerate_transitions2_actions0();
    _test__accelerate_transitions2_effects0_state();
    
  }
  
  @JExercise(tests = "SpaceObject();void accelerate(double,double);void tick()", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>spaceObject.accelerate(2.3, 7.4), spaceObject.tick</li>\n\t\t<li>spaceObject.accelerate(-2.3, -7.4), spaceObject.tick</li>\n\t\t<li>spaceObject.accelerate(-2.3, -7.4), spaceObject.tick</li>\n\t\t<li>asteroid1.accelerate(3.2, 4.7), asteroid1.tick</li>\n\t\t<li>asteroid1.accelerate(-3.2, -4.7), asteroid1.tick</li>\n\t\t<li>asteroid1.accelerate(-3.2, -4.7), asteroid1.tick</li>\n\t\t<li>spaceShip.accelerate(3.3, 7.7), spaceShip.tick</li>\n\t\t<li>spaceShip.accelerate(-3.3, -7.7), spaceShip.tick</li>\n\t\t<li>spaceShip.accelerate(-3.3, -7.7), spaceShip.tick</li>\n\t\t</ul>\n")
  public void testTick() {
    _transition_exprAction__tick_transitions0_actions0();
    _transition_exprAction__tick_transitions0_actions1();
    _test__tick_transitions0_effects0_state();
    _transition_exprAction__tick_transitions1_actions0();
    _transition_exprAction__tick_transitions1_actions1();
    _test__tick_transitions1_effects0_state();
    _transition_exprAction__tick_transitions2_actions0();
    _transition_exprAction__tick_transitions2_actions1();
    _test__tick_transitions2_effects0_state();
    _transition_exprAction__tick_transitions3_actions0();
    _transition_exprAction__tick_transitions3_actions1();
    _test__tick_transitions3_effects0_state();
    _transition_exprAction__tick_transitions4_actions0();
    _transition_exprAction__tick_transitions4_actions1();
    _test__tick_transitions4_effects0_state();
    _transition_exprAction__tick_transitions5_actions0();
    _transition_exprAction__tick_transitions5_actions1();
    _test__tick_transitions5_effects0_state();
    _transition_exprAction__tick_transitions6_actions0();
    _transition_exprAction__tick_transitions6_actions1();
    _test__tick_transitions6_effects0_state();
    _transition_exprAction__tick_transitions7_actions0();
    _transition_exprAction__tick_transitions7_actions1();
    _test__tick_transitions7_effects0_state();
    _transition_exprAction__tick_transitions8_actions0();
    _transition_exprAction__tick_transitions8_actions1();
    _test__tick_transitions8_effects0_state();
    
  }
  
  @JExercise(tests = "SpaceObject();void applyForce(double,double)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>spaceObject.applyForce(2.3, 7.4)</li>\n\t\t<li>asteroid1.applyForce(3.2, 4.7)</li>\n\t\t<li>spaceShip.applyForce(3.3, 7.7)</li>\n\t\t</ul>\n")
  public void testApplyForce() {
    try {
      _transition_exprAction__applyForce_transitions0_actions0();
      fail("IllegalStateException should be thrown after spaceObject.applyForce(2.3, 7.4)");
    } catch (Exception e) {
      assertTrue("IllegalStateException should be thrown after spaceObject.applyForce(2.3, 7.4)", e instanceof IllegalStateException);
    }
    _transition_exprAction__applyForce_transitions1_actions0();
    _test__applyForce_transitions1_effects0_state();
    _transition_exprAction__applyForce_transitions2_actions0();
    _test__applyForce_transitions2_effects0_state();
    
  }
  
  @JExercise(tests = "SpaceObject()", description = "Tests \n\t\tinitialization\n")
  public void testIntersects1() {
    _test__intersects1_transitions0_effects0_state();
    
  }
  
  @JExercise(tests = "SpaceObject()", description = "Tests \n\t\tinitialization\n")
  public void testIntersects2() {
    _test__intersects2_transitions0_effects0_state();
    
  }
  
  @JExercise(tests = "SpaceObject()", description = "Tests \n\t\tinitialization\n")
  public void testIntersects3() {
    _test__intersects3_transitions0_effects0_state();
    
  }
  
  @JExercise(tests = "SpaceObject()", description = "Tests \n\t\tinitialization\n")
  public void testIntersects4() {
    _test__intersects4_transitions0_effects0_state();
    
  }
  
  private void _test__mass_transitions0_effects0_state() {
    _test__mass_transitions0_effects0_state_objectTests0_test(spaceObject);
    _test__mass_transitions0_effects0_state_objectTests1_test(asteroid1);
    _test__mass_transitions0_effects0_state_objectTests2_test(spaceShip);
    
  }
  
  private void _test__mass_transitions0_effects0_state_objectTests0_test(final SpaceObject it) {
    
    double _mass = it.getMass();
    assertEquals("mass === 0.0 failed", 0.0, _mass);
    
  }
  
  private void _test__mass_transitions0_effects0_state_objectTests1_test(final SpaceObject it) {
    
    double _mass = it.getMass();
    double _mass_1 = this.asteroid2.getMass();
    double _multiply = (_mass_1 * 8);
    double _divide = (_multiply / 27);
    assertTrue("mass == asteroid2.mass * 8 / 27 failed", this.operator_equals(_mass, _divide));
    
  }
  
  private void _test__mass_transitions0_effects0_state_objectTests2_test(final SpaceObject it) {
    
    double _mass = it.getMass();
    assertEquals("mass === 1.0 failed", 1.0, _mass);
    
  }
  
  private void _transition_exprAction__accelerate_transitions0_actions0() {
    try {
      
      this.spaceObject.accelerate(2.3, 7.4);
      } catch (junit.framework.AssertionFailedError error) {
      fail("spaceObject.accelerate(2.3, 7.4) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__accelerate_transitions0_effects0_state() {
    _test__accelerate_transitions0_effects0_state_objectTests0_test(spaceObject);
    
  }
  
  private void _test__accelerate_transitions0_effects0_state_objectTests0_test(final SpaceObject it) {
    try {
      
      this.testSpeed(it, 2.3, 7.4);
      } catch (junit.framework.AssertionFailedError error) {
      fail("testSpeed(2.3, 7.4) failed after spaceObject.accelerate(2.3, 7.4): " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__accelerate_transitions1_actions0() {
    try {
      
      this.asteroid1.accelerate(3.2, 4.7);
      } catch (junit.framework.AssertionFailedError error) {
      fail("asteroid1.accelerate(3.2, 4.7) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__accelerate_transitions1_effects0_state() {
    _test__accelerate_transitions1_effects0_state_objectTests0_test(asteroid1);
    
  }
  
  private void _test__accelerate_transitions1_effects0_state_objectTests0_test(final SpaceObject it) {
    try {
      
      this.testSpeed(it, 3.2, 4.7);
      } catch (junit.framework.AssertionFailedError error) {
      fail("testSpeed(3.2, 4.7) failed after asteroid1.accelerate(3.2, 4.7): " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__accelerate_transitions2_actions0() {
    try {
      
      this.spaceShip.accelerate(3.3, 7.7);
      } catch (junit.framework.AssertionFailedError error) {
      fail("spaceShip.accelerate(3.3, 7.7) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__accelerate_transitions2_effects0_state() {
    _test__accelerate_transitions2_effects0_state_objectTests0_test(spaceShip);
    
  }
  
  private void _test__accelerate_transitions2_effects0_state_objectTests0_test(final SpaceObject it) {
    try {
      
      this.testSpeed(it, 3.3, 7.7);
      } catch (junit.framework.AssertionFailedError error) {
      fail("testSpeed(3.3, 7.7) failed after spaceShip.accelerate(3.3, 7.7): " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__tick_transitions0_actions0() {
    try {
      
      this.spaceObject.accelerate(2.3, 7.4);
      } catch (junit.framework.AssertionFailedError error) {
      fail("spaceObject.accelerate(2.3, 7.4) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__tick_transitions0_actions1() {
    try {
      
      this.spaceObject.tick();
      } catch (junit.framework.AssertionFailedError error) {
      fail("spaceObject.tick failed: " + error.getMessage());
    }
    
  }
  
  private void _test__tick_transitions0_effects0_state() {
    _test__tick_transitions0_effects0_state_objectTests0_test(spaceObject);
    
  }
  
  private void _test__tick_transitions0_effects0_state_objectTests0_test(final SpaceObject it) {
    try {
      
      this.testPosition(it, 2.3, 7.4);
      } catch (junit.framework.AssertionFailedError error) {
      fail("testPosition(2.3, 7.4) failed after spaceObject.accelerate(2.3, 7.4) ,spaceObject.tick: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__tick_transitions1_actions0() {
    try {
      
      this.spaceObject.accelerate((-2.3), (-7.4));
      } catch (junit.framework.AssertionFailedError error) {
      fail("spaceObject.accelerate(-2.3, -7.4) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__tick_transitions1_actions1() {
    try {
      
      this.spaceObject.tick();
      } catch (junit.framework.AssertionFailedError error) {
      fail("spaceObject.tick failed: " + error.getMessage());
    }
    
  }
  
  private void _test__tick_transitions1_effects0_state() {
    _test__tick_transitions1_effects0_state_objectTests0_test(spaceObject);
    
  }
  
  private void _test__tick_transitions1_effects0_state_objectTests0_test(final SpaceObject it) {
    try {
      
      this.testPosition(it, 2.3, 7.4);
      } catch (junit.framework.AssertionFailedError error) {
      fail("testPosition(2.3, 7.4) failed after spaceObject.accelerate(-2.3, -7.4) ,spaceObject.tick: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__tick_transitions2_actions0() {
    try {
      
      this.spaceObject.accelerate((-2.3), (-7.4));
      } catch (junit.framework.AssertionFailedError error) {
      fail("spaceObject.accelerate(-2.3, -7.4) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__tick_transitions2_actions1() {
    try {
      
      this.spaceObject.tick();
      } catch (junit.framework.AssertionFailedError error) {
      fail("spaceObject.tick failed: " + error.getMessage());
    }
    
  }
  
  private void _test__tick_transitions2_effects0_state() {
    _test__tick_transitions2_effects0_state_objectTests0_test(spaceObject);
    
  }
  
  private void _test__tick_transitions2_effects0_state_objectTests0_test(final SpaceObject it) {
    try {
      
      this.testPosition(it, 0.0, 0.0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("testPosition(0.0, 0.0) failed after spaceObject.accelerate(-2.3, -7.4) ,spaceObject.tick: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__tick_transitions3_actions0() {
    try {
      
      this.asteroid1.accelerate(3.2, 4.7);
      } catch (junit.framework.AssertionFailedError error) {
      fail("asteroid1.accelerate(3.2, 4.7) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__tick_transitions3_actions1() {
    try {
      
      this.asteroid1.tick();
      } catch (junit.framework.AssertionFailedError error) {
      fail("asteroid1.tick failed: " + error.getMessage());
    }
    
  }
  
  private void _test__tick_transitions3_effects0_state() {
    _test__tick_transitions3_effects0_state_objectTests0_test(asteroid1);
    
  }
  
  private void _test__tick_transitions3_effects0_state_objectTests0_test(final SpaceObject it) {
    try {
      
      this.testPosition(it, 3.2, 4.7);
      } catch (junit.framework.AssertionFailedError error) {
      fail("testPosition(3.2, 4.7) failed after asteroid1.accelerate(3.2, 4.7) ,asteroid1.tick: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__tick_transitions4_actions0() {
    try {
      
      this.asteroid1.accelerate((-3.2), (-4.7));
      } catch (junit.framework.AssertionFailedError error) {
      fail("asteroid1.accelerate(-3.2, -4.7) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__tick_transitions4_actions1() {
    try {
      
      this.asteroid1.tick();
      } catch (junit.framework.AssertionFailedError error) {
      fail("asteroid1.tick failed: " + error.getMessage());
    }
    
  }
  
  private void _test__tick_transitions4_effects0_state() {
    _test__tick_transitions4_effects0_state_objectTests0_test(asteroid1);
    
  }
  
  private void _test__tick_transitions4_effects0_state_objectTests0_test(final SpaceObject it) {
    try {
      
      this.testPosition(it, 3.2, 4.7);
      } catch (junit.framework.AssertionFailedError error) {
      fail("testPosition(3.2, 4.7) failed after asteroid1.accelerate(-3.2, -4.7) ,asteroid1.tick: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__tick_transitions5_actions0() {
    try {
      
      this.asteroid1.accelerate((-3.2), (-4.7));
      } catch (junit.framework.AssertionFailedError error) {
      fail("asteroid1.accelerate(-3.2, -4.7) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__tick_transitions5_actions1() {
    try {
      
      this.asteroid1.tick();
      } catch (junit.framework.AssertionFailedError error) {
      fail("asteroid1.tick failed: " + error.getMessage());
    }
    
  }
  
  private void _test__tick_transitions5_effects0_state() {
    _test__tick_transitions5_effects0_state_objectTests0_test(spaceObject);
    
  }
  
  private void _test__tick_transitions5_effects0_state_objectTests0_test(final SpaceObject it) {
    try {
      
      this.testPosition(it, 0.0, 0.0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("testPosition(0.0, 0.0) failed after asteroid1.accelerate(-3.2, -4.7) ,asteroid1.tick: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__tick_transitions6_actions0() {
    try {
      
      this.spaceShip.accelerate(3.3, 7.7);
      } catch (junit.framework.AssertionFailedError error) {
      fail("spaceShip.accelerate(3.3, 7.7) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__tick_transitions6_actions1() {
    try {
      
      this.spaceShip.tick();
      } catch (junit.framework.AssertionFailedError error) {
      fail("spaceShip.tick failed: " + error.getMessage());
    }
    
  }
  
  private void _test__tick_transitions6_effects0_state() {
    _test__tick_transitions6_effects0_state_objectTests0_test(spaceShip);
    
  }
  
  private void _test__tick_transitions6_effects0_state_objectTests0_test(final SpaceObject it) {
    try {
      
      this.testPosition(it, 3.3, 7.7);
      } catch (junit.framework.AssertionFailedError error) {
      fail("testPosition(3.3, 7.7) failed after spaceShip.accelerate(3.3, 7.7) ,spaceShip.tick: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__tick_transitions7_actions0() {
    try {
      
      this.spaceShip.accelerate((-3.3), (-7.7));
      } catch (junit.framework.AssertionFailedError error) {
      fail("spaceShip.accelerate(-3.3, -7.7) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__tick_transitions7_actions1() {
    try {
      
      this.spaceShip.tick();
      } catch (junit.framework.AssertionFailedError error) {
      fail("spaceShip.tick failed: " + error.getMessage());
    }
    
  }
  
  private void _test__tick_transitions7_effects0_state() {
    _test__tick_transitions7_effects0_state_objectTests0_test(spaceShip);
    
  }
  
  private void _test__tick_transitions7_effects0_state_objectTests0_test(final SpaceObject it) {
    try {
      
      this.testPosition(it, 3.3, 7.7);
      } catch (junit.framework.AssertionFailedError error) {
      fail("testPosition(3.3, 7.7) failed after spaceShip.accelerate(-3.3, -7.7) ,spaceShip.tick: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__tick_transitions8_actions0() {
    try {
      
      this.spaceShip.accelerate((-3.3), (-7.7));
      } catch (junit.framework.AssertionFailedError error) {
      fail("spaceShip.accelerate(-3.3, -7.7) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__tick_transitions8_actions1() {
    try {
      
      this.spaceShip.tick();
      } catch (junit.framework.AssertionFailedError error) {
      fail("spaceShip.tick failed: " + error.getMessage());
    }
    
  }
  
  private void _test__tick_transitions8_effects0_state() {
    _test__tick_transitions8_effects0_state_objectTests0_test(spaceShip);
    
  }
  
  private void _test__tick_transitions8_effects0_state_objectTests0_test(final SpaceObject it) {
    try {
      
      this.testPosition(it, 0.0, 0.0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("testPosition(0.0, 0.0) failed after spaceShip.accelerate(-3.3, -7.7) ,spaceShip.tick: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__applyForce_transitions0_actions0() {
    try {
      
      this.spaceObject.applyForce(2.3, 7.4);
      } catch (junit.framework.AssertionFailedError error) {
      fail("spaceObject.applyForce(2.3, 7.4) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__applyForce_transitions1_actions0() {
    try {
      
      this.asteroid1.applyForce(3.2, 4.7);
      } catch (junit.framework.AssertionFailedError error) {
      fail("asteroid1.applyForce(3.2, 4.7) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__applyForce_transitions1_effects0_state() {
    _test__applyForce_transitions1_effects0_state_objectTests0_test(asteroid1);
    
  }
  
  private void _test__applyForce_transitions1_effects0_state_objectTests0_test(final SpaceObject it) {
    try {
      
      double _mass = it.getMass();
      double _divide = (3.2 / _mass);
      double _mass_1 = it.getMass();
      double _divide_1 = (4.7 / _mass_1);
      this.testSpeed(it, _divide, _divide_1);
      } catch (junit.framework.AssertionFailedError error) {
      fail("testSpeed(3.2 / mass, 4.7 / mass) failed after asteroid1.applyForce(3.2, 4.7): " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__applyForce_transitions2_actions0() {
    try {
      
      this.spaceShip.applyForce(3.3, 7.7);
      } catch (junit.framework.AssertionFailedError error) {
      fail("spaceShip.applyForce(3.3, 7.7) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__applyForce_transitions2_effects0_state() {
    _test__applyForce_transitions2_effects0_state_objectTests0_test(spaceShip);
    
  }
  
  private void _test__applyForce_transitions2_effects0_state_objectTests0_test(final SpaceObject it) {
    try {
      
      double _mass = it.getMass();
      double _divide = (3.3 / _mass);
      double _mass_1 = it.getMass();
      double _divide_1 = (7.7 / _mass_1);
      this.testSpeed(it, _divide, _divide_1);
      } catch (junit.framework.AssertionFailedError error) {
      fail("testSpeed(3.3 / mass, 7.7 / mass) failed after spaceShip.applyForce(3.3, 7.7): " + error.getMessage());
    }
    
  }
  
  private void _test__intersects1_transitions0_effects0_state() {
    _test__intersects1_transitions0_effects0_state_objectTests0_test(so1);
    _test__intersects1_transitions0_effects0_state_objectTests1_test(so1);
    _test__intersects1_transitions0_effects0_state_objectTests2_test(so1);
    _test__intersects1_transitions0_effects0_state_objectTests3_test(so1);
    
  }
  
  private void _test__intersects1_transitions0_effects0_state_objectTests0_test(final SpaceObject it) {
    
    assertTrue("intersects(so1) failed", it.intersects(this.so1));
    
  }
  
  private void _test__intersects1_transitions0_effects0_state_objectTests1_test(final SpaceObject it) {
    
    assertTrue("intersects(so2) failed", it.intersects(this.so2));
    
  }
  
  private void _test__intersects1_transitions0_effects0_state_objectTests2_test(final SpaceObject it) {
    
    assertTrue("intersects(so3) failed", it.intersects(this.so3));
    
  }
  
  private void _test__intersects1_transitions0_effects0_state_objectTests3_test(final SpaceObject it) {
    
    boolean _intersects = it.intersects(this.so4);
    assertTrue("! intersects(so4) failed", (!_intersects));
    
  }
  
  private void _test__intersects2_transitions0_effects0_state() {
    _test__intersects2_transitions0_effects0_state_objectTests0_test(so2);
    _test__intersects2_transitions0_effects0_state_objectTests1_test(so2);
    _test__intersects2_transitions0_effects0_state_objectTests2_test(so2);
    _test__intersects2_transitions0_effects0_state_objectTests3_test(so2);
    
  }
  
  private void _test__intersects2_transitions0_effects0_state_objectTests0_test(final SpaceObject it) {
    
    assertTrue("intersects(so2) failed", it.intersects(this.so2));
    
  }
  
  private void _test__intersects2_transitions0_effects0_state_objectTests1_test(final SpaceObject it) {
    
    assertTrue("intersects(so1) failed", it.intersects(this.so1));
    
  }
  
  private void _test__intersects2_transitions0_effects0_state_objectTests2_test(final SpaceObject it) {
    
    assertTrue("intersects(so3) failed", it.intersects(this.so3));
    
  }
  
  private void _test__intersects2_transitions0_effects0_state_objectTests3_test(final SpaceObject it) {
    
    assertTrue("intersects(so4) failed", it.intersects(this.so4));
    
  }
  
  private void _test__intersects3_transitions0_effects0_state() {
    _test__intersects3_transitions0_effects0_state_objectTests0_test(so3);
    _test__intersects3_transitions0_effects0_state_objectTests1_test(so3);
    _test__intersects3_transitions0_effects0_state_objectTests2_test(so3);
    _test__intersects3_transitions0_effects0_state_objectTests3_test(so3);
    
  }
  
  private void _test__intersects3_transitions0_effects0_state_objectTests0_test(final SpaceObject it) {
    
    assertTrue("intersects(so3) failed", it.intersects(this.so3));
    
  }
  
  private void _test__intersects3_transitions0_effects0_state_objectTests1_test(final SpaceObject it) {
    
    assertTrue("intersects(so1) failed", it.intersects(this.so1));
    
  }
  
  private void _test__intersects3_transitions0_effects0_state_objectTests2_test(final SpaceObject it) {
    
    assertTrue("intersects(so2) failed", it.intersects(this.so2));
    
  }
  
  private void _test__intersects3_transitions0_effects0_state_objectTests3_test(final SpaceObject it) {
    
    boolean _intersects = it.intersects(this.so4);
    assertTrue("! intersects(so4) failed", (!_intersects));
    
  }
  
  private void _test__intersects4_transitions0_effects0_state() {
    _test__intersects4_transitions0_effects0_state_objectTests0_test(so4);
    _test__intersects4_transitions0_effects0_state_objectTests1_test(so4);
    _test__intersects4_transitions0_effects0_state_objectTests2_test(so4);
    _test__intersects4_transitions0_effects0_state_objectTests3_test(so4);
    
  }
  
  private void _test__intersects4_transitions0_effects0_state_objectTests0_test(final SpaceObject it) {
    
    assertTrue("intersects(so4) failed", it.intersects(this.so4));
    
  }
  
  private void _test__intersects4_transitions0_effects0_state_objectTests1_test(final SpaceObject it) {
    
    boolean _intersects = it.intersects(this.so1);
    assertTrue("! intersects(so1) failed", (!_intersects));
    
  }
  
  private void _test__intersects4_transitions0_effects0_state_objectTests2_test(final SpaceObject it) {
    
    assertTrue("intersects(so2) failed", it.intersects(this.so2));
    
  }
  
  private void _test__intersects4_transitions0_effects0_state_objectTests3_test(final SpaceObject it) {
    
    boolean _intersects = it.intersects(this.so3);
    assertTrue("! intersects(so3) failed", (!_intersects));
    
  }
}
