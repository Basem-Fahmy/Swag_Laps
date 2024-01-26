package Test_Cases;
import Base_Class.Base_Class;
import Test_Data.import_excel;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Logout extends Base_Class {

    WebDriver driver =new ChromeDriver();
    @BeforeTest
    public void Open_Browser(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
    }

    @Test(dataProvider ="test_data" , priority=0)
      public void Logout_test(String User_Name,String Password, String Wrong_Username,
          String Wrong_Password, String Info_First_Name, String Info_Last_name,String Zip_Code){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(Username_Input).sendKeys(User_Name); //enter username
        driver.findElement(Password_Input).sendKeys(Password);   //enter password
        driver.findElement(Login_Btn).click();  // click Login button
        driver.findElement(Left_Sidebar).click(); // open left sidebar

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(Logout_Link));
        wait.until(ExpectedConditions.elementToBeClickable(Logout_Link));

        driver.findElement(Logout_Link).click(); // click on logout Link

        //Assertion
        String Url = driver.getCurrentUrl();
        Assert.assertEquals(Url,"https://www.saucedemo.com/");
        // user will return to home page
        //Assertion
    }

    @AfterTest
    public void CLose_Browser(){
        driver.quit();
    }

    @DataProvider
    public Object[][]test_data() throws Exception {
        import_excel obj = new import_excel();  // create object  from excelsheet function
        return obj.data_import();   // return object from the inside function
    }
}
