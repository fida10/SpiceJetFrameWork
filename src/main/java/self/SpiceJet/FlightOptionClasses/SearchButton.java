package self.SpiceJet.FlightOptionClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static self.SpiceJet.OnStartUp.Initializer.dr;
import static self.SpiceJet.OnStartUp.Initializer.pro;

public class SearchButton {
	public static void clickSearchButton(){
		Actions a = new Actions(dr);
		a
				.moveToElement(dr.findElement(By.cssSelector(pro.getProperty("cssSelectTripsSearchButton"))))
				.click()
				.build()
				.perform();
	}
}
