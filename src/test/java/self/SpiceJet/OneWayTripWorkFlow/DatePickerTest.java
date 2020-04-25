package self.SpiceJet.OneWayTripWorkFlow;

import org.testng.annotations.Test;
import self.SpiceJet.Checks.CheckURLAndBoxesBeforeAndAfter;

import static self.SpiceJet.FlightOptionClasses.DatePicker.departDate;
import static self.SpiceJet.FlightOptionClasses.DatePicker.openDepDateBox;

public class DatePickerTest extends CheckURLAndBoxesBeforeAndAfter {
	@Test
	public void openDepartDateBox(){
		openDepDateBox();
	}
	@Test (dependsOnMethods = "openDepartDateBox")
	public void selectDate(){
		departDate();
	}
}
