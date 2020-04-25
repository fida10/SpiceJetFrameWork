package self.SpiceJet.SignIn;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.TestRunner.PriorityWeight.dependsOnMethods;
import static self.SpiceJet.OnStartUp.Initializer.getHomeUrl;
import static self.SpiceJet.SignIn.SignIn.*;

public class SignInTest {
	@BeforeClass
	public void loginURL(){
		openLoginPage(); //opens the login URL
	}
	@Test
	public void signInUserName() throws InterruptedException{
		loginRealUserName();
		/*
		* There are several steps to sending the username (or phone number in this case)
		* First, the box must be clicked and an arbitrary (123) value is sent to the box
		* This is done so the country selection dropdown appears. The country specified in properties is selected
		* Once the country is selected, the arbitrary value given above disappears and the box becomes blank
		* Finally, the actual correct phone number is sent to the box.
		*/
	}
	@Test(dependsOnMethods = "signInUserName")
	public void signInPassWord(){
		loginRealPassWord(); //sends the password specified in properties to the password field
	}
	@Test(dependsOnMethods = "signInPassWord")
	public void clickOnSubmitButton(){
		clickSubmitButton(); //clicks on the submit button after credentials are entered
	}
	@Test(dependsOnMethods = "clickOnSubmitButton")
	public void logOutCurrentUser(){
		signOut(); //signs out the current user from spicejet website
	}
	@AfterClass
	public void returnToHomePage(){
		getHomeUrl(); //returns to the original home page, as the page after logging out vs the home page are different.
	}
}
