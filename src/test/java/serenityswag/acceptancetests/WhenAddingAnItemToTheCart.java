package serenityswag.acceptancetests;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import serenityswag.authentication.User;
import serenityswag.authentication.actions.LoginActions;
import serenityswag.authentication.actions.ProductDetailsActions;
import serenityswag.authentication.inventory.ProductListPage;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenAddingAnItemToTheCart {

    @Steps
    LoginActions loginActions;

    @Steps
    ProductDetailsActions productDetailsActions;

    ProductListPage productListPage;

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
    public void allTheItemsShouldAppearInTheCart() {

    }
}
