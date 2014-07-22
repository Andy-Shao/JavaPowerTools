package andy.shao.unit.testing.junit4.junitperf;

import com.clarkware.junitperf.ExampleTestCase;
import com.clarkware.junitperf.LoadTest;
import com.clarkware.junitperf.TimedTest;

import junit.framework.Test;
import junit.textui.TestRunner;

public class ExampleResponseTimeUnderLoadTest {
	
	public static Test suite(){
		int maxUsers = 10;
		long maxElapsedTime = 1500;
		
		Test testCase = new ExampleTestCase("testOneSecondResponse");
		Test timeTest = new TimedTest(testCase, maxElapsedTime);
		Test loadTset = new LoadTest(timeTest, maxUsers);
		
		return loadTset;
	}

	public static void main(String[] args) {
	    TestRunner.run(suite());
    }
}
