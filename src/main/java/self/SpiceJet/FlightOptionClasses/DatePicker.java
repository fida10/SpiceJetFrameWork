package self.SpiceJet.FlightOptionClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static self.SpiceJet.OnStartUp.Initializer.dr;
import static self.SpiceJet.OnStartUp.Initializer.pro;

public class DatePicker {
	public static void openDepDateBox(){ //clicks somewhere else, in this case on where it says "depart date", to exit out of the date box
		Actions a = new Actions(dr);
		a
				.moveToElement(dr.findElement(By.cssSelector(pro.getProperty("cssSelectOneWayDepDateBox"))))
				.click()
				.build()
				.perform();
	}
	public static void departDate(){
		String monthFirstLetterCapital = pro.getProperty("OneWayDepMonthFirstLetterCapital");
		String year = pro.getProperty("OneWayDepYear");
		String date = pro.getProperty("OneWayDepDate");

		Actions a = new Actions(dr);
		WebElement departDateBox = dr.findElement(By.cssSelector(pro.getProperty("cssSelectOneWayDepDateBox")));
		WebElement calendarBox = dr.findElement(By.xpath(pro.getProperty("xpathOneWayDepDatePicker"))); //this is ALWAYS present in the page, even when it isn't displayed. The below statement actually checks if it is displayed or not.
		while(true) { //this loop is in place because sometimes the page desyncs and clicks on the date box when it actually isn't available.
			try {
				if (calendarBox.isDisplayed())
					System.out.println("Box is displayed properly");
					break;
			} catch (NoSuchElementException e)
			{
				System.out.println("Box is not displayed, trying to click again");
				a
						.moveToElement(departDateBox)
						.click()
						.build()
						.perform();
			}
		}

		List<String> endOfCalendar = new ArrayList<>();
		endOfCalendar.add("dummyMonthAndYear1");
		endOfCalendar.add("dummyYearAndMonth2");

		while(true){
			String depMonth = dr.findElement(By.xpath(pro.getProperty("xpathOneWayDepMonth"))).getText();
			String depYear = dr.findElement(By.xpath(pro.getProperty("xpathOneWayDepYear"))).getText();
			if(depMonth.contains(monthFirstLetterCapital) && depYear.contains(year))
			{
				System.out.println("Reached desired month and year.");
				//Thread.sleep(100); //sometimes it will reach the desired month and click on the date too fast for the website to register it. A 100ms wait will seek to curb this. Activate this if it becomes too problematic and put in the exceptions
				break;
			}
			String currentMonthAndYear = depMonth + " " + depYear;
			endOfCalendar.add(currentMonthAndYear);
			String lastCalendarElement = endOfCalendar.get(endOfCalendar.size()-1);
			String secondToLastCalendarElement = endOfCalendar.get(endOfCalendar.size()-2);
			if(lastCalendarElement.equalsIgnoreCase(secondToLastCalendarElement))
			{
				System.out.println("Reached the end of the calendar, invalid date was selected.");
				Assert.assertFalse(lastCalendarElement.equalsIgnoreCase(secondToLastCalendarElement)); //forces the test to fail if the above statement is true, in other words, if the same month is coming over and over again.
				break;
			}
			a //this clicks on the next month arrow
					.moveToElement(dr.findElement(By.xpath(pro.getProperty("xpathOneWayDepDatePickerNextArrow"))))
					.click()
					.build()
					.perform();
		}
		a
				.moveToElement(dr.findElement(By.xpath(String.format(pro.getProperty("xpathOneWayDepDatePickerPathToDates").concat("[text()='%s']"), date)))) //this clicks on the date you want
				.click()
				.build()
				.perform();
	}
	public static void returnDate(String monthFirstLetterCapital, String year, String date){

	}
}
