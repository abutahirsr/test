package StepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@SuppressWarnings(value = { })
public class JavaCompilerPage {

	WebDriver driver;
	
	@Before
	public void beforeSuite() {
		
		System.out.println("User has reached JDoodle Java Compiler Page");
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Given("User is in JDoodle Online Java Compiler Page")
	public void user_is_in_j_doodle_online_java_compiler_page() throws Exception {
		
		driver.get("https://www.jdoodle.com/online-java-compiler");
		driver.manage().window().maximize();
		Thread.sleep(15000);
	}

	@When("Execute Button is present")
	public void execute_button_is_present() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Execute ']")));
		
		int numberofElements = driver.findElements(By.xpath("//button[text()=' Execute ']")).size();
		System.out.println("numberofElements: "+numberofElements);
		if(numberofElements > 0) {
			System.out.println("Execute Button is present");
		}else {
			
			System.out.println("Execute Button not present");
		}
	}

	@Then("User should be able to click on the Button")
	public void user_should_be_able_to_click_on_the_button() {
		Actions a = new Actions(driver);
		a.click(driver.findElement(By.xpath("//button[text()=' Execute ']"))).build().perform();
		//driver.findElement(By.xpath("//button[text()=' Execute ']")).click();
		System.out.println("Execute Button clicked");
	}
	
	@Then("User should be able to change font size")
	public void user_should_be_able_to_change_font_size() throws Exception {

		Thread.sleep(10000);
		Select fontSizeDropDown = new Select(driver.findElement(By.id("fontSizeSelect")));
	    fontSizeDropDown.selectByIndex(5);
	}

	@When("Light and Dark Mode Toggle is present")
	public void light_and_dark_mode_toggle_is_present() {

	    if(driver.findElement(By.xpath("//button[@aria-label='Toggle Light or Dark Mode']")).isDisplayed()) {
	    	System.out.println("Toggle is present");
	    }else {
	    	
	    	System.out.println("Toggle is not present");
	    }
	}

	@Then("User should be able to click on the Toggle")
	public void user_should_be_able_to_click_on_the_toggle() {

		driver.findElement(By.xpath("//button[@aria-label='Toggle Light or Dark Mode']")).click();
	}
	
	@Then("User should be able to find all the options in Navigation Pane")
	public void user_should_be_able_to_find_all_the_options_in_navigation_pane() {
	    List<WebElement> navigationOptions = driver.findElements(By.xpath("//div[@id='navbar-collapse-basic']//button"));
	    for(WebElement el:navigationOptions) {
	    	
	    	if((el.getText().contains("Products")) || (el.getText().trim().contains("Solutions")) || (el.getText().trim().contains("Resources")) || (el.getText().trim().contains("Pricing"))) {
	    		
	    		System.out.println("Expected Navigation Options present");
	    	}
	    }
	    
	}

	@When("User is able to find Login Button")
	public void user_is_able_to_find_login_button() {
	    if(driver.findElement(By.xpath("//div[contains(text(),'Login')]")).isDisplayed()){
	    	
	    	System.out.println("Login Button present");
	    	
	    }else {
	    	
	    	System.out.println("Login Button not present");
	    }
	}

	@Then("User should be able to click on the login button")
	public void user_should_be_able_to_click_on_the_login_button() throws Exception {
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
		Thread.sleep(3000);
	}
	
	@After
	public void tearDown() {
		
	    driver.close();
		driver.quit();
	}
}
