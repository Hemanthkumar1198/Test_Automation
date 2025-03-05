package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    
    public static void initReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        spark.config().setDocumentTitle("Automation Test Report");
        spark.config().setReportName("Selenium Test Execution");

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

   
    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

   
    public static ExtentTest getTest() {
        return test;
    }

    // Flush Report
    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
