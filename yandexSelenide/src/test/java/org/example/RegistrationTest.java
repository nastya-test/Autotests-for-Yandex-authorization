package org.example;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.RegistrationPage;
import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest {
    @BeforeMethod
    public void openPage(){
        String url = ConfProperties.getProperty("loginPageUrl");
        open(url);
    }

    @Test
    public void registration() {
        RegistrationPage registrationPage = new RegistrationPage();

        //Генерация переменных
        String name = RandomStringUtils.random(8, true, true);
        String surname = RandomStringUtils.random(8, true, true);
        String login = RandomStringUtils.random(8, true, true);
        String password = RandomStringUtils.random(8, true, true);

        //Генерация номера телефона
        String s = "0123456789";
        StringBuffer phoneNumber = new StringBuffer("999");
        int PHONE_NUMBER_LENGTH = 7;
        for (int i = 0; i < PHONE_NUMBER_LENGTH; i++) {
            phoneNumber.append(s.charAt(new Random().nextInt(s.length())));
        }

        registrationPage
                .clickCreateBtn().inputFirstname(name).inputLastname(surname).inputLogin(login).
                inputPassword(password).inputSecondPassword(password).inputPhone(phoneNumber.toString()).
                finalRegistration();
    }
}
