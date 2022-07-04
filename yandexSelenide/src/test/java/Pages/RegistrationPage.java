package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    //Кнопка создать ID
    SelenideElement createAccount =  $(By.id("passp:exp-register"));

    //Поле Имя
    SelenideElement firstname =  $(By.id("firstname"));

    //Поле Фамилия
    SelenideElement lastname =  $(By.cssSelector("[for='lastname']"));

    SelenideElement lastnamew =  $(By.id("lastname"));

    //Поле Логин
    SelenideElement login =  $(By.cssSelector("[for='login']"));

    SelenideElement loginw =  $(By.id("login"));

    //Поле Придумайте пароль
    SelenideElement password1 =  $(By.cssSelector("[for='password']"));

    SelenideElement password1w =  $(By.id("password"));

    //Поле Повторите пароль
    SelenideElement password2 =  $(By.cssSelector("[for='password_confirm']"));

    SelenideElement password2w =  $(By.id("password_confirm"));

    //Поле Номер мобильного телефона
    SelenideElement phone =  $(By.cssSelector("[for='phone']"));

    SelenideElement phonew =  $(By.id("phone"));

    //Чек бокс
    SelenideElement chek1 =  $(By.id("eula_accepted"));

    //Чек бокс
    SelenideElement chek2 =  $(By.id("keep_unsubscribed"));

    //Кнопка Зарегистрироваться
    SelenideElement registrationBtn =  $(By.className("Button2_type_submit"));

    public RegistrationPage clickCreateBtn() {
        createAccount.click();
        return this;
    }

    public RegistrationPage inputFirstname(String text) {
        firstname.click();
        firstname.setValue(text);
        return this;
    }

    public RegistrationPage inputLastname(String text){
        lastname.click();
        lastnamew.setValue(text);
        return this;
    }

    public RegistrationPage inputLogin(String text){
        login.click();
        loginw.setValue(text);
        return this;
    }

    public RegistrationPage inputPassword(String text){
        password1.click();
        password1w.setValue(text);
        return this;
    }

    public RegistrationPage inputSecondPassword(String text){
        password2.click();
        password2w.setValue(text);
        return this;
    }

    public RegistrationPage inputPhone(String text){
        phone.click();
        phonew.setValue(text);
        return this;
    }

    public RegistrationPage finalRegistration() {
        chek2.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        registrationBtn.click();
        return this;
    }

}
