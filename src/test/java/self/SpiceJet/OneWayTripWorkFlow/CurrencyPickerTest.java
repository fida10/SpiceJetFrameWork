package self.SpiceJet.OneWayTripWorkFlow;

import org.testng.annotations.Test;
import self.SpiceJet.Checks.CheckURLAndBoxesBeforeAndAfter;

import static self.SpiceJet.FlightOptionClasses.CurrencyPicker.currencyPicker;

public class CurrencyPickerTest extends CheckURLAndBoxesBeforeAndAfter {
	@Test
	public void pickCurrency(){
		currencyPicker();
	}
}
