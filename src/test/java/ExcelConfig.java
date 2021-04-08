import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {
	 XSSFSheet sheet;
	  XSSFWorkbook workbook;
	FileOutputStream os;
	FileInputStream is;
	File file;
	public ExcelConfig()  {
		
		 file = new File("C:\\Users\\minbal521\\Documents\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\SeleniumMavenGitHubJenkins\\ExcelReports\\Book1.xlsx");
try {
	
	System.out.println("outputstream created");
	 is= new FileInputStream(file);
	 System.out.println("inputstream created");
	 
	 workbook = new XSSFWorkbook(is);
//	sheet = new XSSFSheet
	 System.out.println("workbook created");
	 sheet = workbook.getSheet("Sheet1");
	 System.out.println("after sheet");
	 System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
}
catch(Exception e) {
System.out.println(e.getStackTrace());

}

}
	

     
    
  
       
   
     
   
	public void passData(String action, int row, int col) throws IOException {
		
		int rowCount = sheet.getLastRowNum();
		
		String[][] data = new String[5][3];
		// data[row][col] = action;
		
		 
		 sheet.getRow(row).createCell(col).setCellValue(action);
	
		 os = new FileOutputStream(file);
		 workbook.write(os);
		 
		
	}
	
	
	public int getRowCount() {
	
		return	sheet.getLastRowNum()+1;
	}
	
}
