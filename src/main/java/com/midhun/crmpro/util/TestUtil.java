package com.midhun.crmpro.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.midhun.crmpro.base.TestBase;

public class TestUtil {

	public static final long PAGE_LOAD_TIMEOUT = 60;
	public static final long MPLICIT_WAIT = 60;
	private static final String TESTDATA_SHEET_PATH = "src/main/java/com/midhun/crmpro/testdata/CRMPROTestData.xlsx";

	public void switchToFrame() {

		TestBase.driver.switchTo().frame("mainpanel");
	}

	public Object[][] getTestData(String sheetName) {

		Workbook book = null;
		Sheet sheet = null;
		FileInputStream file = null;
		try {

			file = new FileInputStream(TESTDATA_SHEET_PATH);
			book = WorkbookFactory.create(file);
		} catch (IOException e) {

			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {

			for (int j = 0; j < sheet.getRow(i + 1).getLastCellNum(); j++) {

				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}

	public static void takeScreenshot(String name) {

		try {

			File srcFile = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			srcFile.renameTo(new File(currentDir + "/screenshots/" + name + "_" + System.currentTimeMillis() + ".png"));
		} catch (NoSuchSessionException e) {

			e.printStackTrace();
		}
	}

	public static String getScreenshot(final ITestResult result) {

		File screeshot = null;
		File dir = new File(System.getProperty("user.dir") + "/screenshots");
		File[] file = dir.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {

				return name.startsWith(TestListener.getTestMethodName(result));
			}
		});
		if (file.length > 0) {

			Arrays.sort(file, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			screeshot = file[0];
			return screeshot.getPath();
		}
		else
			return null;
	}
}