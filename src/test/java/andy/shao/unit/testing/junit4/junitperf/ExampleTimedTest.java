package andy.shao.unit.testing.junit4.junitperf;

import com.clarkware.junitperf.ExampleTestCase;
import com.clarkware.junitperf.TimedTest;

import junit.framework.Test;
import junit.textui.TestRunner;

public class ExampleTimedTest {

	public static Test suite(){
		long maxElapsedTime = 1500;
//		long maxElapsedTime = 1000;
		
		Test testCase = new ExampleTestCase("testOneSecondResponse");
		Test timeTest = new TimedTest(testCase, maxElapsedTime);
		
		return timeTest;
	}
	
	public static void main(String[] args) {
	    TestRunner.run(suite());
    }
}
