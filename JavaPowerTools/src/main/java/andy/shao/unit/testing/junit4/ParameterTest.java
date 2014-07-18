package andy.shao.unit.testing.junit4;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterTest {

	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
				{0.00, 2006,0.10},
				{10000.0,2008,1950.00}
		});
	}
	
	private volatile double revenue;
	private volatile int year;
	private volatile double expectedTax;
	
	public ParameterTest(double input, int year, double expectedTax) {
		this.revenue = input;
		this.year = year;
		this.expectedTax = expectedTax;
    }
	
	@Test
	public void test(){
		System.out.println(this.toString());
	}

	@Override
    public String toString() {
	    return "ParameterTest [revenue=" + revenue + ", year=" + year + ", expectedTax=" + expectedTax + "]";
    }
}
