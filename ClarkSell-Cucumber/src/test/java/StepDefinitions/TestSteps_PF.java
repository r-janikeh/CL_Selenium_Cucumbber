package StepDefinitions;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pagefactory.AngebotePage_PF;
import pagefactory.LoginPage_PF;
import pagefactory.WeiterQuestionsPage_PF;



public class TestSteps_PF {

	WebDriver driver = null;
	LoginPage_PF login;
	AngebotePage_PF AngeboteSteps;
	WeiterQuestionsPage_PF WeiterQuestions;


	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("=========Starting - browser is open===========");

		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is : "+projectPath);

		//setProperty for Windows
		//System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/deivers/chromedriver_win32/chromedriver.exe");

		//setProperty for Mac
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/deivers/chromedriver_mac64/chromedriver");

		driver = new ChromeDriver();
		driver.get("https://staging.clark.de/de/app/contracts");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}


	@And("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("Step1====user is on login page");
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {

		login = new LoginPage_PF(driver);

		login.enterUsername(username);
		login.enterPassword(password);
	}

	@And("user clicks on login")
	public void user_clicks_on_login() {
		System.out.println("Step2====user clicks on login");

		login.clickOnLogin();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("Step3====user is navigated to the home page");
	}

	@And("user clicks on Angebote button")
	public void user_clicks_on_angebote_button()  {

		AngeboteSteps = new AngebotePage_PF(driver);
		System.out.println("====== I am inside  AngebotePage_PF class ======");

		AngeboteSteps.clickOnAngebote();
	}

	@Then("user is navigated to the offers page")
	public void user_is_navigated_to_the_offers_page() {
		System.out.println("Step5====user is navigated to the offers page");
	}

	@And("user clicks on the Privathaftpflicht button")
	public void user_clicks_on_the_privathaftpflicht_button() {
		System.out.println("Step6====user clicks on the Privathaftpflicht button");

		AngeboteSteps.clickOnPrivathaftpflicht();
	}

	@Then("user is navigated to the Privathaftpflicht page")
	public void user_is_navigated_to_the_privathaftpflicht_page() {
		System.out.println("Step7====user is navigated to the Privathaftpflicht page");
	}

	@And("user clicks on Weiter button")
	public void user_clicks_on_weiter_button() {
		System.out.println("Step8====user clicks on Weiter button");

		AngeboteSteps.clickOnWeiter();
	}

	@Then("user is navigated to the Who do you want to insure? page")
	public void user_is_navigated_to_the_who_do_you_want_to_insure_page() {
		System.out.println("Step9====user is navigated to the Who do you want to insure? page");
	}

	@And("user answers the questions")
	public void user_answers_the_questions() throws InterruptedException {

		WeiterQuestions = new WeiterQuestionsPage_PF(driver);
		System.out.println("====== I am inside  WeiterQuestionsPage_PF class ======");
		System.out.println("Step10====user answers the questions");

		WeiterQuestions.clickOnWeiterAnswer1();
		Thread.sleep(3000);
		WeiterQuestions.clickOnWeiterAnswer2();
		Thread.sleep(3000);
		WeiterQuestions.clickOnWeiterAnswer3();
	}

	@Then("user is navigated to the feedback anfordern page")
	public void user_is_navigated_to_the_feedback_anfordern_page() {
		System.out.println("Step11====user is navigated to the feedback anfordern page");
	}

	@And("user enter TestFeatures and clicks on the Angebot anfordern button")
	public void user_enter_test_features_and_clicks_on_the_angebot_anfordern_button() {
		System.out.println("Step12====user enter 'TestFeatures' and clicks on the Angebot anfordern button");

		WeiterQuestions.enterFeedback();
		WeiterQuestions.clickOnAngebot_anfordern();
	}

	@Then("user is navigated to the Zum Angebot page")
	public void user_is_navigated_to_the_zum_angebot_page() {
		System.out.println("Step13==== Check Title  ======");

		String expectedTitle="Dein Angebot ist da!";
		Assert.assertEquals("Dein Angebot ist da!",driver.findElement(By.xpath("//h1[@class='_header_ie5k4r']")).getText());
		//System.out.println(driver.findElement(By.xpath("//h1[@class='_header_ie5k4r']")).getText());
		String actualTitle=driver.findElement(By.xpath("//h1[@class='_header_ie5k4r']")).getText();
		if(actualTitle.equals(expectedTitle)){
			System.out.println("=====Passed: Title Matched = Dein Angebot ist da======");
		}
		else{
			System.out.println("xxxxxxx- Failed: Title didn't match -xxxxxx");
		}
	}

	@And("user clicks on the Zum Angebot button")
	public void user_clicks_on_the_zum_angebot_button() {
		driver.findElement(By.xpath("//div[contains(@class,'_actions_yje2cq _orientation-vertical_yje2cq')]")).click();
		System.out.println("Step14====user clicks on the Zum Angebot button");
	}

	@Then("Test should end at {string} route")
	public void test_should_end_at_route(String expectedUrl) throws InterruptedException {
		System.out.println("Step15====Check Page");
		Thread.sleep(3000);
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		if(actualUrl.equals(expectedUrl)) {
			System.out.println("=====     Passed: The Url Matched     =======");
		}
		else{
			System.out.println("xxxxxxx- Failed: The Url didn't match -xxxxxx");
		}
	}


	@Then("verify the correct contract is shown on the manager route.")
	public void verify_the_correct_contract_is_shown_on_the_manager_route() {


		if(driver.getPageSource().contains("Privathaftpflicht")){
			System.out.println("Passed === The manager route show The contract.");
		}
		else
		{
			System.out.println("Failed === Tthe manager route did not show The contract.");
		}

		driver.close();
		driver.quit();

	}
}
