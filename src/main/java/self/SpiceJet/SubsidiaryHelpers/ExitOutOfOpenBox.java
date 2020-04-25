package self.SpiceJet.SubsidiaryHelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static self.SpiceJet.OnStartUp.Initializer.dr;
import static self.SpiceJet.OnStartUp.Initializer.pro;

public class ExitOutOfOpenBox {
	public static void exitOutOfOpenBox(){ //clicks on a predetermined, non functional point on the screen to exit out of any box currently open that might be stopping the test
		Actions a = new Actions(dr);
		a
				.moveToElement(dr.findElement(By.xpath(pro.getProperty("xpathHomePageARandomPoint"))))
				.click()
				.build()
				.perform();
	}
}
