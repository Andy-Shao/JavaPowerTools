package andy.shao.unit.testing.junit4.junitperf;

import com.clarkware.junitperf.ExampleTestCase;
import com.clarkware.junitperf.LoadTest;
import com.clarkware.junitperf.TimedTest;

import junit.framework.Test;
import junit.textui.TestRunner;

public class ExampleThroughputUnderLoadTest {
	
	public static Test suite(){
		int maxUsers = 10;
		long maxElapsedTime = 1500;
		
		Test testCase = new ExampleTestCase("testOneSecondResponse");
		Test loadTset = new LoadTest(testCase, maxUsers);
		Test timeTest = new TimedTest(loadTset, maxElapsedTime);
		
		return timeTest;
	}

	public static void main(String[] args) {
	    TestRunner.run(suite());
    }
}
