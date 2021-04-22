package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

 public class ExcelUtils {

private static XSSFSheet ExcelWSheet;

private static XSSFWorkbook ExcelWBook;

private static XSSFCell Cell;

private static XSSFRow Row;

public static Object[][] getTableArray(String SheetName) throws Exception {   

   String[][] tabArray = null;

   try {
	     String userDirectory = System.getProperty("user.dir");
	    FileInputStream ExcelFile = new FileInputStream( userDirectory + "/src/main/java/resources/inputdata.xlsx");
		
		
		   // Access the required test data sheet
		
		   ExcelWBook = new XSSFWorkbook(ExcelFile);
		
		   ExcelWSheet = ExcelWBook.getSheet(SheetName);
		
		   int startRow = 1;
		
		   int startCol = 1;
		
		   int ci,cj;
		
		   int totalRows = ExcelWSheet.getLastRowNum();
		
		   // To Iterate accross the Rows & Columns
		
		   int totalCols = 8;
		
		   tabArray=new String[totalRows][totalCols];
		
		   ci=0;
		
		   for (int i=startRow;i<=totalRows;i++, ci++) {              
		
			   cj=0;
		
			   for (int j=startCol;j<=totalCols;j++, cj++){
			
			   tabArray[ci][cj]=getCellData(i,j);
			 
			
			}
			
		}
   return tabArray;
}

catch (FileNotFoundException e){

System.out.println("Could not read the Excel sheet");

e.printStackTrace();

}

catch (IOException e){

System.out.println("Could not read the Excel sheet");

e.printStackTrace();

}

return(tabArray);

}

public static String getCellData(int RowNum, int ColNum) throws Exception {

try{

	Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
	
	CellType dataType = Cell.getCellType();
	
		if  (dataType == CellType.ERROR) {
		
			return "";
		
		}
		else{
		
			String CellData = Cell.getStringCellValue();
			
			return CellData;
		
		}
		
}	catch (Exception e){

		System.out.println(e.getMessage());

		throw (e);

		}

}
public static String UpdateCellData(int RowNum, int ColNum,String QuoteNumber) throws Exception {

try{

	Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
	
	CellType dataType = Cell.getCellType();
	
		if  (dataType == CellType.ERROR) {
		
			return "";
		
		}
		else{
		

			Cell.setCellValue((QuoteNumber));
			
			String userDirectory = System.getProperty("user.dir");
			FileOutputStream out = new FileOutputStream( userDirectory + "/src/main/java/resources/inputdata.xlsx");

			  
			ExcelWBook.write(out); out.close();
			 
		
		}
		
}	catch (Exception e){

		System.out.println(e.getMessage());

		throw (e);

		}
return QuoteNumber;

}

}