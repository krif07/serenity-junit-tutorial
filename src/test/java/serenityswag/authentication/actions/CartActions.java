package serenityswag.authentication.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import serenityswag.authentication.inventory.ProductListPage;

public class CartActions extends UIInteractionSteps {

    ProductListPage productListPage;
    ProductDetailsActions productDetailsActions;

    @Step
    public void addItems() {
        String fItemName = productListPage.titles().get(0);
        String sItemName = productListPage.titles().get(1);
        String tItemName = productListPage.titles().get(2);

        productDetailsActions.addProductToCartWithName(fItemName);
        productDetailsActions.addProductToCartWithName(sItemName);
        productDetailsActions.addProductToCartWithName(tItemName);
        productDetailsActions.openShoppingCart();
    }
}
