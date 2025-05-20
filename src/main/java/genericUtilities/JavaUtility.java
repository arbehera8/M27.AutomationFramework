package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consists of generic methods related to java
 * @author Arundhati
 */

public class JavaUtility {
	
	/**
	 * This method will capture the current system date in the required format 
	 * and return to the caller
	 * @return
	 */
	
	public String getSystemDate() {
		Date d = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String dateinFormat = simpleDate.format(d);
		return dateinFormat;
		
	}

}
