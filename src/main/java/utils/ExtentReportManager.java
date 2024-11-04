package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    ExtentReports reports;

    ExtentSparkReporter spark;

    ExtentTest logger;
    CommonUtils commonUtils = new CommonUtils();


    public void startReport() {
        setExtentReportsInstance();
        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExtentReports/" + "ExtentReport" + commonUtils.getDateFormat() + ".html");
        getExtentReportsInstance().attachReporter(spark);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Sauce Demo");
        spark.config().setReportName("Sauce Demo Test Report");

    }

    public void setExtentReportsInstance() {
        reports = new ExtentReports();
    }

    public ExtentReports getExtentReportsInstance() {
        return reports;
    }


    public ExtentTest getExtentTest(String testName) {
        logger = getExtentReportsInstance().createTest(testName);
        return logger;
    }


    public void endReport() {
        reports.flush();

    }
}
