import static org.junit.Assert.*;
import org.junit.Test;

/**
 * For sheet 11 exercise 3
 * This class tests a special function.
 *   
 * @author Sascha Fraenkel
 *
 */
public class Test3 {

	  /**
	   * tests B.berechneB(18)
	   * 
	   */
	  @Test
	  public void test1(){
	    assertEquals(1, B.berechneB(18));
	  }
	  
	  /**
	   * tests B.berechneB(2)
	   * 
	   */
	  @Test
	  public void test2(){
	    assertEquals(4, B.berechneB(2));
	  }
	  
	  /**
	   * tests B.berechneB(4)
	   * 
	   */
	  @Test
	  public void test3(){
	    assertEquals(16, B.berechneB(4));
	  }
	  
	  /**
	   * tests B.berechneB(0)
	   * 
	   */
	  @Test
	  public void test4(){
	    assertEquals(1, B.berechneB(0));
	  }
	  
	  /**
	   * tests B.berechneB(9)
	   * 
	   */
	  @Test
	  public void test5(){
	    assertEquals(18, B.berechneB(9));
	  }
	  
	  /**
	   * tests B.berechneB(1)
	   * 
	   */
	  @Test
	  public void test6(){
	    assertEquals(2, B.berechneB(1));
	  }
	  
	  /**
	   * tests B.berechneB(3)
	   * 
	   */
	  @Test
	  public void test7(){
	    assertEquals(8, B.berechneB(3));
	  }
	  
	  /**
	   * tests B.berechneB(19)
	   * 
	   */
	  @Test
	  public void test8(){
	    assertEquals(2, B.berechneB(19));
	  }
	  
	  /**
	   * tests B.berechneB(5)
	   * 
	   */
	  @Test
	  public void test9(){
	    assertEquals(13, B.berechneB(5));
	  }
	  
	  /**
	   * tests B.berechneB(22)
	   * 
	   */
	  @Test
	  public void test10(){
	    assertEquals(16, B.berechneB(22));
	  }
	  
	  /**
	   * tests B.berechneB(21)
	   * 
	   */
	  @Test
	  public void test11(){
	    assertEquals(8, B.berechneB(21));
	  }
	  
	  /**
	   * tests B.berechneB(23)
	   * 
	   */
	  @Test
	  public void test12(){
	    assertEquals(13, B.berechneB(23));
	  }
	  
	  /**
	   * tests B.berechneB(20)
	   * 
	   */
	  @Test
	  public void test13(){
	    assertEquals(4, B.berechneB(20));
	  }
	  
	  /**
	   * tests B.berechneB(28)
	   * 
	   */
	  @Test
	  public void test14(){
	    assertEquals(17, B.berechneB(28));
	  }
	  
	  /**
	   * tests B.berechneB(36)
	   * 
	   */
	  @Test
	  public void test15(){
	    assertEquals(1, B.berechneB(36));
	  }
	  
	  /**
	   * tests B.berechneB(38)
	   * 
	   */
	  @Test
	  public void test16(){
	    assertEquals(4, B.berechneB(38));
	  }
}
