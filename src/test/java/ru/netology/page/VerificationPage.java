package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id=code] input");                           // поле для кода из смс
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");                       // кнопка Продолжить

    public VerificationPage() {

        codeField.shouldBe(visible);
    }

    public void validVerify(DataHelper.VerificationCode verificationCode) {

        codeField.setValue(verificationCode.getCode());
        verifyButton.click();
        new DashboardPage();
    }
}

