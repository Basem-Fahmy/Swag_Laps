package Test_Cases;
import Base_Class.Base_Class;
import Test_Data.import_excel;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class Login extends Base_Class{

    public WebDriver driver = new ChromeDriver();
    @BeforeTest
    public void Open_Browser(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
    }

    @Test(dataProvider ="test_data" , priority=0)
    public void TC_Login_With_Registered_Username_And_Correct_Password
            (String User_Name,String Password, String Wrong_Username,String Wrong_Password,
             String Info_First_Name, String Info_Last_name,String Zip_Code) throws IOException {
        driver.get("https://www.saucedemo.com/");  // open website
        driver.findElement(Username_Input).sendKeys(User_Name); //enter username
        driver.findElement(Password_Input).sendKeys(Password);   //enter password
        driver.findElement(Login_Btn).click();  // click Login_empty_data button

        //Assertion
        String Home_Page_Link = driver.getCurrentUrl();
        Assert.assertEquals(Home_Page_Link,"https://www.saucedemo.com/inventory.html");
        // user will be redirected to store page
        //Assertion
    }

    @Test(dataProvider ="test_data" ,priority=1)
    public void TC_Login_With_Wrong_Username_And_Password
            (String User_Name,String Password, String Wrong_Username,String Wrong_Password,
             String Info_First_Name, String Info_Last_name,String Zip_Code){
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
    public void TC_Login_With_Empty_Data
            (String User_Name,String Password, String Wrong_Username,String Wrong_Password,
             String Info_First_Name, String Info_Last_name,String Zip_Code){
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
        driver.quit();
    }

    @DataProvider
    public Object[][]test_data() throws Exception {
        import_excel obj = new import_excel();  // create object  from excelsheet function
        return obj.data_import();   // return object from the inside function
    }


}

