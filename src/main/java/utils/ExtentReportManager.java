package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.Config;
import constants.Report;

public class ExtentReportManager {

    ExtentReports reports;

    ExtentSparkReporter spark;

    ExtentTest logger;
    CommonUtils commonUtils = new CommonUtils();

    public void startReport() {
        if (reports == null) {
            setExtentReportsInstance();
            spark = new ExtentSparkReporter(Report.REPORT_FOLDER + commonUtils.getDateFormat() + ".html");
            getExtentReportsInstance().attachReporter(spark);
            spark.config().setTheme(Report.DEFAULT_THEME);
            spark.config().setDocumentTitle(Report.REPORT_TITLE);
            spark.config().setReportName(Report.REPORT_NAME);
        }

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
