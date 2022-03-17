package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleDatausingDataProviderTest {
	//to execute same script with multiple data
	//use @DataProvider annotation==>it will provide data to @Test annotated method
	@Test(dataProvider = "getdata")
	public void multipledata(String name,String company,String emailID,String empID) {
		System.out.println(name);
		System.out.println(company);
		System.out.println(emailID);
		System.out.println(empID);
		
		System.out.println("===============================================");	
	}
	@DataProvider()
	public Object[][] getdata() {
		Object[][] objArray = new Object[2][4];
		
		objArray[0][0]="Adarsh";
		objArray[0][1]="Tyss bangalore";
		objArray[0][2]="adarsh@gmail.com";
		objArray[0][3]="EMP001";
		
		objArray[1][0]="Nithesh";
		objArray[1][1]="Tyss bangalore";
		objArray[1][2]="Nithesh@gmail.com";
		objArray[1][3]="EMP002";
		
		return objArray;
		
	}

}
