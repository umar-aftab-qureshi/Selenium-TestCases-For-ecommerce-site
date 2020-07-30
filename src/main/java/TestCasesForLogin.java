import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCasesForLogin {
    static WebDriver  webDriver;
    @BeforeAll
    public static void run()
    {
        //Change this path and select your own from your laptop
        System.setProperty("webdriver.gecko.driver","D:\\Geckodriver\\geckodriver-v0.27.0-win64\\geckodriver.exe");
        webDriver=new FirefoxDriver();
        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
    }
    @Test
    public void test1()
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
        Assertions.assertEquals(expected,Actual);
    }
}
