package serenityswag.authentication.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPage extends PageObject {

    private final static By CHECKOUT_BUTTON = By.id("checkout");
    private final static By TITLE = By.className("title");
    private final static By CART_ITEMS = By.className("cart_item");

    public void checkout() {
        $(CHECKOUT_BUTTON).click();
    }
    public String getTitleText() {
        return $(TITLE).getText();
    }

    public int countProductsInCart() {
        return findAll(".inventory_item_name").size();
    }

    public List<String> productsNamesInCart() {
        return findAll(".inventory_item_name").textContents();
    }

    public List<CartItem> items() {
        return findAll(CART_ITEMS).map(
                item -> new CartItem(
                        item.findBy(".inventory_item_name").getText(),
                        item.findBy(".inventory_item_desc").getText(),
                        priceFormat(item.findBy(".inventory_item_price").getText())
                )
        );
    }

    private Double priceFormat(String value) {
        return Double.parseDouble(value.replace("$", ""));
    }
}
