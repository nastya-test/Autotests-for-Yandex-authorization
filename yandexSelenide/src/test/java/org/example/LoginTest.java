package org.example;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.testng.ScreenShooter;
@Listeners({ ScreenShooter.class})

public class LoginTest {

    @BeforeMethod
    public void openPage(){
        String url = ConfProperties.getProperty("loginPageUrl");
        open(url);
        ScreenShooter.captureSuccessfulTests = true; //Делает скриншоты и для зеленых тестов
    }

    @Test
    public void LoginTest()
    {
        $(By.id("passp-field-login")).click();
        $(By.id("passp-field-login")).setValue("Логин");
        $(By.id("passp:sign-in")).click();
        $(By.id("field:input-login:hint")).shouldHave(text("Такой логин не подойдет"));
    }

    @Test
    public void errorMessageEngLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillLoginField("EnglishLoginNeZaregan").errorLoginEng();
    }

    @Test
    public void errorMessagePassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillLoginField("decorepanno").fillPasswordField("123456").errorPassword();
    }

    @Test
    public void previousStepBtn() {
        LoginPage loginPage = new LoginPage();
        loginPage.PreviousStepButton("decorepanno");
    }

}
