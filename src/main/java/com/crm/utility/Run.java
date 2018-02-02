package com.crm.utility;

import java.io.IOException;

public class Run {

	public static void main(String[] args) throws IOException {
//		ReadExcelData re = new ReadExcelData("F:\\Docs\\Rupesh\\crmTestData.xlsx");
//		String uName = re.getCellData("signUpPage", "Password", 1);
//		
//		System.out.println(uName);
		FindBrokenLink bl=new FindBrokenLink();
		bl.findBrokenLink();

	}

}
