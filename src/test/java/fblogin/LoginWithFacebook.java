package fblogin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import user_interface.FBLoginElements;
import user_interface.n11HomePageElements;
import user_interface.n11LoginPageElements;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class LoginWithFacebook implements Task {

    private final String email_text;
    private final String password_text;


    @Step("{0} Login with email '#email_text' and password '#password_text'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(n11HomePageElements.LOGIN_LINK),
                WaitUntil.the(n11LoginPageElements.FB_LOGIN,isClickable()).forNoMoreThan(2).seconds(),
                Click.on(n11LoginPageElements.FB_LOGIN),
                Switch.toNewWindow(),
                Click.on(FBLoginElements.EMAIL_FIELD),
                SendKeys.of(this.email_text).into(FBLoginElements.EMAIL_FIELD),
                Click.on(FBLoginElements.PASSWORD_FIELD),
                SendKeys.of(this.password_text).into(FBLoginElements.PASSWORD_FIELD),
                WaitUntil.the(FBLoginElements.LOGIN_BUTTON,isClickable()).forNoMoreThan(3).seconds(),
                Click.on(FBLoginElements.LOGIN_BUTTON),
                Switch.toNewWindow()
               // WaitUntil.the(FBLoginElements.CONTINUE_BUTTON,isClickable()).forNoMoreThan(3).seconds(),
                //Click.on(FBLoginElements.CONTINUE_BUTTON)

        );



    }

    public LoginWithFacebook(String email_text, String password_text){
        this.email_text = email_text;
        this.password_text = password_text;

    }



    public static LoginWithFacebook loginFacebook(String email_text, String password_text) {
        return instrumented(LoginWithFacebook.class
                ,email_text,password_text);
    }


}
