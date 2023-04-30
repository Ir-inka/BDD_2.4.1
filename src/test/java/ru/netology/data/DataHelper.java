package ru.netology.data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }
    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    @Value
    public static class CardInfo {
        private String CardInfo;
    }

    public static AuthInfo getAuthInfo() {

        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthinfo(AuthInfo original) {

        return new AuthInfo("petya", "123qwerty");
    }

    public static VerificationCode getVerificationCode(AuthInfo authInfo) {

        return new VerificationCode("12345");
    }

    public static CardInfo getBankCardV1() {

        return new CardInfo("5559 0000 0000 0001");
    }

    public static CardInfo getBankCardV2() {

        return new CardInfo("5559 0000 0000 0002");
    }


}


