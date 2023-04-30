package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;


public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=login] input");                                 // ввод Логина
    private SelenideElement passwordField = $("[data-test-id=password] input");                         // ввод Пароля
    private SelenideElement loginButton = $("[data-test-id=action-login]");                              // кнопка Продолжить

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
}
