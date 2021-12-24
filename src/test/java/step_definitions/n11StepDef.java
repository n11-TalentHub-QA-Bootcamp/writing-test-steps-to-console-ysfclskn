package step_definitions;

import fblogin.LoginWithFacebook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.actions.SwitchToNewWindow;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import tasks.NavigateTo;
import user_interface.FBLoginElements;
import user_interface.n11HomePageElements;
import user_interface.n11LoginPageElements;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actions.Hit.the;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class n11StepDef {

    Actor actor = Actor.named("Yusuf");
    @Managed
    WebDriver webDriver;
    @Given("user launch browser and open the main page")
    public void userLaunchBrowserAndOpenTheMainPage() {
        actor.can(BrowseTheWeb.with(webDriver));
        actor.wasAbleTo(NavigateTo.theN11HomePage());
    }

    @When("user logged in with facebook")
    public void userLoggedInWithFacebook() {
        actor.attemptsTo(
                LoginWithFacebook.loginFacebook("lespazalte@vusra.com","user1234")
        );

    }

    @Then("user logged in succesfully")
    public void userLoggedInSuccesfully() {
            actor.attemptsTo(
                    Ensure.that(n11HomePageElements.USERNAME_TEXT)
                            .text()
                            .isEqualTo("Lespazalte Lespazalte")
            );
    }
}
