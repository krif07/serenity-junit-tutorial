package serenityswag.authentication.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;

public class ProductDetailsPage extends PageObject {

    public String productName() {
        return $(".inventory_details_name").getText();
    }

    public WebElementState productImageWithAltValueOf(String firstItemName) {
        return $(".inventory_details_container img[alt='" + firstItemName + "']");
    }
}
