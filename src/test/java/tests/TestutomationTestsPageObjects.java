package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TestutomationTestsPageObjects extends TestBase {

    @Test
    void formTests() {
        String userName = "Ivan";

        registrationPage.openPage();
        registrationPage.setFirstName(userName);
        registrationPage.setLastName("Ivanov");
        registrationPage.setEmail("Ivanov@mail.ru");
        registrationPage.setGender("Other");
        registrationPage.setPhone("89000765432");
        registrationPage.setBirthDate("26","May", "1990");
        registrationPage.setSubjects("Physics");



        $("#hobbiesWrapper").$(new ByText("Reading")).click();
        $("[id=uploadPicture]").uploadFile(new File("src/test/resources/paddington-g51aae444a_640.jpg"));
        $("#currentAddress").setValue("Some Address111");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        registrationPage.verifyResultsModal();
        registrationPage.verifyResult("Student Name", userName + " Ivanov");
        registrationPage.verifyResult("Student Email", "Ivanov@mail.ru");
        registrationPage.verifyResult("Gender", "Other");
        registrationPage.verifyResult("Mobile", "8900076543");
        registrationPage.verifyResult("Date of Birth", "26 May,1990");



    }


}
