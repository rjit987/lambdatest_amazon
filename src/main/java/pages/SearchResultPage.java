package pages;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CreateTextFile;
import utilities.MapSortingDec;

public class SearchResultPage {
	WebDriver driver;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(css = "#brandsRefinements")
	WebElement brandsBox;

	
	public SearchResultPage selectBrand(String brand) throws IOException {

		List<WebElement> brandNames = brandsBox.findElements(By.cssSelector(".a-size-base.a-color-base"));

		for (WebElement name : brandNames) {

			if (name.getText().contains(brand)) {
				name.click();
				break;
			}
		}return new SearchResultPage(driver);

	}

	@FindBy(css = ".a-pagination")
	WebElement pagination;

	public void pagination() {

	}
	
	
	@FindBy(css = ".s-main-slot.s-result-list.s-search-results.sg-row")
	WebElement allSearchItems;
	
	@FindBy(css = ".a-size-medium.a-color-base.a-text-normal")
	WebElement brandsName;
	
	public void getProductDetails() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		List<WebElement> allPrice = allSearchItems.findElements(By.cssSelector(".a-price-whole"));
		List<WebElement> allName = allSearchItems
				.findElements(By.cssSelector(".a-size-medium.a-color-base.a-text-normal"));

		for (int i = 0; i < allPrice.size(); i++) {
			// System.out.println(allName.get(i).getText()+" "+allPrice.get(i).getText());
			String[] a = allPrice.get(i).getText().split(",");
			String c = "";
			for (String b : a) {
				c = c + b;
			}

			map.put(allName.get(i).getText(), Integer.parseInt(c));

		}

		MapSortingDec sortMap = new MapSortingDec();
		Map<String, Integer> hm1 = MapSortingDec.sortByValue(map);

		// print the sorted hashmap
		for (Map.Entry<String, Integer> en : hm1.entrySet()) {
			
			//print in console
			System.out.println("Key = " + en.getKey() + ", Value = " + en.getValue());

			// Printing to text file
			CreateTextFile c = new CreateTextFile();
			c.createTextFile(("Key = " + en.getKey() + ", Value = " + en.getValue()));
		}

	}

}
