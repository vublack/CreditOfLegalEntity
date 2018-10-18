package com.bars;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


class LoginPage {
    static String getPolygon() {
        return "http://10.10.17.22:8080/barsroot/account/login/";
//        return "http://10.10.17.50:8080/barsroot/account/login/";
//        return "http://10.10.17.40:8080/barsroot/account/login/";
//        return "http://10.10.17.40:8082/barsroot/account/login/";;
    }
    void fillLoginForm(String login, String password) {
        $("#txtUserName").setValue(login);
        $("#txtPassword").setValue(password).pressEnter();
        }
    void goOn(){
        $(byXpath("//input[@value = 'Продовжити']")).shouldBe(visible).click();
        }
}
