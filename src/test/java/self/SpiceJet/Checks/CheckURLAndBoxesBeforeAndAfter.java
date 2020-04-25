package self.SpiceJet.Checks;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static self.SpiceJet.SubsidiaryHelpers.EnsureCorrectURL.ensureCorrectHomeURL;
import static self.SpiceJet.SubsidiaryHelpers.ExitOutOfOpenBox.exitOutOfOpenBox;

public class CheckURLAndBoxesBeforeAndAfter {
	@BeforeClass
	public static void ensureCorrectConditions() { //Ensures any open boxes, are not open and the URL is correct
		ensureCorrectHomeURL();
		exitOutOfOpenBox();
	}
	@AfterClass
	public void ensureBoxClosed(){
		exitOutOfOpenBox();
	}
}
