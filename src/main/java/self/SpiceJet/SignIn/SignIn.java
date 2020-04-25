package self.SpiceJet.SignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static self.SpiceJet.OnStartUp.Initializer.dr;
import static self.SpiceJet.OnStartUp.Initializer.pro;

public class SignIn {
	public static void openLoginPage(){
		dr.get(pro.getProperty("signInURL"));
	}
	public static void loginRealUserName() throws InterruptedException{
		String userName = pro.getProperty("realPhoneNo");
		Actions a = new Actions(dr);
		a
				.moveToElement(dr.findElement(By.xpath(pro.getProperty("xpathLoginPhoneNumberBox"))))
				.click()
				.sendKeys("123")
				.build()
				.perform();
		Thread.sleep(200); //executes far too fast, forces the page downwards and doesn't allow the page to catch up. This could be due to the dynamic nature of the dropdown, so a forced wait must be instated.
		a
				.moveToElement(dr.findElement(By.xpath(pro.getProperty("xpathLoginCountryBox"))))
				.click()
				.sendKeys("United States")
				.moveToElement(dr.findElement(By.xpath(pro.getProperty("xpathLoginIndividualCountries").concat(String.format("'%s']", pro.getProperty("xpathLoginIndividualCountrySelection"))))))
				.click()
				.build()
				.perform();
		a
				.moveToElement(dr.findElement(By.xpath(pro.getProperty("xpathLoginPhoneNumberBox"))))
				.click()
				.sendKeys(userName)
				.build()
				.perform();
	}
	public static void loginRealPassWord(){
		String passWord = pro.getProperty("realPassword");
		Actions a = new Actions(dr);
		a
				.moveToElement(dr.findElement(By.xpath(pro.getProperty("xpathLoginPasswordBox"))))
				.click()
				.sendKeys(passWord)
				.build()
				.perform();
	}
	public static void clickSubmitButton(){
		Actions a = new Actions(dr);
		a
				.moveToElement(dr.findElement(By.xpath(pro.getProperty("xpathLoginSubmitButton"))))
				.click()
				.build()
				.perform();
	}
	public static void signOut(){
		dr.findElement(By.xpath(pro.getProperty("xpathLogoutButton"))).click();
	}
} //handle scenario where invalid credential is given
