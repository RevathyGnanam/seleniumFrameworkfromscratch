package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//Dataprovider1
	@DataProvider(name="LoginData")
	public String[][] getData() throws Exception {
		
		String path = System.getProperty("user.dir")+ "\\testData\\Data.xlsx";	  //Taking excel file from data
		
		ExcelUtility utility = new ExcelUtility(path); //creating an object for Xlutility
		int totalRows = utility.getRowCount("Sheet1");
		int totalColumn =utility.getCellCount("Sheet1", 1);
		
		String loginData[][] = new String[totalRows][totalColumn]; //created 2 dimensional array which can stored
		
		for (int i = 1; i <= totalRows; i++) { //1 read the data from xl and storing in two dimensional array
			
			for (int j = 0; j < totalColumn; j++) { //0 i --> row j--> col
				
				loginData[i-1][j] = utility.getCellData("Sheet1", i, j); //01
				
			}
			
		}
		
		return loginData;  //returning 2 dimensional array
		
	}
	
	//Dataprovider2
	//Dataprovider3
	//Dataprovider4

}
