package serenityswag.authentication;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class LoggingTo {

    public static Performable theLoggingHomePage() {
        return Task.where("{0} logging on the sauce demo home page",
                Open.browserOn().the(SauceDemoHomePage.class));
    }
}
