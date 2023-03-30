package com.bridgelabz.baseclass;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListener extends BaseClass implements  ITestListener{
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("OnTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("OnTestFailure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }
}
