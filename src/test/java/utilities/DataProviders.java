package utilities;

import java.io.IOException;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	
	@DataProvider(name="Login Data")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\LoginCreds.xlsx"; //taking xl file from test data
		
		Excelutility xlutil= new Excelutility(path); //Creating an object of Excel utility class
		
		int totalrows= xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		String logindata[][] = new String[totalrows][totalcols];//created for 2D array which can store the data
		
		for(int i=1;i<totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
	}

}
