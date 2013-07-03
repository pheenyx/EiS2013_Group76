import static org.junit.Assert.*;
import org.junit.Test;

/**
 * For sheet 11 exercise 3
 * This class tests a special function.
 *   
 * @author Sascha Fraenkel
 *
 */
public class Test2 {

	  /**
	   * tests A.berechneA(7)
	   * 
	   */
	  @Test
	  public void test1(){
	    assertEquals(16, A.berechneA(7));
	  }
	  
	  /**
	   * tests A.berechneA(16)
	   * 
	   */
	  @Test
	  public void test2(){
	    assertEquals(4, A.berechneA(16));
	  }
	  
	  /**
	   * tests A.berechneA(9)
	   * 
	   */
	  @Test
	  public void test3(){
	    assertEquals(19, A.berechneA(9));
	  }
	  
	  /**
	   * tests A.berechneA(8)
	   * 
	   */
	  @Test
	  public void test4(){
	    assertEquals(3, A.berechneA(8));
	  }
	  
	  /**
	   * tests A.berechneA(64)
	   * 
	   */
	  @Test
	  public void test5(){
	    assertEquals(6, A.berechneA(64));
	  }
	  
	  /**
	   * tests A.berechneA(5)
	   * 
	   */
	  @Test
	  public void test6(){
	    assertEquals(5, A.berechneA(5));
	  }
	  
	  /**
	   * tests A.berechneA(32)
	   * 
	   */
	  @Test
	  public void test7(){
	    assertEquals(5, A.berechneA(32));
	  }
	  
	  /**
	   * tests A.berechneA(3)
	   * 
	   */
	  @Test
	  public void test8(){
	    assertEquals(7, A.berechneA(3));
	  }
	  
	  /**
	   * tests A.berechneA(4)
	   * 
	   */
	  @Test
	  public void test9(){
	    assertEquals(2, A.berechneA(4));
	  }
	  
	  /**
	   * tests A.berechneA(1)
	   * 
	   */
	  @Test
	  public void test10(){
	    assertEquals(0, A.berechneA(1));
	  }
	  
	  /**
	   * tests A.berechneA(10)
	   * 
	   */
	  @Test
	  public void test11(){
	    assertEquals(6, A.berechneA(10));
	  }
	  
	  /**
	   * tests A.berechneA(6)
	   * 
	   */
	  @Test
	  public void test12(){
	    assertEquals(8, A.berechneA(6));
	  }
	  
	  /**
	   * tests A.berechneA(2)
	   * 
	   */
	  @Test
	  public void test13(){
	    assertEquals(1, A.berechneA(2));
	  }
	  
	  /**
	   * tests A.berechneA(20)
	   * 
	   */
	  @Test
	  public void test14(){
	    assertEquals(7, A.berechneA(20));
	  }
	  
	  /**
	   * tests A.berechneA(40)
	   * 
	   */
	  @Test
	  public void test15(){
	    assertEquals(8, A.berechneA(40));
	  }
	  
	  /**
	   * tests A.berechneA(27)
	   * 
	   */
	  @Test
	  public void test16(){
	    assertEquals(111, A.berechneA(27));
	  }
}
