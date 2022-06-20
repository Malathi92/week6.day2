package LeafTabs;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readData(String filename) throws IOException {
		// TODO Auto-generated method stub
		
//			Setup path for workbook
		
		XSSFWorkbook wb=new XSSFWorkbook("./data/"+filename+".xlsx");
//		get into the respective sheet
		XSSFSheet ws=wb.getSheet("Sheet1");
		int rowCount=ws.getLastRowNum();
		System.out.println("no of rows"+rowCount);
		int cellCount=ws.getRow(0).getLastCellNum();
		System.out.println("no of columns"+cellCount);
		String[][] data=new String[rowCount][cellCount];
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++)
			{
				 data[i-1][j]=ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(data);
			}
		}
		return data;
			
	}

}
