package stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.DriverUtil;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Runner {


    static ChromeDriver chromeDriver;
    static DriverUtil driverUtil;
    static ExtentSparkReporter spark;
    static ExtentReports extent;
    static ExtentTest test;
    static final String URL = "https://www.google.com/";


    public void star_drive() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        chromeDriver = new ChromeDriver(options);
        driverUtil=new DriverUtil(chromeDriver);
        spark=new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
        extent =new ExtentReports();
        extent.attachReporter(spark);
    }

    public void afterAll() {
        extent.flush();
    }
    public  void getURL(){
        chromeDriver.get(URL);
    }
    public void isEnable(By locator) {
        assertionCustom("element found", "element not found", driverUtil.findElement(locator) !=null);
       boolean enable= driverUtil.findElement(locator).isEnabled();
        Assertions.assertTrue(enable);
    }
    public void assertionEqualText(String text , By locator) {
        assertionCustom("text element found","text element not found", driverUtil.findElement(locator) !=null);
        assertEquals("text equal", "text not equal",text,locator, driverUtil.findElement(locator).getText().equals(text));
    }
    public void assertionContainText(String text, By locator) {
        assertionCustom("text element found", "text element not found", driverUtil.findElement(locator) !=null);
        assertEquals("text equal", "text not equal", text,locator, driverUtil.findElement(locator).getText().contains(text));
    }
    public void assertEquals(String message, String messageFail, String text, By locator, boolean condition) {
        if (condition) {
            pass(message);
        }else {
            fail(messageFail);
            Assertions.assertEquals(text, driverUtil.findElement(locator).getText());
        }
    }
    public void writeText(String message, String messageFail, By locator, String key) {
        assertionCustom(message, messageFail, driverUtil.findElement(locator) !=null);
        driverUtil.findElement(locator).sendKeys(key);
    }
    public void clickElement (String message, String messageFail, By locator) {
        assertionCustom(message, messageFail, driverUtil.findElement(locator) !=null);
        driverUtil.findElement(locator).click();
    }
    public void assertionCustom(String message, String messageFail, boolean condition) {
        if (condition) {
            pass(message);
        }else {
            fail(messageFail);
        }
    }

    private static void pass(String message) {
        test.pass(message);
    }
    public static String captureByteArray(ChromeDriver driver) {
        return (((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64));
    }
    public static void fail(String message) {
        test.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(captureByteArray(chromeDriver)).build());
    }



}
