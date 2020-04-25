package self.SpiceJet.OneWayTripWorkFlow;

import org.testng.annotations.Test;
import self.SpiceJet.Checks.CheckURLAndBoxesBeforeAndAfter;

import static self.SpiceJet.FlightOptionClasses.PaxPicker.adultChildInfantNoPicker;

public class PaxPickerTest extends CheckURLAndBoxesBeforeAndAfter {
	@Test
	public void pickPax() throws InterruptedException {
		adultChildInfantNoPicker();
	}
}
