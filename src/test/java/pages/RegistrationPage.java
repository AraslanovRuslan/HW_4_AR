package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");


    public void openPage() {
        // executeJavaScript("$('footer').remove()");
        // executeJavaScript("$('#fixedban').remove()");
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));

    }

    public void setFirstName(String value) {
        firstNameInput.setValue(value);
    }
    public void setLastName(String value) {
        lastNameInput.setValue(value);
    }
    public void setEmail(String value) {
        $("#userEmail").setValue(value);
    }
    public void setGender(String value) {
        $("#genterWrapper").$(new ByText(value)).click();
    }
    public void setPhone(String value) {
        $("#userNumber").setValue(value);
    }

}

