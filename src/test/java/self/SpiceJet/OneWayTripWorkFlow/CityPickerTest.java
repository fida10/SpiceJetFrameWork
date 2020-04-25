package self.SpiceJet.OneWayTripWorkFlow;

import org.testng.annotations.Test;
import self.SpiceJet.Checks.CheckURLAndBoxesBeforeAndAfter;

import static self.SpiceJet.FlightOptionClasses.CityPicker.*;

public class CityPickerTest extends CheckURLAndBoxesBeforeAndAfter {
	@Test
	public void selectDepCity(){
		selectDepartureCityBox();
		selectDepartureCity();
	}
	@Test(dependsOnMethods = "selectDepCity")
	public void selectArrCity(){
		selectArrivalCity();
	}
}
