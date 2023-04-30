package ru.netology.test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MoneyTransferTest {
    @BeforeEach

    public void setUp() {                                                         // вход в личный кабинет

        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCode(authInfo);
        verificationPage.validVerify(verificationCode);
    }

    @Test
    public void moneyTransferFromFirstToSecond() {                                          // перевод с первой карты на вторую

        var dashboardPage = new DashboardPage();

        int balanceCardV1 = dashboardPage.getBalanceCardV1();
        int balanceCardV2 = dashboardPage.getBalanceCardV2();
        var transferPage = dashboardPage.buttonCardV1();
        var infoCard = DataHelper.getBankCardV2();
        String sum = "10000";
        transferPage.transferForm(sum, infoCard);
        assertEquals(balanceCardV1 + Integer.parseInt(sum), dashboardPage.getBalanceCardV1());
        assertEquals(balanceCardV2 - Integer.parseInt(sum), dashboardPage.getBalanceCardV2());


    }
    @Test
    public void moneyTransferFromSecondToFirst() {                                                // перевод со второй карты на первую

        var dashboardPage = new DashboardPage();

        int balanceCardV1 = dashboardPage.getBalanceCardV1();
        int balanceCardV2 = dashboardPage.getBalanceCardV2();
        var transferPage = dashboardPage.buttonCardV2();
        var infoCard = DataHelper.getBankCardV1();
        String sum = "10000";
        transferPage.transferForm(sum, infoCard);
        assertEquals(balanceCardV1 - Integer.parseInt(sum), dashboardPage.getBalanceCardV1());
        assertEquals(balanceCardV2 + Integer.parseInt(sum), dashboardPage.getBalanceCardV2());


    }
    @Test
    public void theTransferExceedsTheBalanceOfTheCard() {                                               // перевод суммы выше чем есть на счету

        var dashboardPage = new DashboardPage();

        var transferPage = dashboardPage.buttonCardV1();
        var infoCard = DataHelper.getBankCardV2();
        String sum = "15000";
        transferPage.transferForm(sum, infoCard);
        transferPage.getAmountWrong();
    }


}
