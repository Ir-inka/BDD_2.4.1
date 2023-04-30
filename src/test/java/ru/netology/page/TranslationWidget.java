package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class TranslationWidget {
    private SelenideElement amountOfFunds = $("[data-test-id='amount'] input");                      // Сумма перевода
    private SelenideElement fromWhichCard = $("[data-test-id='from'] input");                            // С какой карты перевод
    private SelenideElement topUp = $("[data-test-id='action-transfer']");                              // Кнопка Пополнить
    private SelenideElement cancelButton = $("[data-test-id=action-cancel]");                          // Кнопка Отмена
    private SelenideElement wrongAmount = $("[data-test-id=error-notification]");                     // Ошибка при неправильном переводе

    public void transferForm(String sum, DataHelper.CardInfo CardInfo) {

        amountOfFunds.setValue(sum);
        fromWhichCard.setValue(String.valueOf(CardInfo));
        topUp.click();
        new DashboardPage();
    }

    public void getAmountWrong() {

        wrongAmount.shouldBe(Condition.visible);
    }

    public DashboardPage cancelButton() {

        cancelButton.click();
        return new DashboardPage();
    }
}
