package com.midhun.crmpro.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.midhun.crmpro.util.TestUtil;
import com.midhun.crmpro.util.WebEventListener;

import io.github.bonigarcia.wdm.EdgeDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static TestUtil testUtil;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {

		try {

			if (prop == null) {

				prop = new Properties();
				FileInputStream fis = new FileInputStream("src/main/java/com/midhun/crmpro/config/config.properties");
				prop.load(fis);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		if (testUtil == null)
			testUtil = new TestUtil();
	}

	public void initialization() {

		String browser = prop.getProperty("browser");
		switch (browser) {

		case "edge":
			EdgeDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			break;
		}
		e_driver = new EventFiringWebDriver(driver);
		
		//Create object of WebEventListener to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.MPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		try {

			Thread.sleep(20000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}