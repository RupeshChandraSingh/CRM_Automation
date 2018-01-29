package com.crm.utility;

import java.io.IOException;

public class Run {

	public static void main(String[] args) throws IOException {
		ReadExcelData re = new ReadExcelData("F:\\Docs\\Rupesh\\testdata.xlsx");
		String uName = re.getCellData("testdata", "userName", 2);
		
		System.out.println(uName);

	}

}
