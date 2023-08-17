package starter.Middleman;


import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

public class AdminProductsAPI {
    public static String LIST_ADMIN_PRODUCTS = Constants.BASE_URL + "/admins/{path}";

    @Step
    public void getListAdminProduct(String path) {
        SerenityRest.given()
                .pathParam("path", path);
    }
}
