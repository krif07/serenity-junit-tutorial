package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://demoqa.com/text-box")
public class SimpleInputFieldsForm extends PageObject {

    public void enterFullName(String message) {
        $("#userName").sendKeys(message);
    }

    public void submit() {
        $(FormButton.withLabel("Submit")).click();
    }

    public String displayedOutput() {
        return $("#output p").getText();
    }
}
