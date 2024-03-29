package seleniumeasy.acceptancetests;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import seleniumeasy.pageobjects.SimpleInputFieldsForm;

import static java.util.Arrays.asList;

/**
 * This is a series of exercises designed to explore how to use
 * Serenity BDD to test various kinds of HTML elements
 */

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenInteractingWithInputForms {

    SimpleInputFieldsForm simpleInputFieldsForm;

    /**
     * Basic form fields:
     * Enter a message and check that the message is correctly displayed
     * https://demoqa.com/text-box
     */
    @Test
    @DisplayName("Basic from: Full name should be displayed")
    public void basicForms() {
        String fullName = "Cristian Davila";
        simpleInputFieldsForm.open();
        simpleInputFieldsForm.enterFullName(fullName);
        /*simpleInputFieldsForm.enterCurrentAddress();
        simpleInputFieldsForm.enterPermanentAddress();*/
        simpleInputFieldsForm.submit();

        Serenity.reportThat("Full name should be " + fullName,
            () -> Ensure.that(simpleInputFieldsForm.displayedOutput()).isEqualTo("Name:"+fullName)
        );
    }

    /**
     * Basic form fields (part 2)
     * Enter two values and calculate the result
     * https://www.seleniumeasy.com/test/basic-first-form-demo.html
     */

    @Test
    public void basicFormsWithMultipleFields() {

    }

    /**
     * Checkboxes
     * Check that a message appears when you click the checkbox
     * https://www.seleniumeasy.com/test/basic-checkbox-demo.html
     */
    @Test
    public void singleCheckbox() {
    }

    @Test
    public void multipleCheckboxes() {
    }

    /**
     * Radio buttons
     * Check that a message appears when you click the radio button
     * https://www.seleniumeasy.com/test/basic-radiobutton-demo.html
     */
    @Test
    public void radioButtons() {
    }

    @Test
    public void multipleRadioButtons() {
    }

    /**
     * Dropdown lists
     * https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
     */
    @Test
    public void selectList() {
    }

    /**
     * Multi-Select Dropdown lists
     * https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
     */
    @Test
    public void multiSelectList() {
    }

}
