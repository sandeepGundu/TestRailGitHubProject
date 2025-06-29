package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initReport() {
        /*extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
        extent.attachReporter(spark);*/

        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
    }

    public static void startTest(String testName) {
        if (extent == null) {
            throw new IllegalStateException("ExtentReports is not initialized. Call initReport() first.");
        }
        test = extent.createTest(testName);
    }

    public static void logInfo(String message) {
        if (test != null) {
            test.info(message);
        }
    }

    public static void logFail(String message) {
        if (test != null) {
            test.fail(message);
        }
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}