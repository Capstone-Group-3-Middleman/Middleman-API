package starter.Middleman;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

public class UserProductsAPI {

    public static String GET_LIST_USER_PRODUCTS = Constants.BASE_URL + "/users/{path}";

    @Step
    public void getListUserProducts(String path) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .pathParam("path", path);
    }

    @Step
    public void getListUserProductsInvalidToken(String path) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_INVALID)
                .pathParam("path", path);
    }

}
