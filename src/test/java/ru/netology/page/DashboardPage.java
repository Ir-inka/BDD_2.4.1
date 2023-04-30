package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");                            // страница личного кабинета
    private SelenideElement cardV1 = $$(".list__item").first();                                  // номер первой карты
    private SelenideElement cardV2 = $$(".list__item").last();                                     // номер второй карты
    private SelenideElement cardButtonV1 = $$("[data-test-id=action-deposit]").first();               // кнопка Пополнить первой карты
    private SelenideElement cardButtonV2 = $$("[data-test-id=action-deposit]").last();               // кнопка Пополнить второй карты
    private String balanceStart = "баланс: ";
    private String balanceFinish = " р.";

    public DashboardPage() {

        heading.shouldBe(visible);
    }

    public TranslationWidget buttonCardV1() {

        cardButtonV1.click();
        return new TranslationWidget();
    }

    public TranslationWidget buttonCardV2() {

        cardButtonV2.click();
        return new TranslationWidget();
    }

    private int showBalanceOnTheCard(String text) {

        var start = text.indexOf(balanceStart);
        var finish = text.indexOf(balanceFinish);
        var value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public int getBalanceCardV1() {

        var text = cardV1.text();
        return showBalanceOnTheCard(text);
    }

    public int getBalanceCardV2() {

        var text = cardV2.text();
        return showBalanceOnTheCard(text);
    }


}
