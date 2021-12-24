package user_interface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class FBLoginElements {
    /* WebElement Definitions with locator */
    public static Target EMAIL_FIELD = Target.the("email field").locatedBy("//*[@id=\"email\"]");
    public static Target PASSWORD_FIELD = Target.the ("password field").locatedBy("//*[@id=\"pass\"]");
    public static Target LOGIN_BUTTON = Target.the ("login button").locatedBy(".uiButtonConfirm");
    public static Target CONTINUE_BUTTON = Target.the("Continue as name").locatedBy("//div[contains(@aria-label, 'Continue')]");

}
