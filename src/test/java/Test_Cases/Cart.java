package Test_Cases;
import Base_Class.Base_Class;
import Test_Data.import_excel;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
<<<<<<< HEAD
=======
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
>>>>>>> 7ca1d5462ce028d547604ee6dfd3f1134612c8f0
import org.testng.Assert;
import org.testng.annotations.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
<<<<<<< HEAD
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentTest;
public class Cart extends Base_Class {

    //Config Extent Report
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("Reports/Cart_Report.html");// Report location
    //Extent Report config
=======

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Cart extends Base_Class {
>>>>>>> 7ca1d5462ce028d547604ee6dfd3f1134612c8f0

    WebDriver driver = new ChromeDriver();
    @BeforeClass
     public void Open_Browser(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
<<<<<<< HEAD

        // config extent report
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Cart_Report");
        extent.attachReporter(spark);
        // config extent report
=======
        driver.navigate().to("https://www.saucedemo.com/");  // open website
>>>>>>> 7ca1d5462ce028d547604ee6dfd3f1134612c8f0
    }

    @Test(dataProvider ="test_data" , priority=0)
    public void Add_Product_To_Cart
            (String User_Name,String Password, String Wrong_Username
            ,String Wrong_Password,String Info_First_Name, String Info_Last_name,String Zip_Code) {
<<<<<<< HEAD

        // config extent report
        ExtentTest test = extent.createTest("Add_Product_To_Cart");
        test.info("open website");
        test.info("enter username and password");
        test.info("click on login button ");
        test.info("select product");
        test.info("click add to cart button ");
        test.info("click on cart icon ");
        test.info("expected result = selected product added to cart ");
        test.info("actual result = same as expected");
        test.pass("test is passed");
        // config extent report

=======
>>>>>>> 7ca1d5462ce028d547604ee6dfd3f1134612c8f0
        driver.get("https://www.saucedemo.com/");  // open website
        driver.findElement(Username_Input).sendKeys(User_Name); //enter username
        driver.findElement(Password_Input).sendKeys(Password);   //enter password
        driver.findElement(Login_Btn).click();  // click Login button
        driver.findElement(Product).click();  // select product
        driver.findElement(Add_To_Cart_Btn).click();  // click add to cart button
        driver.findElement(Cart_Icon).click();  // click cart icon

        //Assertion
        String Selected_Product = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
        String product_In_cart = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
         Assert.assertEquals(Selected_Product,product_In_cart);
        //Assertion
    }

    @Test(dataProvider = "test_data",priority = 4)
    public void Checkout_Test
            (String User_Name,String Password, String Wrong_Username
                    ,String Wrong_Password,String First_Name, String Last_Name,String Zip_Code) throws InterruptedException {
<<<<<<< HEAD

        // config extent report
        ExtentTest test = extent.createTest("Checkout_Test");
        test.info("open website");
        test.info("enter username and password");
        test.info("click on login button ");
        test.info("select product");
        test.info("click add to cart button ");
        test.info("click on cart icon");
        test.info("enter first name,last name & postal code ");
        test.info("click continue then finish ");
        test.info("expected result = message : 'Thank you for your order' ");
        test.info("actual result = same as expected");
        test.pass("test is passed");
        // config extent report

=======
>>>>>>> 7ca1d5462ce028d547604ee6dfd3f1134612c8f0
        driver.get("https://www.saucedemo.com/");  // open website
        driver.findElement(Username_Input).sendKeys(User_Name); //enter username
        driver.findElement(Password_Input).sendKeys(Password);   //enter password
        driver.findElement(Login_Btn).click();  // click Login button
        driver.findElement(Product).click();  // select product
        driver.findElement(Add_To_Cart_Btn).click();  // click add to cart button
        driver.findElement(Cart_Icon).click();  // click cart icon
        driver.findElement(Checkout_Btn).click(); //click checkout button
        driver.findElement(Firstname_Input).sendKeys(First_Name); //enter first name
        driver.findElement(Lastname_Input).sendKeys(Last_Name);//enter last name
        driver.findElement(Postal_Code_Input).sendKeys(Zip_Code);//enter zip code
        driver.findElement(Continue_Btn).click(); // click continue button
        driver.findElement(Finish_Btn).click(); // click finish button

        //Assertion
        String Order_Dispatching_Msg = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();
        Assert.assertEquals(Order_Dispatching_Msg,"Thank you for your order!");
        //Assertion

    }

    @Test(dataProvider = "test_data",priority = 2)
    public void Checkout_With_Empty_Cart
            (String User_Name,String Password, String Wrong_Username
                    ,String Wrong_Password,String First_Name, String Last_Name,String Zip_Code) throws IOException {
<<<<<<< HEAD

        // config extent report
        ExtentTest test = extent.createTest("Checkout_With_Empty_Cart");
        test.info("open website");
        test.info("enter username and password");
        test.info("click on login button ");
        test.info("click on cart icon");
        test.info("click checkout button  ");
        test.info("enter first name, last name & postal code ");
        test.info("click continue then finish ");
        test.info("expected result = message: 'you should add product first to your cart ' ");
        test.info("actual result = message : 'Thank you for your order'");
        test.fail("test is failed");
        // config extent report

=======
>>>>>>> 7ca1d5462ce028d547604ee6dfd3f1134612c8f0
        driver.get("https://www.saucedemo.com/");  // open website
        driver.findElement(Username_Input).sendKeys(User_Name); //enter username
        driver.findElement(Password_Input).sendKeys(Password);   //enter password
        driver.findElement(Login_Btn).click();  // click Login button
        driver.findElement(Cart_Icon).click();  // click cart icon
        driver.findElement(Checkout_Btn).click(); //click checkout button
        driver.findElement(Firstname_Input).sendKeys(First_Name); //enter first name
        driver.findElement(Lastname_Input).sendKeys(Last_Name);//enter last name
        driver.findElement(Postal_Code_Input).sendKeys(Zip_Code);//enter zip code
        driver.findElement(Continue_Btn).click(); // click continue button
        driver.findElement(Finish_Btn).click(); // click finish button

        // take screenshot
        WebElement my_element = driver.findElement(By.xpath("//*[@id=\"root\"]"));
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver,my_element);
        ImageIO.write(screenshot.getImage(), "jpg", new File(("./Screenshoots/Checkout_With_Empty_Cart.jpg")));
        // take screenshot

        //Assertion
        String Error_Msg = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();
        Assert.assertEquals(Error_Msg,"you should add product first to your cart");
        //Assertion
    }


