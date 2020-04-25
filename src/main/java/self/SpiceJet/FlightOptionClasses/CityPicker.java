package self.SpiceJet.FlightOptionClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static self.SpiceJet.OnStartUp.Initializer.dr;
import static self.SpiceJet.OnStartUp.Initializer.pro;

public class CityPicker {
	public static void selectDepartureCityBox(){
		Actions a = new Actions(dr);
		a
				.moveToElement(
						dr.findElement(
								By.cssSelector(
										pro.getProperty("cssSelectOneWayDepInputBox"))))
				.click()
				.build()
				.perform();
	}
	public static void selectDepartureCity() {
		String depCityCode = pro.getProperty("OneWayDepCityCode");
		WebElement cityToSelectDep = dr.findElement(By.xpath("//html")); //just to initialize the cityToSelectDep variable. Every webpage as a //html tag, that's the base.
		try {
			cityToSelectDep = dr.findElement(By.xpath(String.format(pro.getProperty("xpathOneWayDepartureCitySelector").concat("[@value='%s']"), depCityCode))); //ensures that the desired city specified above in properties is actually displayed. If not, this will throw an exception of NoSuchElementException.
		} catch (NoSuchElementException e) {
			System.out.println("Element not found, invalid city selection");
			selectArrivalCityBox();
			Assert.assertTrue(cityToSelectDep.isDisplayed()); //Since it threw the exception, the desired city pair must then not be visible, which means this statement will cause a test failure and move on to the next test. It will also open up the arrival box with "selectArrivalCityBox()", as this will now not be done automatically due to the failure of this test.
		}
		Actions a = new Actions(dr);
		a
				.moveToElement(cityToSelectDep)
				.click()
				.build()
				.perform();
		Assert.assertTrue(dr.findElement(By.xpath(String.format("//input[@selectedvalue='%s']", depCityCode))).isDisplayed()); //ensures the clicked value above is the one selected in the "from" input box
	}
	public static void selectArrivalCityBox(){ /*website opens the arrival box automatically, test is redundant most of the time. However, if the departure city fails to select, arrival city box is not switched to automatically. This method seeks to remedy this, and it is called in selectDepartureCityBox when that test fails. */
		Actions a = new Actions(dr);
		a
				.moveToElement(
						dr.findElement(
								By.cssSelector(
										pro.getProperty("cssSelectOneWayArrInputBox"))))
				.click()
				.build()
				.perform();
	}
	public static void selectArrivalCity(){
		String arrCityCode = pro.getProperty("OneWayArrCityCode");

		WebElement cityToSelectArr = dr.findElement(By.xpath("//html"));
		try {
			cityToSelectArr = dr.findElement(By.xpath((String.format(pro.getProperty("xpathOneWayArrivalCitySelector").concat("[@value='%s']"), arrCityCode))));
		} catch (NoSuchElementException e) {
			System.out.println("Element not found, invalid city selection");
			Assert.assertTrue(cityToSelectArr.isDisplayed()); //ensures that the desired city specified above in properties is actually displayed. If not, test will fail.
		}

		Actions a = new Actions(dr);
		a
				.moveToElement(cityToSelectArr)
				.click()
				.build()
				.perform();
		Assert.assertTrue(dr.findElement(By.xpath(String.format("//input[@selectedvalue='%s']", arrCityCode))).isDisplayed()); //ensures the clicked value above is the one selected in the "to" input box
	}
}
