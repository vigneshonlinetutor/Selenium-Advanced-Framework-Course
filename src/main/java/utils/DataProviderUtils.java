package utils;

import constants.FrameworkConstants;
import exceptions.InvalidFilePathException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class DataProviderUtils {

    private DataProviderUtils(){}

    @DataProvider(name="LoginTestData",parallel = true)
    public static Object[] getData(){
        Object[] data = null;
        try(FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelFilePath());) {
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet("Data");
            int rowNum = sheet.getLastRowNum();
            int colNum = sheet.getRow(0).getLastCellNum();
            data = new Object[rowNum];
            Map<String,String> map;
            for(int i=1;i<=rowNum;i++){
                map= new HashMap<>();
                for(int j=0;j<colNum;j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key,value);
                    data[i-1]=map;
                }
            }
        } catch (FileNotFoundException e) {
            throw new InvalidFilePathException("File not found. Please check the file name mentioned in Line:22",e);
        }
         catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
