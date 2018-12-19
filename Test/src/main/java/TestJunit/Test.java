package TestJunit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test {



    @org.junit.Test
    public void registration_page() {
        WebDriver driver;
      String expectedRegisterSuccessMessage = "Your registration completed";
        System.setProperty("webdriver.chrome.driver", "src\\browserdriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().fullscreen();

        driver.get("https://demo.nopcommerce.com");

        driver.findElement(By.xpath("//a[@href=\"/register\"]")).click();

        driver.findElement(By.xpath("//input[@id=\"gender-male\"]")).click();

        driver.findElement(By.xpath("// input[@id=\"FirstName\"]")).sendKeys("Pranav");

        driver.findElement(By.id("LastName")).sendKeys("Mehta");

        Select day = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]")));

        //Select day = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]")));
        day.selectByIndex(4);

        Select month = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]")));
        month.selectByVisibleText("July");

        Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
        year.selectByValue("2018");

        DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
        Date date1 = new Date();

        String date2 = dateFormat.format(date1);
        driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]")).sendKeys("15111979065500");
        driver.findElement(By.id("Email")).sendKeys("pranavsalee01@gmail.com");

        driver.findElement(By.id("Company")).sendKeys("CompanyNametest");
        WebElement checkbox = driver.findElement(By.xpath("//label[@for=\"Newsletter\"]"));
        checkbox.isSelected();
        driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]")).sendKeys("15111979065500");
        driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("Swami001");
        driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]")).sendKeys("Swami001");
        driver.findElement(By.xpath("//input[@id=\"register-button\"]")).click();
        String actualRegisterSuccessMessage = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        Assert.assertEquals("Test case failed", expectedRegisterSuccessMessage, actualRegisterSuccessMessage);
        Assert.assertEquals("Test case is Passed", expectedRegisterSuccessMessage, actualRegisterSuccessMessage);
        driver.findElement(By.className("ico-logout")).click();
        driver.quit();
    }
@org.junit.Test

public void currency(){
    WebDriver driver;
    System.setProperty("webdriver.chrome.driver", "src\\browserdriver\\chromedriver.exe");
    driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    driver.manage().window().fullscreen();

    driver.get("https://demo.nopcommerce.com");

    driver.findElement(By.xpath("//select[@id=\"customerCurrency\"]/option[2]")).click();

    //driver.findElement(By.xpath("//div[@h2=\"details\"]/h2[@class=\"product-title\"]/a[@href=\"/apple-macbook-pro-13-inch\"]")).click();
    String actual= driver.findElement(By.xpath("//div[@data-productid=\"4\"]/div[2]/div[3]/div/span[@class=\"price actual-price\"]")).getText();

    String expected= "Ђ1548.00";
    Assert.assertEquals("testcase failed",expected,actual);
    driver.quit();
}

@org.junit.Test

    public void email(){

    WebDriver driver;
    System.setProperty("webdriver.chrome.driver", "src\\browserdriver\\chromedriver.exe");
    driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    driver.manage().window().fullscreen();

    driver.get("https://demo.nopcommerce.com");

    driver.findElement(By.xpath("//div[@class=\"details\"]/h2[@class=\"product-title\"]/a[@href=\"/apple-macbook-pro-13-inch\"]")).click();
    driver.findElement(By.xpath("//div[@class=\"overview-buttons\"]/div[3]/input[@type=\"button\"]")).click();
    driver.findElement(By.xpath("//input[@id=\"FriendEmail\"]")).sendKeys("abc123@gmail.com");
    driver.findElement(By.xpath("//input[@id=\"YourEmailAddress\"]")).sendKeys("qwe1234@gmail.com");
    driver.findElement(By.xpath("//textarea[@id=\"PersonalMessage\"]")).sendKeys("please see your email.");
    driver.findElement(By.xpath("//input[@name=\"send-email\"]")).click();
    String expected= "Only registered customers can use email a friend feature";
    String actual=driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]")).getText();
    Assert.assertEquals("test case failed", expected,actual);
    driver.quit();


}


}














