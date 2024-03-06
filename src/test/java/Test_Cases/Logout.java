package Test_Cases;
import Base_Class.Base_Class;
import Test_Data.import_excel;
import io.github.bonigarcia.wdm.WebDriverManager;
<<<<<<< HEAD
import org.openqa.selenium.WebDriver;
=======
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
>>>>>>> 7ca1d5462ce028d547604ee6dfd3f1134612c8f0
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
<<<<<<< HEAD
import java.time.Duration;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentTest;

public class Logout extends Base_Class {

    //Config Extent Report
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("Reports/Logout_Report.html");// Report location
    //Extent Report config

=======

import java.time.Duration;

public class Logout extends Base_Class {

>>>>>>> 7ca1d5462ce028d547604ee6dfd3f1134612c8f0
    WebDriver driver =new ChromeDriver();
    @BeforeTest
    public void Open_Browser(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
<<<<<<< HEAD

        // config extent report
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Logout_Report");
        extent.attachReporter(spark);
        // config extent report
    }

    @Test(dataProvider ="test_data" , priority=0)
      public void Logout_Test(String User_Name,String Password, String Wrong_Username,
          String Wrong_Password, String Info_First_Name, String Info_Last_name,String Zip_Code){

        // config extent report
        ExtentTest test = extent.createTest("Logout_Test");
        test.info("open website");
        test.info("enter username and password");
        test.info("click on login button ");
        test.info("open left sidebar");
        test.info("click on logout link");
        test.info("expected result = redirected to login page");
        test.info("actual result = same as expected");
        test.pass("test is passed");
        // config extent report

=======
    }

    @Test(dataProvider ="test_data" , priority=0)
      public void Logout_test(String User_Name,String Password, String Wrong_Username,
          String Wrong_Password, String Info_First_Name, String Info_Last_name,String Zip_Code){
>>>>>>> 7ca1d5462ce028d547604ee6dfd3f1134612c8f0
        driver.get("https://www.saucedemo.com/");
        driver.findElement(Username_Input).sendKeys(User_Name); //enter username
        driver.findElement(Password_Input).sendKeys(Password);   //enter password
        driver.findElement(Login_Btn).click();  // click Login button
        driver.findElement(Left_Sidebar).click(); // open left sidebar
<<<<<<< HEAD
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(Logout_Link));
        wait.until(ExpectedConditions.elementToBeClickable(Logout_Link));
=======

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(Logout_Link));
        wait.until(ExpectedConditions.elementToBeClickable(Logout_Link));

>>>>>>> 7ca1d5462ce028d547604ee6dfd3f1134612c8f0
        driver.findElement(Logout_Link).click(); // click on logout Link

        //Assertion
        String Url = driver.getCurrentUrl();
        Assert.assertEquals(Url,"https://www.saucedemo.com/");
<<<<<<< HEAD
        // user will return to login page
=======
        // user will return to home page
>>>>>>> 7ca1d5462ce028d547604ee6dfd3f1134612c8f0
        //Assertion
    }

    @AfterTest
    public void CLose_Browser(){
<<<<<<< HEAD
        extent.flush(); // will erase all data on the report
=======
>>>>>>> 7ca1d5462ce028d547604ee6dfd3f1134612c8f0
        driver.quit();
    }

    @DataProvider
    public Object[][]test_data() throws Exception {
        import_excel obj = new import_excel();  // create object  from excelsheet function
        return obj.data_import();   // return object from the inside function
    }
}
