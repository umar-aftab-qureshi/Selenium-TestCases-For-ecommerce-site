import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCasesForLogin {
    WebDriver  webDriver;
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
    public void testCase1()
    {
        //Here Expected variables means the title of the page that will open after successfully Sign in
        String expected="My account - My Store";
        //Below line of code will enter the email address in the email field
        webDriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Umerqureshi800@gmail.com");
        //Below line of code will enter the password in the password field
        webDriver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("faiz78601");
        //Below line will press the signin button
        webDriver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
        //Below line of code will get the title of the page that will be opened after successfully login
        String Actual=webDriver.getTitle();
        //This will compare the title of the both expected and actual.
        webDriver.quit();
        Assertions.assertEquals(expected,Actual);
        //THis will quit the browser

    }
    @Test
    public void testCase2()
            //In this test Case we are inputting wrong password and this test is going to fail because we donot get Desire Page
    {
        String expected="My account - My Store";
        webDriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Umerqureshi800@gmail.com");
        webDriver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("jdcsdv");
        webDriver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
        String Actual=webDriver.getTitle();
        webDriver.quit();
        Assertions.assertEquals(expected,Actual);

    }
    @Test
    public void testCase3()
    //In this test Case we are inputting wrong email and pass and this test is going to fail because we donot get Desire Page
    {
        String expected="My account - My Store";
        webDriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Umerqssvsdureshi800@gmail.com");
        webDriver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("jdcsdfssdv");
        webDriver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
        String Actual=webDriver.getTitle();
        webDriver.quit();
        Assertions.assertEquals(expected,Actual);

    }
    @Test
    public void testCase4()
    //In this test Case we are inputting wrong email and pass and this test is going to fail because we donot get Desire Page
    {

        String expected="My account - My Store";
        webDriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Fasndvj@gmail.com");
        webDriver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("jdcsdfssdv");
        webDriver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
        String Actual=webDriver.getTitle();
        webDriver.quit();
        Assertions.assertEquals(expected,Actual);

    }
}
