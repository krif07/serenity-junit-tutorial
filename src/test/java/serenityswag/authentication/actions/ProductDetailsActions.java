package serenityswag.authentication.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import serenityswag.authentication.inventory.ProductListPage;

public class ProductDetailsActions extends UIInteractionSteps {

    @Step("View product details for product '{0}'")
    public void forProductWithName(String firstItemName) {
        $(ProductListPage.productDetailsLinkFor(firstItemName)).click();
    }
}
