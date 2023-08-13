package starter.Middleman;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import starter.Utils.Constants;

import java.io.File;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

public class MiddlemanAPI {

    /**
     * Authentications
     */
    public static String POST_REGISTER_USER = Constants.BASE_URL + "/register";
    public static String POST_REGISTER_USER_INVALID_PATH = Constants.BASE_URL + "/xyz";

    public static String POST_LOGIN_USER = Constants.BASE_URL + "/login";
    public static String POST_LOGIN_ADMIN = Constants.BASE_URL + "/login";


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
    /**
     * Users
     */

    public static String GET_USER = Constants.BASE_URL + "/{path}";


    /**
     * Users
     */

    @Step("User valid token")
    public void getUser(String path) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .pathParam("path", path);
    }

    @Step("User invalid token")
    public void getUserInvalidToken(String path) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_INVALID)
                .pathParam("path", path);
    }

}
