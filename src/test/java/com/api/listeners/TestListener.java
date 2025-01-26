package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	
	private static final Logger logger=LogManager.getLogger(TestListener.class);
	public void onTestStart(ITestResult result) {
		logger.info("Test has started");
		  }
	public void onTestSuccess(ITestResult result) {
	    logger.info("Test is successful: "+result.getMethod().getMethodName());
	  }
	public void onTestFailure(ITestResult result) {
	    logger.error("Test has failed"+result.getMethod().getMethodName());
	  }
	public void onTestSkipped(ITestResult result) {
	    logger.info("Test is skipped"+result.getMethod().getMethodName());
	  }
	public void onFinish(ITestContext context) {
	    logger.info("Test has completed");
	  }

}
