package self.SpiceJet.SubsidiaryHelpers;

import org.testng.Assert;

import static self.SpiceJet.OnStartUp.Initializer.dr;
import static self.SpiceJet.OnStartUp.Initializer.pro;

public class EnsureCorrectURL {
	public static void ensureCorrectHomeURL(){
		String currentURL = dr.getCurrentUrl();
		String homeURL = pro.getProperty("url");
		if(!currentURL.equalsIgnoreCase(homeURL)){
			System.out.println("Incorrect URL, getting the correct one");
			dr.get(homeURL);
		} else {
			System.out.println("On the right URL, proceeding");
		}
		Assert.assertTrue(currentURL.equalsIgnoreCase(homeURL));
	}
}
