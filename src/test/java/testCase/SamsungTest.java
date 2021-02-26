package testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;

public class SamsungTest extends Base {
	
	
	
	@Test
	public void testSearchSamsung() throws IOException {
		HomePage hm =new HomePage(driver);
		hm.searchBar("samsung washing machine").selectBrand("Samsung");
		
		
	}

}
