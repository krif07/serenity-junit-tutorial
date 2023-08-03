package serenityswag.acceptancetests;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import serenityswag.authentication.LoggingTo;
import serenityswag.authentication.User;
import serenityswag.authentication.actions.LoginActions;
import serenityswag.authentication.inventory.InventoryPage;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLoginOn {

    @CastMember
    Actor actor;

    @Steps
    LoginActions loginActions;

    InventoryPage inventoryPage;

    @Test
    @DisplayName("Should be able to login on the home page")
    void userCanLogOnViaTheHomePage() {
        actor.attemptsTo(
                LoggingTo.theLoggingHomePage()
        );
    }

    @Test
    @DisplayName("Should be able to login and get the heading title")
    public void usersCanLogOnViaTheHomePage(){
        loginActions.as(User.STANDARD_USER);
        Serenity.reportThat("The inventory should be displayed with the correct title",
                ()-> Ensure.that(inventoryPage.getHeading()).containsIgnoringCase("Products")
        );
    }
}
