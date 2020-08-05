import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.jws.soap.SOAPBinding;
//Before exectuing Signup testcases we need to change email ..


public class TestCasesForSignUp {
    WebDriver webDriver;
    WebElement FirstName, LastName, password, Day, Month, Year, Company, Address, City, State, Country, zipCode, HomeMobile, Mobile, Register;

    @BeforeEach
    public void run() {
        System.setProperty("webdriver.gecko.driver", "D:\\Geckodriver\\geckodriver-v0.27.0-win64\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        //Below line of code will open the link...
        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");

    }

    @Test
    //This test case is going to pass because all the required fields are entered correctly.
    public void TestCase1() {
        String exp = "My account - My Store";
        String actual = "HomePage";
        //Change this path and select your own from your laptop

        //First We need to enter email
        //Everytime enter new email address
        //write any mail address register or unregister
        webDriver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("sdff@gmail.com");
        //After enterning email we have to click sign up button
        webDriver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();
        //First we need to specify the radio button
        //Below line of code will wait for 10 seconds so that page can be loaded completely
        try {
            WebElement radioButton1 =
                    (new WebDriverWait(webDriver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"id_gender2\"]")));

            //WebElement radioButton1=webDriver.findElement(By.xpath("//*[@id=\"id_gender2\"]"));
            //Below line of code will select this button
            radioButton1.click();
        } catch (TimeoutException e) {
            System.out.println("Email ALready exists...");
            Assertions.assertEquals(exp, actual);
            webDriver.quit();
        }

        //Below different weElements are defined by using them we can send keyvalues to these fields
        try {
            FirstName = webDriver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
            LastName = webDriver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
            password = webDriver.findElement(By.xpath("//*[@id=\"passwd\"]"));
            Day = webDriver.findElement(By.xpath("//*[@id=\"days\"]"));
            Month = webDriver.findElement(By.xpath("//*[@id=\"months\"]"));
            Year = webDriver.findElement(By.xpath("//*[@id=\"years\"]"));
            Company = webDriver.findElement(By.xpath("//*[@id=\"company\"]"));
            Address = webDriver.findElement(By.xpath("//*[@id=\"address1\"]"));
            City = webDriver.findElement(By.xpath("//*[@id=\"city\"]"));
            State = webDriver.findElement(By.xpath("//*[@id=\"id_state\"]"));
            Country = webDriver.findElement(By.xpath("//*[@id=\"id_country\"]"));
            zipCode = webDriver.findElement(By.xpath("//*[@id=\"postcode\"]"));
            HomeMobile = webDriver.findElement(By.xpath("//*[@id=\"phone\"]"));
            Mobile = webDriver.findElement(By.xpath("//*[@id=\"phone_mobile\"]"));
            Register = webDriver.findElement(By.xpath("//*[@id=\"submitAccount\"]"));


            FirstName.sendKeys("Umar");
            LastName.sendKeys("Aftab");
            password.sendKeys("dsnvksbvh");
            //Now we have to select option from dropdown menu
            //we need to use select class for this purpose
            Select dayDropDown = new Select(Day);
            dayDropDown.selectByIndex(5);
            Select MonthDropDOwn = new Select(Month);
            MonthDropDOwn.selectByIndex(7);
            Select YearDropDOwn = new Select(Year);
            YearDropDOwn.selectByValue("1999");
            Company.sendKeys("SoftTech");
            Address.sendKeys("Village and post office Kotli Ajk");
            City.sendKeys("Kotli Ajk");
            Select StateDropDOwn = new Select(State);
            StateDropDOwn.selectByIndex(6);
            zipCode.sendKeys("11100");
            Select CountryDropDOwn = new Select(Country);
            CountryDropDOwn.selectByIndex(1);
            HomeMobile.sendKeys("435676453");
            Mobile.sendKeys("232347");
            Register.click();
            actual = webDriver.getTitle();
            Assertions.assertEquals(exp, actual);
            webDriver.quit();
        } catch (NoSuchElementException e) {
            System.out.println("Change the email and run again..");
        }
    }

    @Test
    //This test case will check whether the email is already register or not..
    public void TestCase2() {
        //Here we are assuming after signing up profile page will open
        String exp = "Not register";

        //First We need to enter email
        webDriver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("fdvddfvd@gmail.com");
        //After enterning email we have to click sign up button
        webDriver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();
        //First we need to specify the radio button
        //Below line of code will wait for 10 seconds so that page can be loaded completely
        try {
            WebElement radioButton1 =
                    (new WebDriverWait(webDriver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"id_gender2\"]")));

            //WebElement radioButton1=webDriver.findElement(By.xpath("//*[@id=\"id_gender2\"]"));
            //Below line of code will select this button
            radioButton1.click();
        } catch (TimeoutException e) {
            exp = "Login - My Store";
        }
        String actual = webDriver.getTitle();
        webDriver.quit();

        Assertions.assertEquals(exp, actual);


    }

    @Test
    //This test case goes to remains fail because of wrong parameters in sign up page
    public void testCase3() {
        String exp = "My account - My Store";
        String actual="HomePage";
        webDriver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("54gdvshu@gmail.com");
        //After enterning email we have to click sign up button
        webDriver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();
        WebElement radioButton1 =
                (new WebDriverWait(webDriver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"id_gender2\"]")));

        radioButton1.click();
        FirstName = webDriver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
        LastName = webDriver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        password = webDriver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        Day = webDriver.findElement(By.xpath("//*[@id=\"days\"]"));
        Month = webDriver.findElement(By.xpath("//*[@id=\"months\"]"));
        Year = webDriver.findElement(By.xpath("//*[@id=\"years\"]"));
        Company = webDriver.findElement(By.xpath("//*[@id=\"company\"]"));
        Address = webDriver.findElement(By.xpath("//*[@id=\"address1\"]"));
        City = webDriver.findElement(By.xpath("//*[@id=\"city\"]"));
        State = webDriver.findElement(By.xpath("//*[@id=\"id_state\"]"));
        Country = webDriver.findElement(By.xpath("//*[@id=\"id_country\"]"));
        zipCode = webDriver.findElement(By.xpath("//*[@id=\"postcode\"]"));
        HomeMobile = webDriver.findElement(By.xpath("//*[@id=\"phone\"]"));
        Mobile = webDriver.findElement(By.xpath("//*[@id=\"phone_mobile\"]"));
        Register = webDriver.findElement(By.xpath("//*[@id=\"submitAccount\"]"));


        FirstName.sendKeys("");
        LastName.sendKeys("");
        password.sendKeys("dsnvksbvh");
        //Now we have to select option from dropdown menu
        //we need to use select class for this purpose
        Select dayDropDown = new Select(Day);
        dayDropDown.selectByIndex(5);
        Select MonthDropDOwn = new Select(Month);
        MonthDropDOwn.selectByIndex(7);
        Select YearDropDOwn = new Select(Year);
        YearDropDOwn.selectByValue("1999");
        Company.sendKeys("SoftTech");
        Address.sendKeys("Village and post office Kotli Ajk");
        City.sendKeys("Kotli Ajk");
        Select StateDropDOwn = new Select(State);
        StateDropDOwn.selectByIndex(1);
        zipCode.sendKeys("11100");
        Select CountryDropDOwn = new Select(Country);
        CountryDropDOwn.selectByIndex(1);
        HomeMobile.sendKeys("435676453");
        Mobile.sendKeys("232347");
        Register.click();
        actual = webDriver.getTitle();
        webDriver.quit();
        Assertions.assertEquals(exp, actual);




    }

}
