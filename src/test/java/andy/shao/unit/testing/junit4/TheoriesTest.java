package andy.shao.unit.testing.junit4;

import java.math.BigDecimal;

//import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assume.assumeThat;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoriesTest {

	@DataPoint
	public static int YEAR_2007 = 2007;
	@DataPoint
	public static int YEAR_2008 = 2008;
	@DataPoint
	public static BigDecimal INCOME_1 = new BigDecimal(0.0);
	@DataPoint
	public static double INCOME_2 = 0.01;
	@DataPoint
	public static double INCOME_3 = 100.0;
	@DataPoint
	public static double INCOME_4 = 13999.99;
	@DataPoint
	public static double INCOME_5 = 14000.0;
	
    @SuppressWarnings("unchecked")
    @Theory
	public void lowTaxRateIsNineteenPercent(int year, double income){
		assumeThat(year, is(2007));
		assumeThat(income, allOf(greaterThan(0.00), lessThan(14000.00)));
		
		System.out.println("year=" + year + ",income=" + income);
	}
}
