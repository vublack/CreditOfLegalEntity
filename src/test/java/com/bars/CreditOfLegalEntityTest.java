package com.bars;

import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.TextReport;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import static com.bars.LoginPage.getPolygon;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class CreditOfLegalEntityTest {
    private LoginPage loginPage = page(LoginPage.class);
    private Calculation calculation = page(Calculation.class);
    private NewCreditOfLegalEntityPage newCreditOfLegalEntityPage = page(NewCreditOfLegalEntityPage.class);
    private SearchPage searchPage = page(SearchPage.class);
    private SwitchWindow switchWindow = page(SwitchWindow.class);
    private BriefcaseNewCreditOfLegalEntityPage briefcaseNewCreditOfLegalEntityPage = page(BriefcaseNewCreditOfLegalEntityPage.class);
    private FilterBeforFillingTable filterBeforFillingTable = page(FilterBeforFillingTable.class);
    private WorkCreditOfLegalEntityBriefcasePage workCreditOfLegalEntityBriefcasePage = page(WorkCreditOfLegalEntityBriefcasePage.class);
    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests().to("test-results/reports");
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(false);
    @BeforeClass
    public static void setup() {
//        Configuration.fastSetValue=true;
        timeout = 80000;
        baseUrl = getPolygon();
//        browser = "chrome";
        browser = "ie";
        startMaximized = true;
//        System.setProperty("webdriver.ie.driver", ".\\IEDriverServer.exe");
        InternetExplorerDriverManager.getInstance(DriverManagerType.IEXPLORER).arch32().setup();
        open("/");
    }
    @Test
    public void creditLegalEntityTest() {
        //Логин
        loginPage.fillLoginForm("absadm01", "qwerty");
        loginPage.goOn();
        //Страница поиска
        switchWindow.switchToMainFrame();
        searchPage.h1();
        switchWindow.switchToDefaultContent();
        searchPage.chooseBranch();
        searchPage.searchFunction("Портфель НОВИХ кредитів ЮО");
        switchWindow.switchToMainFrame();
        //Кнопка Новый КД(переключение на окно Нового КД)
        String briefcaseNewKdWindow = getWebDriver().getWindowHandle();
        briefcaseNewCreditOfLegalEntityPage.pressCreateNewKD();
        switchWindow.forceSwitchToWindow(briefcaseNewKdWindow);
        switchWindow.windowMaximize();
        // !!Заполнение полей КД!!
        // Вкладка Параметри КД
        String newKdWindow = getWebDriver().getWindowHandle();
        String numSum = calculation.randomNum();
        newCreditOfLegalEntityPage.fillNumSum(numSum, numSum);
        newCreditOfLegalEntityPage.initiativeButtonClick();
        newCreditOfLegalEntityPage.filterInput("/300465/");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditOfLegalEntityPage.okpoButtonClick();
        newCreditOfLegalEntityPage.filterInputClick();
        newCreditOfLegalEntityPage.filterInput("97407801");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditOfLegalEntityPage.ratesInput("12");
        newCreditOfLegalEntityPage.typeOfCredit("ЮО Стандартний");
        newCreditOfLegalEntityPage.goalOfCredit("Поточна дiяльнiсть");
        newCreditOfLegalEntityPage.productOfCredit1();
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditOfLegalEntityPage.productOfCredit2();
        newCreditOfLegalEntityPage.filterInput("206301");
        newCreditOfLegalEntityPage.chooseGKD("Ні");
        //Вкладка Дані про погашення
        String firstPaymentDate = newCreditOfLegalEntityPage.getConclusionDate();
        newCreditOfLegalEntityPage.firstPaymentDate(firstPaymentDate);
        //Вкладка Дод. параметри КД
        newCreditOfLegalEntityPage.creditInsurance();
        newCreditOfLegalEntityPage.filterInput("NO");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditOfLegalEntityPage.updateParameter();
        newCreditOfLegalEntityPage.contractStatus();
        newCreditOfLegalEntityPage.filterInputClick();
        newCreditOfLegalEntityPage.filterInput("0");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditOfLegalEntityPage.updateParameter();
        newCreditOfLegalEntityPage.creditProduct();
        newCreditOfLegalEntityPage.filterInputClick();
        newCreditOfLegalEntityPage.filterInput("2");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditOfLegalEntityPage.updateParameter();
        newCreditOfLegalEntityPage.fillEIBCB();
        newCreditOfLegalEntityPage.filterInputClick();
        newCreditOfLegalEntityPage.filterInput("2");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditOfLegalEntityPage.updateParameter();
        newCreditOfLegalEntityPage.fillEIBCE("33");
        newCreditOfLegalEntityPage.updateParameter();
        newCreditOfLegalEntityPage.fillEIBCR("33");
        newCreditOfLegalEntityPage.updateParameter();
        newCreditOfLegalEntityPage.fillEIBCS();
        newCreditOfLegalEntityPage.filterInputClick();
        newCreditOfLegalEntityPage.filterInput("2");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditOfLegalEntityPage.updateParameter();
        newCreditOfLegalEntityPage.fillEIBCW("33");
        newCreditOfLegalEntityPage.updateParameter();
        newCreditOfLegalEntityPage.fillEIBIE("33");
        newCreditOfLegalEntityPage.updateParameter();
        newCreditOfLegalEntityPage.fillEIBIS();
        newCreditOfLegalEntityPage.filterInput("NO");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditOfLegalEntityPage.updateParameter();
        newCreditOfLegalEntityPage.fillEIBND("33 тест");
        newCreditOfLegalEntityPage.updateParameter();
        newCreditOfLegalEntityPage.fillEIBNE("33 тест");
        newCreditOfLegalEntityPage.updateParameter();
        newCreditOfLegalEntityPage.fillEIBPF();
        newCreditOfLegalEntityPage.filterInputClick();
        newCreditOfLegalEntityPage.filterInput("1");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditOfLegalEntityPage.updateParameter();
        newCreditOfLegalEntityPage.fillEIBSF();
        newCreditOfLegalEntityPage.filterInputClick();
        newCreditOfLegalEntityPage.filterInput("1");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditOfLegalEntityPage.updateParameter();
        newCreditOfLegalEntityPage.fillEIBTV("33");
        newCreditOfLegalEntityPage.updateParameter();
        newCreditOfLegalEntityPage.notary();
        newCreditOfLegalEntityPage.filterInputClick();
        newCreditOfLegalEntityPage.filterInput("2134");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditOfLegalEntityPage.updateParameter();
        //Нажимаем на кнопку "Зберігти"
        newCreditOfLegalEntityPage.saveButtonClick();
        newCreditOfLegalEntityPage.confirmOfCreditCreate();
        String newCreditREF = newCreditOfLegalEntityPage.getREF();
        switchWindow.closeWindow(newKdWindow);
        switchWindow.switchToOldWindow(briefcaseNewKdWindow);
        switchWindow.switchToMainFrame();
        briefcaseNewCreditOfLegalEntityPage.pressRefreshBriefcase();
        //Авторизація
        briefcaseNewCreditOfLegalEntityPage.chooseNewCredit(newCreditREF);
        briefcaseNewCreditOfLegalEntityPage.сreditAuthorization("0");
        switchWindow.switchToDefaultContent();

/*
        String numSum = "449";
        String firstPaymentDate = "01/08/2018";
*/
        //Портфель Робочих КД ФО
        searchPage.searchFunction("Портфель РОБОЧИХ кредитів ЮО");
        switchWindow.switchToMainFrame();
        //Робота з фільтром
        filterBeforFillingTable.clearFilter();
        filterBeforFillingTable.setUserFilter(newCreditREF);
        filterBeforFillingTable.saveUserFilter(newCreditREF);
        filterBeforFillingTable.deleteUserFilter(newCreditREF);
        filterBeforFillingTable.furtherButtonClick();
        //Портфель Робочих кредитів(Побудава ГПК та Графіку подій по портфелю)
        String workCreditOfLegalEntityBriefcaseWindow = getWebDriver().getWindowHandle();
        workCreditOfLegalEntityBriefcasePage.chooseCredit("ЮО Стандартний", newCreditREF);
        workCreditOfLegalEntityBriefcasePage.buildRepaymentSchedule();
        switchWindow.forceSwitchToWindow(workCreditOfLegalEntityBriefcaseWindow);
        switchWindow.windowMaximize();
        String gpkWindow = getWebDriver().getWindowHandle();
        workCreditOfLegalEntityBriefcasePage.getTableName();
        workCreditOfLegalEntityBriefcasePage.matchingSumInGPK(numSum+".00");
        switchWindow.closeWindow(gpkWindow);
        switchWindow.switchToOldWindow(workCreditOfLegalEntityBriefcaseWindow);
        switchWindow.switchToMainFrame();
        workCreditOfLegalEntityBriefcasePage.chooseCredit("ЮО Стандартний", newCreditREF);
        workCreditOfLegalEntityBriefcasePage.eventsTimetableOfBriefcaseButton();
        switchWindow.forceSwitchToWindow(workCreditOfLegalEntityBriefcaseWindow);
        switchWindow.windowMaximize();
        workCreditOfLegalEntityBriefcasePage.chooseInterval(firstPaymentDate);
        filterBeforFillingTable.clearFilter();
        filterBeforFillingTable.setUserFilter(newCreditREF);
        filterBeforFillingTable.furtherButtonClick();
        String eventsTimetableWindow = getWebDriver().getWindowHandle();
        workCreditOfLegalEntityBriefcasePage.progressBar();
        workCreditOfLegalEntityBriefcasePage.checkEventsTimetableOfBriefcase(numSum);
        switchWindow.closeWindow(eventsTimetableWindow);
    }
}
