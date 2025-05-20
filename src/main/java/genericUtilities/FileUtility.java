package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains the generic methods
 * @author Arundhati
 */

public class FileUtility {
	
	/**
	 * This method will read data from property file and return 
	 * to the caller
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String readDataFrompropertyFile(String key) throws FileNotFoundException,IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
	
	/**
	 * This method will read data from excel file and return to the caller
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromexcelFile(String sheets,int rowNo,int cellNo) throws EncryptedDocumentException,IOException {
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise); //document
		Sheet sh = wb.getSheet(sheets); //sheet
		Row row = sh.getRow(rowNo); //row
		Cell cell = row.getCell(cellNo); //cell
		String productName = cell.getStringCellValue(); 
		return productName;
	}

}
