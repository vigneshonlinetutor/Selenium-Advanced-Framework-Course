package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.FrameworkConstants;
import enums.CategoryTypes;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport(){}

    private static ExtentReports extent;

    public static void initReports(){
        if(Objects.isNull(extent)){
            extent=new ExtentReports();
            ExtentSparkReporter spark = null;
            try {
                spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
            extent.attachReporter(spark);

            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Selenium Automation Report");
            spark.config().setReportName("Automation Test Report");
        }
    }

    public static void flushReports() {
        if(Objects.nonNull(extent)){
            extent.flush();
            try {
                Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
            ExtentManager.unload();
        }
    }

    public static void createTest(String testCaseName){
        ExtentTest test=extent.createTest(testCaseName);
        ExtentManager.setExtentTest(test);
    }

    public static void addCategories(CategoryTypes[] categories){
        for(CategoryTypes category:categories){
            ExtentManager.getExtentTest().assignCategory(category.toString());
        }
    }
}
