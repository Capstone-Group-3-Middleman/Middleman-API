package starter.Middleman;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

public class MiddlemanAPI {

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
