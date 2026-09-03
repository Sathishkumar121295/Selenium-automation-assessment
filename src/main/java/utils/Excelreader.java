package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;

public class Excelreader {
    private Workbook workbook;
    public Excelreader(String filepath) throws IOException {
    	FileInputStream fin=new FileInputStream(filepath);
        workbook= new XSSFWorkbook(fin);
    }
   
    	public String getCellData(String sheetname, int row, int column) {

    	    DataFormatter formatter = new DataFormatter();

    	    return formatter.formatCellValue(workbook.getSheet(sheetname).getRow(row).getCell(column));
    	                    
    	    
    	
    }
    public int getRowCount(String sheetname) {
        return workbook.getSheet(sheetname).getPhysicalNumberOfRows();
    }
    
}
