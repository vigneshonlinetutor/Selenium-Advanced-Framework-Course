package constants;

import enums.ConfigProperties;
import utils.ReadPropertyFile;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FrameworkConstants {

    // 1. Always constant should be declared as final
    // 2. Access modifier of the constants need to be private
    // 3. Getter to access the constant
    // 4. Create a private constructor

    private FrameworkConstants(){}

    private static final String CONFIGFILEPATH = System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
    private static final int WAITTIMEINSECONDS = 10;
    private static final String EXCELFILEPATH = System.getProperty("user.dir")+"/src/test/resources/excel/testData.xlsx";
    private static final String EXCELRUNMANAGER = System.getProperty("user.dir")+"/src/test/resources/excel/TestRunManager.xlsx";
    private static final String EXTENTREPORTFOLDERPATH=System.getProperty("user.dir")+"/extent-test-output/";
    private static String extentReportFilePath="";
    private static final String SELENIUMGRIDURL="http://localhost:4444/wd/hub";

    public static String getConfigfilepath() {
        return CONFIGFILEPATH;
    }

    public static int getWaitTimeInSeconds() {
        return WAITTIMEINSECONDS;
    }

    public static String getExcelFilePath() {
        return EXCELFILEPATH;
    }

    public static String getExcelRunManager() {
        return EXCELRUNMANAGER;
    }

    public static String getExtentReportFilePath() {
        if(extentReportFilePath.isEmpty()){
            extentReportFilePath=createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath(){
        if(ReadPropertyFile.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")){
            return EXTENTREPORTFOLDERPATH+"index.html";
        }
        else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyy_HH:mm:ss");
            Date date = new Date();
            return EXTENTREPORTFOLDERPATH+formatter.format(date)+"_"+"index.html";
        }
    }

    public static String getSeleniumGridUrl() {
        return SELENIUMGRIDURL;
    }

}
