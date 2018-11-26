package com.bars;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


class LoginPage {
    public void prof(){
        $("#btnProfile").shouldBe(visible).click();}

    public String getPolygon() {
       String pol = $x("(//*[text()='База даних:']/following::span)[1]").shouldBe(visible).getText();
        return pol;
////        return "http://10.10.17.22:8080/barsroot/account/login";
////        return  "http://10.10.17.24:8080/barsroot/account/login";
////        return "http://10.10.17.50:8080/barsroot/account/login";
////        return "http://10.10.17.40:8080/barsroot/account/login";
////        return "http://10.10.17.40:8082/barsroot/account/login";
////        return "http://10.10.10.198:11111/barsroot/account/login";
//
    }
    void fillLoginForm(String login, String password) {
        $("#txtUserName").setValue(login);
        $("#txtPassword").setValue(password).pressEnter();
        }
    void goOn(){
        $("#btChangDate").shouldBe(visible).click();
        }
}
