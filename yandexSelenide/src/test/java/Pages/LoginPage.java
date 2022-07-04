package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.io.IOException;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    //Локатор для поля логина
    SelenideElement loginField =  $(By.id("passp-field-login"));

    //Локатор кнопки входа в аккаунт
    SelenideElement loginBtn =  $(By.id("passp:sign-in"));

    //Локатор для поля пароля
    SelenideElement passwordField =  $(By.id("passp-field-passwd"));

    //Локатор для сообщения об ошибке в логине
    SelenideElement errorLogin =  $(By.id("field:input-login:hint"));

    //Локатор для сообщения об ошибке в пароле
    SelenideElement errorPassword =  $(By.id("field:input-passwd:hint"));

    //Локатор для кнопки назад
    SelenideElement previousStepBtn =  $(By.className("PreviousStepButton"));

    public LoginPage fillLoginField(String text) {
        loginField.click();
        loginField.setValue(text);
        loginBtn.click();
        return this;
    }

    public LoginPage fillPasswordField(String text) {
        passwordField.click();
        passwordField.setValue(text);
        loginBtn.click();
        return this;
    }

    public LoginPage errorLoginRu() throws IOException{
        String user = "Такой логин не подойдет";
        errorLogin.shouldBe(Condition.text(user));
        return this;

    }

    public LoginPage errorLoginEng() {
        String user = "Такого аккаунта нет";
        errorLogin.shouldBe(Condition.text(user));
        return this;
    }

    public LoginPage errorPassword() {
        String user = "Неверный пароль";
        errorPassword.shouldBe(Condition.text(user));
        return this;
    }

    public LoginPage PreviousStepButton(String text) {
        loginField.click();
        loginField.setValue(text);
        loginBtn.click();
        previousStepBtn.click();
        loginField.shouldBe(Condition.value(text));
        return this;
    }
}
