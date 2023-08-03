package serenityswag.authentication.inventory;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

public class ProductListPage extends PageObject {

    public List<String> titles() {
        return findAll(".inventory_item_name").textContents();
    }

    public String imageTextForProduct(String productName) {
        return "";
    }

    public static By productDetailsLinkFor(String itemName) {
        return By.linkText(itemName);
    }

    public static By productAddToCartButtonByName(String productName) {
        return By.xpath("//div[text()='" + productName + "']/../../following-sibling::div/button");
    }

    public int totalShoppingCartBadge() {
        return Integer.parseInt($(".shopping_cart_badge").getText());
    }
}
