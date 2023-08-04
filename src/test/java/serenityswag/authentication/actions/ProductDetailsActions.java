package serenityswag.authentication.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import serenityswag.authentication.inventory.ProductListPage;

public class ProductDetailsActions extends UIInteractionSteps {

    @Step("View product details for product '{0}'")
    public void forProductWithName(String itemName) {
        $(ProductListPage.productDetailsLinkFor(itemName)).click();
    }

    @Step
    public void addProductToCartWithName(String itemName) {
        $(ProductListPage.productAddToCartButtonByName(itemName)).click();
    }

    @Step
    public void openShoppingCart() {
        $(ProductListPage.shoppingCartLink()).click();
    }

}
