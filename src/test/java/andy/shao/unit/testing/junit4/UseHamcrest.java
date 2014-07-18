package andy.shao.unit.testing.junit4;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
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
		String color = "red";
		assertThat(color, equalTo("red"));
		assertThat(color, anyOf(is("red"), is("green"), is("yellow")));
		assertThat("red is red", color, is("red"));//If has the error show the message is: read is read.
		assertThat(color, is(not("white")));
	}
	
	@Test
	public void testHas(){
		{
			List<String> colors = Arrays.asList("red", "green", "yellow");
			assertThat(colors, Matchers.hasItem("red"));
		}
		
		{
			List<Integer> ages = Arrays.asList(20, 30, 40);
			assertThat(ages, not(Matchers.hasItem(Matchers.lessThan(18))));
			assertThat(20, Matchers.isIn(ages));
		}
		
		{
			Map<String, String> map = new HashMap<String, String>();
			map.put("color", "red");
			
			assertThat(map, Matchers.<String,String>hasValue("red"));
			assertThat(map, Matchers.<String,String>hasKey("color"));
		}
		
//		{
//			UseHamcrest.Client client = this.new Client("Jane");
//			
//			assertThat(client, Matchers.hasProperty("clientName", is("Jane")));
//		}
	}
	
	@SuppressWarnings("unused")
	private class Client{
		private String clientName;
		
		public Client(String clientName) {
			this.clientName = clientName;
        }

        public String getClientName() {
        	return clientName;
        }

        public void setClientName(String clientName) {
        	this.clientName = clientName;
        }
	}
}
