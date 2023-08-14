package starter.Middleman;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class UserProductsAPI {

    public static String GET_LIST_USER_PRODUCTS = Constants.BASE_URL + "/users/{path}";
    public static String POST_CREATE_USER_PRODUCTS = Constants.BASE_URL + "/users/products";

    @Step("List User Product valid token")
    public void getListUserProducts(String path) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .pathParam("path", path);
    }

    @Step("List User Product invalid token")
    public void getListUserProductsInvalidToken(String path) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_INVALID)
                .pathParam("path", path);
    }

    @Step("Create User Product valid token")
    public void postCreateUserProduct(File json) {
        JsonPath fileJson = new JsonPath(json);
        File image = new File(Constants.IMAGES + "gambar1.jpg");
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .multiPart("product_image", image)
                .formParam("product_name", fileJson.get("product_name").toString())
                .formParam("unit", fileJson.get("unit").toString())
                .formParam("stock", fileJson.get("stock").toString())
                .formParam("price", fileJson.get("price").toString());
    }

    @Step("Create User Product valid token")
    public void postCreateUserProductInvalidToken(File json) {
        JsonPath fileJson = new JsonPath(json);
        File image = new File(Constants.IMAGES + "gambar1.jpg");
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_INVALID)
                .multiPart("product_image", image)
                .formParam("product_name", fileJson.get("product_name").toString())
                .formParam("unit", fileJson.get("unit").toString())
                .formParam("stock", fileJson.get("stock").toString())
                .formParam("price", fileJson.get("price").toString());
    }

    @Step("Create User Product valid token")
    public void postCreateUserProductEmptyImage(File json) {
        JsonPath fileJson = new JsonPath(json);
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .formParam("product_image", fileJson.get("product_image").toString())
                .formParam("product_name", fileJson.get("product_name").toString())
                .formParam("unit", fileJson.get("unit").toString())
                .formParam("stock", fileJson.get("stock").toString())
                .formParam("price", fileJson.get("price").toString());
    }
}
