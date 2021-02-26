package testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;

public class SearchTest extends Base {
	
	String searchText = "lg washing machine";
	String brandName = "LG";

	@Test
	public void testSearchLG() throws IOException {
		HomePage hm = new HomePage(driver);
		hm.searchBar(searchText).selectBrand(brandName).getProductDetails();
	}
	
	
	

	/*@DataProvider(name = "DP")
	public String[][] getData() {

		String[][] data = new String[2][2];

		data[0][0] = "lg washing machine";
		data[0][1] = "LG";

		data[1][0] = "Samsung washing machine";
		data[1][1] = "Samsung";

		return data;

	}*/

}
