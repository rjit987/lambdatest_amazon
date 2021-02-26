package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#twotabsearchtextbox")
	WebElement searchBar;
	
	@FindBy(css="#nav-search-submit-button")
	WebElement searchBtn;
	
	public SearchResultPage searchBar(String value) {
		
		searchBar.sendKeys(value);
		searchBtn.click();
		return new SearchResultPage(driver);	}

}
