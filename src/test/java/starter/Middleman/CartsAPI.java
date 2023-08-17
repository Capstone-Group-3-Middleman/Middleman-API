package starter.Middleman;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;


public class CartsAPI {

    public static String GET_LIST_CARTS = Constants.BASE_URL + "/{path}";

    public static String DELETE_CARTS = Constants.BASE_URL + "/carts/{idproduct}";

    @Step("List Cart valid token")
    public void getListCart(String path) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .pathParam("path", path);
    }

    @Step("List Cart invalid token")
    public void getListCartInvalidToken(String path) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_INVALID)
                .pathParam("path", path);
    }

    @Step("Delete Cart valid token")
    public void deleteCart(String idProd) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .pathParam("idproduct", idProd);
    }

    @Step("Delete Cart invalid token")
    public void deleteCartInvalidToken(String idProd) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_INVALID)
                .pathParam("idproduct", idProd);
    }
}