    @Test(dataProvider = "test_data",priority =3)
    public void Remove_Product_From_Cart
            (String User_Name,String Password, String Wrong_Username
            ,String Wrong_Password,String Info_First_Name, String Info_Last_name,String Zip_Code) {
<<<<<<< HEAD

        // config extent report
        ExtentTest test = extent.createTest("Remove_Product_From_Cart");
        test.info("open website");
        test.info("enter username and password");
        test.info("click on login button ");
        test.info("select product ");
        test.info("click add to cart ");
        test.info("click cart icon ");
        test.info("click remove from cart  ");
        test.info("expected result = selected product is removed ' ");
        test.info("actual result = same as expected");
        test.pass("test is passed");
        // config extent report

=======
>>>>>>> 7ca1d5462ce028d547604ee6dfd3f1134612c8f0
        driver.get("https://www.saucedemo.com/");  // open website
        driver.findElement(Username_Input).sendKeys(User_Name); //enter username
        driver.findElement(Password_Input).sendKeys(Password);   //enter password
        driver.findElement(Login_Btn).click();  // click Login button
        driver.findElement(Product).click();  // select product
        driver.findElement(Add_To_Cart_Btn).click();  // click add to cart button
        driver.findElement(Cart_Icon).click();  // click cart icon
        driver.findElement(Remove_From_Cart_Btn).click();  // remove product from cart

    }

    @Test(dataProvider = "test_data",priority = 4)
     public void Back_To_home_Page
            (String User_Name,String Password, String Wrong_Username
            ,String Wrong_Password,String Info_First_Name, String Info_Last_name,String Zip_Code){
<<<<<<< HEAD

        // config extent report
        ExtentTest test = extent.createTest("Back_To_home_Page");
        test.info("open website");
        test.info("enter username and password");
        test.info("click on login button ");
        test.info("click cart icon ");
        test.info("click continue shopping  ");
        test.info("expected result = user is redirected to home page  ");
        test.info("actual result = same as expected");
        test.pass("test is passed");
        // config extent report

=======
>>>>>>> 7ca1d5462ce028d547604ee6dfd3f1134612c8f0
        driver.get("https://www.saucedemo.com/");  // open website
        driver.findElement(Username_Input).sendKeys(User_Name); //enter username
        driver.findElement(Password_Input).sendKeys(Password);   //enter password
        driver.findElement(Login_Btn).click();  // click Login button
        driver.findElement(Cart_Icon).click();  // click cart icon
        driver.findElement(Continue_Shopping_Btn).click();  //click continue shopping button

        //Assertion
        String Home_Page_Link = driver.getCurrentUrl();
        Assert.assertEquals(Home_Page_Link,"https://www.saucedemo.com/inventory.html");
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
