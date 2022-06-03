package com.Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadProperties {
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = null;
		Properties prop = new Properties();
		
		FileInputStream input = new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\com.Properties\\src\\test\\resources\\config.properties");
		prop.load(input);
		
		System.out.println("browsername is : " + prop.getProperty("browser"));
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/LENOVO/eclipse-workspace/com.Properties/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/Users/LENOVO/eclipse-workspace/com.Properties/Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("internet explorer")) {
			System.setProperty("webdriver.ie.driver", "C:/Users/LENOVO/eclipse-workspace/com.Properties/Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else {
			System.out.println("No browser");
		}
		
		driver.get(prop.getProperty("url"));
		System.out.println("Site is opened");
		Thread.sleep(5000);
		driver.close();
		System.out.println("window is closed");
		
		
	}

}
