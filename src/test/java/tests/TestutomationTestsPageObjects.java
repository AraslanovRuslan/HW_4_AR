package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestutomationTestsPageObjects {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

    }
    @Test
    void formTests(){
        // executeJavaScript("$('footer').remove()");
        // executeJavaScript("$('#fixedban').remove()");
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivanov@mail.ru");
        $("#genterWrapper").$(new ByText("Other")).click();
        $("#userNumber").setValue("89000765432");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--026").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Physics");
        $("#subjectsInput").pressTab();
        $("#hobbiesWrapper").$(new ByText("Reading")).click();
        $("[id=uploadPicture]").uploadFile(new File("src/test/resources/paddington-g51aae444a_640.jpg"));
        $("#currentAddress").setValue("Some Address111");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").shouldBe(Condition.visible);
        $(".modal-content").shouldHave(text("Ivan Ivanov"));
        $(".modal-content").shouldHave(text("Ivanov@mail.ru"));
        $(".modal-content").shouldHave(text("Other"));
        $(".modal-content").shouldHave(text("89000765432"));
        $(".modal-content").shouldHave(text("26 May,1990"));
        $(".modal-content").shouldHave(text("Physics"));
        $(".modal-content").shouldHave(text("Reading"));
        $(".modal-content").shouldHave(text("paddington-g51aae444a_640.png"));
        $(".modal-content").shouldHave(text("Some Address"));
        $(".modal-content").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();

    }



}
