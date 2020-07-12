package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngebotePage_PF {

					
	@FindBy(xpath="//ul[contains(@class,'_segment_15ir2n _sections_1rlfr8')]//li[4]")
	WebElement btn_angebote;

	@FindBy(xpath="//div[contains(@class,'_grid_1kwtt9')]//div//div[1]//div[1]//div[1]//div[1]")
	WebElement btn_privathaftpflicht;

	@FindBy(xpath="//span[text()='Weiter']")
	WebElement btn_weiter;


	WebDriver driver;

	public AngebotePage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		//AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		//PageFactory.initElements(factory, this);
	}


	public void clickOnAngebote() {
		btn_angebote.click();
	}

	public void clickOnPrivathaftpflicht() {
		btn_privathaftpflicht.click();
	}

	public void clickOnWeiter() {
		btn_weiter.click();
	}
}
