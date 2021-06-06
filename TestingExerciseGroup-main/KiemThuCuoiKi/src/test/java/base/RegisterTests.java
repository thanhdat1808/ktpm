package base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.RegisterPage;

import java.util.concurrent.TimeUnit;

public class RegisterTests {
    WebDriver driver;
    @Test
    @DisplayName("TC05-Register a Paintent is Sucessfully.")
    public void RegisterPainter() {
        System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.LoginSuccess();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickRegister();

        registerPage.setNamePaident("Phan","Tran Bao","Ngoc");

        registerPage.clickNext();
        registerPage.chooseGender(1);
        registerPage.clickNext();
        registerPage.setBirth("27",06,"2000");
        registerPage.clickNext();
        registerPage.setAddress1("Đà Nẵng");
        registerPage.clickNext();
        registerPage.setPhone("0383331731");
        registerPage.clickNext();
        registerPage.setRelation(2,"Lê Thị Giang");
        registerPage.clickNext();
        registerPage.ClickSubmit();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"coreapps-diagnosesList\"]/div[2]")));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
    }
}
