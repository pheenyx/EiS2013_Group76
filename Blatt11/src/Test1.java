import static org.junit.Assert.*;
import org.junit.Test;

/**
 * For sheet 11 exercise 3
 * This class tests a special function.
 *   
 * @author Sascha Fraenkel
 *
 */
public class Test1 {

	  /**
	   * tests C.berechneC(64)
	   * 
	   */
	  @Test
	  public void test1(){
	    assertEquals(0.43837, C.berechneC(64), 1e-5);
	  }
	  
	  /**
	   * tests C.berechneC(25)
	   * 
	   */
	  @Test
	  public void test2(){
	    assertEquals(0.90630, C.berechneC(25), 1e-5);
	  }
	  
	  /**
	   * tests C.berechneC(203)
	   * 
	   */
	  @Test
	  public void test3(){
	    assertEquals(-0.92050, C.berechneC(203), 1e-5);
	  }
	  
	  /**
	   * tests C.berechneC(294)
	   * 
	   */
	  @Test
	  public void test4(){
	    assertEquals(0.40673, C.berechneC(294), 1e-5);
	  }
	  
	  /**
	   * tests C.berechneC(110)
	   * 
	   */
	  @Test
	  public void test5(){
	    assertEquals(-0.34202, C.berechneC(110), 1e-5);
	  }
	  
	  /**
	   * tests C.berechneC(60)
	   * 
	   */
	  @Test
	  public void test6(){
	    assertEquals(0.5, C.berechneC(60), 1e-5);
	  }
	  
	  /**
	   * tests C.berechneC(45)
	   * 
	   */
	  @Test
	  public void test7(){
	    assertEquals(0.70710, C.berechneC(45), 1e-5);
	  }
	  
	  /**
	   * tests C.berechneC(15)
	   * 
	   */
	  @Test
	  public void test8(){
	    assertEquals(0.96592, C.berechneC(15), 1e-5);
	  }
	  
	  /**
	   * tests C.berechneC(80)
	   * 
	   */
	  @Test
	  public void test9(){
	    assertEquals(0.17364, C.berechneC(80), 1e-5);
	  }
	  
	  /**
	   * tests C.berechneC(197)
	   * 
	   */
	  @Test
	  public void test10(){
	    assertEquals(-0.95630, C.berechneC(197), 1e-5);
	  }
	  
	  /**
	   * tests C.berechneC(432)
	   * 
	   */
	  @Test
	  public void test11(){
	    assertEquals(0.30901, C.berechneC(432), 1e-5);
	  }
	  
	  /**
	   * tests C.berechneC(70)
	   * 
	   */
	  @Test
	  public void test12(){
	    assertEquals(0.34202, C.berechneC(70), 1e-5);
	  }
	  
	  /**
	   * tests C.berechneC(40)
	   * 
	   */
	  @Test
	  public void test13(){
	    assertEquals(0.76604, C.berechneC(40), 1e-5);
	  }
	  
	  /**
	   * tests C.berechneC(50)
	   * 
	   */
	  @Test
	  public void test14(){
	    assertEquals(0.64278, C.berechneC(50), 1e-5);
	  }
	  
	  /**
	   * tests C.berechneC(240)
	   * 
	   */
	  @Test
	  public void test15(){
	    assertEquals(-0.5, C.berechneC(240), 1e-5);
	  }
	  
	  /**
	   * tests C.berechneC(30)
	   * 
	   */
	  @Test
	  public void test16(){
	    assertEquals(0.86602, C.berechneC(30), 1e-5);
	  }
}
