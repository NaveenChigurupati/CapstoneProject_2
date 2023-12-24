package StepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.webdriverunivesity.pages.StepsForWDU;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinetionForWebDriverUnversity {
	
	

	private WebDriver driver;
	private StepsForWDU stepsforWDU;
	
	@Before
	public void setup() {
		driver=new ChromeDriver();
	}
	@After
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
		@Then("Launch chrome driver and open {string} url on chrome.")
		public void launch_chrome_driver_and_open_url_on_chrome(String url) {
			driver.get(url);
			driver.manage().window().maximize();
			stepsforWDU=new StepsForWDU(driver);
			assertTrue(stepsforWDU.verifyTitleOfPage());
			
			//Assert.assertEquals(stepsforWDU.verifyTitleOfPage(), false);
		}

		@When("User click on {string}")
		public void user_click_on(String elementToBeClicked) {
			//System.out.println("element is" + elementToBeClicked);
			stepsforWDU.clickOniframe(elementToBeClicked);
		}
		

		@When("verify new tab has opened and switch to that tab.")
		public void verify_new_tab_has_opened_and_switch_to_that_tab() {
		assertTrue(stepsforWDU.switch_to_that_tab());
		}

		@Then("user able to see images change while clicking arrows.")
		public void user_able_to_see_images_change_while_clicking_arrows() throws InterruptedException {
			stepsforWDU.verifyImageChanges();
		}




}
