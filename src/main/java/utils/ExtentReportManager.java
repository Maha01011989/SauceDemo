package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import constants.Report;

public class ExtentReportManager {

    static ExtentReports reports;

    static ExtentSparkReporter spark;

    ExtentTest logger;


    public ExtentReports startReport() {
        if (reports == null) {
            reports = new ExtentReports();
            spark = new ExtentSparkReporter(Report.REPORT_FOLDER );
            reports.attachReporter(spark);
            spark.config().setTheme(Report.DEFAULT_THEME);
            spark.config().setDocumentTitle(Report.REPORT_TITLE);
            spark.config().setReportName(Report.REPORT_NAME);
        }
        return reports;
    }


    public ExtentTest getExtentTest(String testName) {
        logger = reports.createTest(testName);
        return logger;
    }


    public void endReport() {
        reports.flush();

    }
}
