package core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;

public class ExtentReporter {
    protected static ExtentReports extentReports;
    protected static ExtentSparkReporter extentSparkReporter;

    //Expects the html path were to create the report
    public static ExtentReports generateExtentReport(String pathForReport, String reportConfigFilePath) throws IOException {

        extentSparkReporter = new ExtentSparkReporter(pathForReport);
        extentSparkReporter.loadXMLConfig(new File(reportConfigFilePath));

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        return extentReports;
    }
}
