package self.SpiceJet.OneWayTripWorkFlow;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static self.SpiceJet.Checks.CheckURLAndBoxesBeforeAndAfter.ensureCorrectConditions;
import static self.SpiceJet.FlightOptionClasses.SearchButton.clickSearchButton;
import static self.SpiceJet.SubsidiaryHelpers.EnsureCorrectURL.ensureCorrectHomeURL;

public class SearchButtonTest {
	@BeforeClass
	public void checkURLAndCloseBoxes(){ //Ensures correct URL and closes any open boxes
		ensureCorrectConditions();
	} //this is only run in the beginning as the search results will appear in a new URL which we want, so no point switching back to home URL after that one.
	@Test
	public void clickOnSearchButton(){
		clickSearchButton();
	}
}