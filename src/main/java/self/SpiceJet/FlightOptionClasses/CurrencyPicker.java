package self.SpiceJet.FlightOptionClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static self.SpiceJet.OnStartUp.Initializer.dr;
import static self.SpiceJet.OnStartUp.Initializer.pro;

public class CurrencyPicker {
	public static void currencyPicker(){
		Select currency = new Select(dr.findElement(By.cssSelector(pro.getProperty("cssSelectOneWayCurrencyBox"))));
		String currencySelection = pro.getProperty("OneWayCurrencyToUse");
		currency.selectByVisibleText(currencySelection);
	}
}
