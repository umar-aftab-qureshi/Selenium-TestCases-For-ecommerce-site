import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCasesForSignUp {
    WebDriver webDriver;
    @BeforeEach
    //This method will run before each testCase so that
    public  void run()
    {
        //Change this path and select your own from your laptop
        System.setProperty("webdriver.gecko.driver","D:\\Geckodriver\\geckodriver-v0.27.0-win64\\geckodriver.exe");
        webDriver=new FirefoxDriver();
        //Below line of code will open the link...
        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
    }
    @Test
    public void TestCase1()
    {
        String exp="My account - My Store";
        //First We need to enter email
        webDriver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("asffdf@gmail.com");
        //After enterning email we have to click sign up button
        webDriver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();
        //First we need to specify the radio button
        //Below line of code will wait for 10 seconds so that page can be loaded completely
        WebElement radioButton1 =
                (new WebDriverWait(webDriver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"id_gender2\"]")));

        //WebElement radioButton1=webDriver.findElement(By.xpath("//*[@id=\"id_gender2\"]"));
        //Below line of code will select this button
        radioButton1.click();
        //Below different weElements are defined by using them we can send keyvalues to these fields
        WebElement FirstName=webDriver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
        WebElement LastName=webDriver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        WebElement password=webDriver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        WebElement Day=webDriver.findElement(By.xpath("//*[@id=\"days\"]"));
        WebElement Month=webDriver.findElement(By.xpath("//*[@id=\"months\"]"));
        WebElement Year=webDriver.findElement(By.xpath("//*[@id=\"years\"]"));
        WebElement Company=webDriver.findElement(By.xpath("//*[@id=\"company\"]"));
        WebElement Address=webDriver.findElement(By.xpath("//*[@id=\"address1\"]"));
        WebElement City=webDriver.findElement(By.xpath("//*[@id=\"city\"]"));
        WebElement State=webDriver.findElement(By.xpath("//*[@id=\"id_state\"]"));
        WebElement Country=webDriver.findElement(By.xpath("//*[@id=\"id_country\"]"));
        WebElement zipCode=webDriver.findElement(By.xpath("//*[@id=\"postcode\"]"));
        WebElement HomeMobile=webDriver.findElement(By.xpath("//*[@id=\"phone\"]"));
        WebElement Mobile=webDriver.findElement(By.xpath("//*[@id=\"phone_mobile\"]"));
        WebElement Register=webDriver.findElement(By.xpath("//*[@id=\"submitAccount\"]"));
        FirstName.sendKeys("Umar");
        LastName.sendKeys("Aftab");
        password.sendKeys("dsnvksbvh");
        //Now we have to select option from dropdown menu
        //we need to use select class for this purpose
        Select dayDropDown=new Select(Day);
        dayDropDown.selectByIndex(5);
        Select MonthDropDOwn=new Select(Month);
        MonthDropDOwn.selectByIndex(7);
        Select YearDropDOwn=new Select(Year);
        YearDropDOwn.selectByValue("1999");
        Company.sendKeys("SoftTech");
        Address.sendKeys("Village and post office Kotli Ajk");
        City.sendKeys("Kotli Ajk");
        Select StateDropDOwn=new Select(State);
        StateDropDOwn.selectByIndex(6);
        zipCode.sendKeys("11100");
        Select CountryDropDOwn=new Select(Country);
        CountryDropDOwn.selectByIndex(1);
        HomeMobile.sendKeys("435676453");
        Mobile.sendKeys("232347");
        Register.click();
        String actual=webDriver.getTitle();
        Assertions.assertEquals(exp,actual);




    }
}
