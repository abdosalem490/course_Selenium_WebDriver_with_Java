package rahulshettyacademy.resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterENG {
	
	public static ExtentReports getReporterObject() {
		// ExtentReports, ExtentSparkReporter
		String path = System.getProperty("user.dir") + "\\reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(new File(path));
		reporter.config().setReportName("Web Automation results");
		reporter.config().setDocumentTitle("test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rahul Shetty");
		
		return extent;
	}
}
