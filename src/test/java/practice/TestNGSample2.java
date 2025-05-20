package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGSample2 {
	
    @Test
	public void createSample() {
    	//Assert.fail(); //forcefully fail
		System.out.println("create");
		
	}
	
	@Test(dependsOnMethods = "createSample")
	public void modifySample() {
		System.out.println("modify");
		
	}
	
	@Test (enabled = false)
	public void deleteSample() {
		System.out.println("delete");
		
	}

}
