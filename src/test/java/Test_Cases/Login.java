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
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
<<<<<<< HEAD
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentTest;

public class Login extends Base_Class{

    //Config Extent Report
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("Reports/Login_Report.html");// Report location
    //Extent Report config

=======

public class Login extends Base_Class{

>>>>>>> 7ca1d5462ce028d547604ee6dfd3f1134612c8f0
    public WebDriver driver = new ChromeDriver();
    @BeforeTest
    public void Open_Browser(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
<<<<<<< HEAD

        // config extent report
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Login_Report");
        extent.attachReporter(spark);
        // config extent report
    }

    @Test(dataProvider ="test_data" , priority=0)
    public void Login_With_Registered_Username_And_Correct_Password
            (String User_Name,String Password, String Wrong_Username,String Wrong_Password,
             String Info_First_Name, String Info_Last_name,String Zip_Code) throws IOException {

        // config extent report
        ExtentTest test = extent.createTest("Login_With_Registered_Username_And_Correct_Password");
        test.info("open website");
        test.info("enter username and password");
        test.info("click on login button ");
        test.info("expected result = redirected to home page");
        test.info("actual result = same as expected");
        test.pass("test is passed");
        // config extent report

        driver.get("https://www.saucedemo.com/");  // open website
        driver.findElement(Username_Input).sendKeys(User_Name); //enter username
        driver.findElement(Password_Input).sendKeys(Password);   //enter password
        driver.findElement(Login_Btn).click();  // click button
=======
    }

    @Test(dataProvider ="test_data" , priority=0)
    public void TC_Login_With_Registered_Username_And_Correct_Password
            (String User_Name,String Password, String Wrong_Username,String Wrong_Password,
             String Info_First_Name, String Info_Last_name,String Zip_Code) throws IOException {
        driver.get("https://www.saucedemo.com/");  // open website
        driver.findElement(Username_Input).sendKeys(User_Name); //enter username
        driver.findElement(Password_Input).sendKeys(Password);   //enter password
        driver.findElement(Login_Btn).click();  // click Login_empty_data button
>>>>>>> 7ca1d5462ce028d547604ee6dfd3f1134612c8f0

        //Assertion
        String Home_Page_Link = driver.getCurrentUrl();
        Assert.assertEquals(Home_Page_Link,"https://www.saucedemo.com/inventory.html");
        // user will be redirected to store page
        //Assertion
    }

    @Test(dataProvider ="test_data" ,priority=1)
<<<<<<< HEAD
    public void Login_With_Wrong_Username_And_Password
            (String User_Name,String Password, String Wrong_Username,String Wrong_Password,
             String Info_First_Name, String Info_Last_name,String Zip_Code){

        // config extent report
        ExtentTest test = extent.createTest("Login_With_Wrong_Username_And_Password");
        test.info("open website");
        test.info("enter worng username and password");
        test.info("click on login button ");
        test.info("expected result = error message : 'Epic sadface: Username and password do not match any user in this service'");
        test.info("actual result = same as expected");
        test.pass("test is passed");
        // config extent report

=======
    public void TC_Login_With_Wrong_Username_And_Password
            (String User_Name,String Password, String Wrong_Username,String Wrong_Password,
             String Info_First_Name, String Info_Last_name,String Zip_Code){
>>>>>>> 7ca1d5462ce028d547604ee6dfd3f1134612c8f0
        driver.get("https://www.saucedemo.com/");  // open website
        driver.findElement(Username_Input).sendKeys(Wrong_Username); //enter username
        driver.findElement(Password_Input).sendKeys(Wrong_Password);   //enter password
        driver.findElement(Login_Btn).click();  // click Login_empty_data button

        //Assertion
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.saucedemo.com/");
        // user will see error message and stay in login page
        //Assertion
    }

    @Test(dataProvider ="test_data" ,priority=2)
<<<<<<< HEAD
    public void Login_With_Empty_Input_Field
            (String User_Name,String Password, String Wrong_Username,String Wrong_Password,
             String Info_First_Name, String Info_Last_name,String Zip_Code){

        // config extent report
        ExtentTest test = extent.createTest("Login_With_Empty_Input_Fields");
        test.info("open website");
        test.info("click on login button ");
        test.info("expected result = error message : 'Epic sadface: Username is required'");
        test.info("actual result = same as expected");
        test.pass("test is passed");
        // config extent report

=======
    public void TC_Login_With_Empty_Data
            (String User_Name,String Password, String Wrong_Username,String Wrong_Password,
             String Info_First_Name, String Info_Last_name,String Zip_Code){
>>>>>>> 7ca1d5462ce028d547604ee6dfd3f1134612c8f0
        driver.get("https://www.saucedemo.com/");  // open website
        driver.findElement(Login_Btn).click();  // click Login_empty_data button

        //Assertion
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.saucedemo.com/");
        // user will see error message and stay in login page
        //Assertion
    }

    @AfterTest
    public void Close_Browser(){
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

