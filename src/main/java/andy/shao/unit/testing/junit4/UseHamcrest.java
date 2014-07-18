package andy.shao.unit.testing.junit4;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class UseHamcrest {

	@Test
	public void testIs(){
		double d = 0.0;
		assertThat(d, is(0.0));
	}
	
	@SuppressWarnings("unchecked")
    @Test
	public void testEqualTo(){
		String result = "red";
		assertThat(result, equalTo("red"));
		assertThat(result, anyOf(is("red"), is("green"), is("yellow")));
		assertThat("black is black", result, is("black"));//If has the error show the message is: black is black.
	}
	
}
