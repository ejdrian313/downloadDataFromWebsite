import junit.framework.*;

public class TestsRunner {
   public static void main(String[] a) {
      TestSuite suite = new TestSuite(SensorTest.class);
      TestResult result = new TestResult();
      suite.run(result);
      System.out.println("Number of test cases = " + result.runCount());
   }
}