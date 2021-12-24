package user_interface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class n11HomePageElements {
    public static Target LOGIN_LINK = Target.the("search field").located(By.linkText("Giriş Yap"));
    public static Target USERNAME_TEXT = Target.the("username text").locatedBy(".menuLink.user");
}
