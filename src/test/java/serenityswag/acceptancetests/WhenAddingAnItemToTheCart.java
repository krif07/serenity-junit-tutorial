package serenityswag.acceptancetests;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import serenityswag.authentication.User;
import serenityswag.authentication.actions.CartActions;
import serenityswag.authentication.actions.LoginActions;
import serenityswag.authentication.actions.ProductDetailsActions;
import serenityswag.authentication.inventory.CartItem;
import serenityswag.authentication.inventory.CartPage;
import serenityswag.authentication.inventory.ProductListPage;

import java.util.List;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenAddingAnItemToTheCart {

    @Steps
    LoginActions loginActions;

    @Steps
    ProductDetailsActions productDetailsActions;

    @Steps
    CartActions cartActions;

    ProductListPage productListPage;
    CartPage cartPage;

    @Test
    @DisplayName("Should be able to add items to the cart")
    public void theCorrectItemCountShouldBeShown(){
        loginActions.as(User.STANDARD_USER);
        String firstItemName = productListPage.titles().get(0);
        String secondItemName = productListPage.titles().get(1);
        productDetailsActions.addProductToCartWithName(firstItemName);
        productDetailsActions.addProductToCartWithName(secondItemName);
        int totalProductsInCart = productListPage.totalShoppingCartBadge();
        Serenity.reportThat("Total products in cart should be 2",
                () -> Ensure.that(totalProductsInCart).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("Should be able to add items and listed them")
    public void allTheItemsShouldAppearInTheCart() {
        loginActions.as(User.STANDARD_USER);

        String fItemName = productListPage.titles().get(0);
        String sItemName = productListPage.titles().get(1);
        String tItemName = productListPage.titles().get(2);

        productDetailsActions.addProductToCartWithName(fItemName);
        productDetailsActions.addProductToCartWithName(sItemName);
        productDetailsActions.addProductToCartWithName(tItemName);
        productDetailsActions.openShoppingCart();

        Serenity.reportThat("Total products in cart should be 3",
                () -> Ensure.that(cartPage.countProductsInCart()).isEqualTo(3)
        );
        Serenity.reportThat("All added items should be in cart",
                () -> {
                    List<String> itemsNames = cartPage.productsNamesInCart();
                    Ensure.that(itemsNames.contains(fItemName)).isTrue();
                    Ensure.that(itemsNames.contains(sItemName)).isTrue();
                    Ensure.that(itemsNames.contains(tItemName)).isTrue();
        });
        Serenity.reportThat("All added items should be in cart",
                () -> {
                    List<String> itemsNames = cartPage.productsNamesInCart();
                    Ensure.that(itemsNames).containsOnly(fItemName, sItemName, tItemName);
                });
    }

    @Test
    public void pricesForEachItemShouldBeShownInTheCart() {
        loginActions.as(User.STANDARD_USER);
        cartActions.addItems();
        cartPage.open();
        List<CartItem> items = cartPage.items();
        Serenity.reportThat("Total products in cart should be 3",
                () -> Ensure.that(items).hasSize(3)
        );
        Serenity.reportThat("Total products in cart should have price:",
                () -> Ensure.that(items).allMatch(
                        "Item price grater than",
                        item -> item.price() > 0.0)
        );
    }
}
