package starter.Middleman;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class AuthenticationsAPI {
    /**
     * Authentications
     */
    public static String POST_REGISTER_USER = Constants.BASE_URL + "/register";
    public static String POST_REGISTER_USER_INVALID_PATH = Constants.BASE_URL + "/xyz";
    public static String POST_LOGIN_USER = Constants.BASE_URL + "/login";

    /**
     *
     * Authentications
     */
    @Step("Create new user")
    public void postRegisterUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Login User")
    public void postLoginUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
