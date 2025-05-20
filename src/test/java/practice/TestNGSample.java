package practice;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGSample {
	
    @Test(dataProvider = "getData")
	public void createEmpData(String name, int id) {
		System.out.println("Name is -" + name);
		System.out.println("Id is -" + id);
		
	}
    
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[3][2]; //3X2 - 3 data sets and each consists of 2 info
		
		//1st set data
		data[0][0]= "Chaitra";
		data[0][1]= 12;
		
		//2nd set data
		data[1][0] = "Duvith";
		data[1][1] = 8;
		
		//3rd set data
		data[2][0] = "Sree";
		data[2][1] = 14;
		
		return data;
		
	}
}
