package pages.Components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {
    public void verifyModalAppears(){
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));



    }
}
