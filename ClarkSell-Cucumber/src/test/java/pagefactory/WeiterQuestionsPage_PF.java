package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeiterQuestionsPage_PF {



	@FindBy(xpath="//h2[text()='Mich alleine']")
	WebElement btn_weiterAnswer1;

	@FindBy(xpath="//h2[text()='Ich bin im öffentlichen Dienst beschäftigt']")
	WebElement btn_weiterAnswer2;

	
	@FindBy(xpath="//div[contains(@class,'questionnaire__bg-container')]//li[1]")
	WebElement btn_weiterAnswer3;

	@FindBy(xpath="//input[contains(@class,'form-list__item__input cucumber-text-input text-field-answer')]")
	WebElement txt_feedback;

	@FindBy(xpath="//button[contains(@class,'btn btn-primary btn--arrow btn--mobile-block btn-next-split')]")
	WebElement btn_angebot_anfordern;


	WebDriver driver;

	public WeiterQuestionsPage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void clickOnWeiterAnswer1() {
		btn_weiterAnswer1.click();
	}

	public void clickOnWeiterAnswer2() {
		btn_weiterAnswer2.click();
	}

	public void clickOnWeiterAnswer3() {
		btn_weiterAnswer3.click();
	}

	public void enterFeedback() {
		txt_feedback.sendKeys("Test Features");
	}

	public void clickOnAngebot_anfordern() {
		btn_angebot_anfordern.click();
	}




}
