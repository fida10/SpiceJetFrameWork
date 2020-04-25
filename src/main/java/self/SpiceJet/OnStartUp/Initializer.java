package self.SpiceJet.OnStartUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static self.SpiceJet.OnStartUp.PropertiesReferencer.absPath;
import static self.SpiceJet.OnStartUp.PropertiesReferencer.propPath;

public class Initializer {
	public static WebDriver dr;
	public static Properties pro;
	public static void webDriverInitializer() throws IOException {

		pro = new Properties();
		pro.load(propPath());

		System.setProperty(pro.getProperty("chromeKeyFile"), absPath().concat(pro.getProperty("pathToChromeDriver")));
		dr = new ChromeDriver();
		dr.manage().deleteAllCookies();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public static void getHomeUrl(){
		dr.get(pro.getProperty("url"));
	}
	public static void quitter(){
		System.out.println("All cases run, quitting.");
		dr.quit();
	}
}
