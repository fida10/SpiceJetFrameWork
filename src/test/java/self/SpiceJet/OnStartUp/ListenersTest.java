package self.SpiceJet.OnStartUp;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import self.SpiceJet.OnStartUp.ScreenShotMethods;

import java.io.IOException;

public class ListenersTest implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test succeeded, taking screenshot");
		try {
			ScreenShotMethods.screenShotTaker("pass");
		}
		catch (IOException e){
			System.out.println("IO exception occurred");
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test has failed, taking screenshot");
		try {
			ScreenShotMethods.screenShotTaker("fail");
		}
		catch (IOException e){
			System.out.println("IO exception occured");
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test has skipped, taking screenshot");
		try {
			ScreenShotMethods.screenShotTaker("skip");
		} catch (IOException e){
			System.out.println("IO exception occured");
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}
}
