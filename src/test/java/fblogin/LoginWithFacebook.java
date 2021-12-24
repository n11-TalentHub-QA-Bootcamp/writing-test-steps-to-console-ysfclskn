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
                Click.on(n11HomePageElements.LOGIN_LINK), // Click "Giriş Yap" on HomePage
                WaitUntil.the(n11LoginPageElements.FB_LOGIN,isClickable()).forNoMoreThan(2).seconds(), //Wait for facebook login button to be clickable
                Click.on(n11LoginPageElements.FB_LOGIN), // Click Facebook login button
                Switch.toNewWindow(), //Switch facebook login window
                Click.on(FBLoginElements.EMAIL_FIELD), // Click "E-posta" field
                SendKeys.of(this.email_text).into(FBLoginElements.EMAIL_FIELD), // Send "email_text" to "E-posta" field
                Click.on(FBLoginElements.PASSWORD_FIELD), // Click "Şifre" field
                SendKeys.of(this.password_text).into(FBLoginElements.PASSWORD_FIELD), // Sende "password_text" to "Şifre" field
                WaitUntil.the(FBLoginElements.LOGIN_BUTTON,isClickable()).forNoMoreThan(3).seconds(), // Wait for login button to be clickable
                Click.on(FBLoginElements.LOGIN_BUTTON), // Click "Giriş Yap" button
                Switch.toNewWindow() // Switch n11 homePage
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
