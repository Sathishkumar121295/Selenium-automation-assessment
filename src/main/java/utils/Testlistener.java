package utils;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base.Baseclass;

public class Testlistener implements ITestListener {
	@Override
	public void onTestFailure(ITestResult result) {

	    Baseclass base = (Baseclass) result.getInstance();

	    try {
	        base.screenshot(result.getName());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	@Override
	public void onTestSuccess(ITestResult result) {
	    System.out.println("Test passed: " + result.getName());
	}

}