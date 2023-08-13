package starter.Middleman;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class MiddlemanAPI {

    /**
     * Users
     */

    public static String GET_USER = Constants.BASE_URL + "/{path}";
    public static String PUT_UPDATE_USER = Constants.BASE_URL + "/users";


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

    @Step
    public void putUpdateUser(File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step
    public void putUpdateUserInvalidToken(File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_INVALID)
                .contentType(ContentType.JSON)
                .body(json);
    }

}
