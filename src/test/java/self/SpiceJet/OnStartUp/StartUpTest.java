package self.SpiceJet.OnStartUp;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import static self.SpiceJet.OnStartUp.Initializer.*;

public class StartUpTest {
	@BeforeSuite
	public void initialStartupTasks() throws IOException {
		webDriverInitializer();
		getHomeUrl();
	}
	@AfterSuite
	public void quit(){
		quitter();
	}
}
