package starter.Middleman;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class UserProductsAPI {

    public static String GET_LIST_USER_PRODUCTS = Constants.BASE_URL + "/users/{path}";
    public static String GET_SEARCH_USER_PRODUCTS = Constants.BASE_URL + "/users/products/search?productname={prodName}";
    public static String POST_CREATE_USER_PRODUCTS = Constants.BASE_URL + "/users/products";
    public static String PUT_UPDATE_USER_PRODUCTS = Constants.BASE_URL + "/users/products/{idproduct}";
    public static String DELETE_USER_PRODUCTS = Constants.BASE_URL + "/users/products/{id}";

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

    @Step("Search User Product valid token")
    public void getSearchUserProducts(String prodName) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .pathParam("prodName", prodName);
    }

    @Step("Search User Product invalid token")
    public void getSearchUserProductsInvalidToken(String prodName) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_INVALID)
                .pathParam("prodName", prodName);
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

    @Step("Update User Product valid token")
    public void putUpdateUserProduct(String idProd, File json) {
        JsonPath fileJson = new JsonPath(json);
        File image = new File(Constants.IMAGES + "gambar2.jpg");
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .pathParam("idproduct", idProd)
                .multiPart("product_image", image)
                .formParam("product_name", fileJson.get("product_name").toString())
                .formParam("unit", fileJson.get("unit").toString())
                .formParam("stock", fileJson.get("stock").toString())
                .formParam("price", fileJson.get("price").toString());
    }

    @Step("Update User Product valid token")
    public void putUpdateUserProductInvalidToken(String idProd, File json) {
        JsonPath fileJson = new JsonPath(json);
        File image = new File(Constants.IMAGES + "gambar2.jpg");
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_INVALID)
                .pathParam("idproduct", idProd)
                .multiPart("product_image", image)
                .formParam("product_name", fileJson.get("product_name").toString())
                .formParam("unit", fileJson.get("unit").toString())
                .formParam("stock", fileJson.get("stock").toString())
                .formParam("price", fileJson.get("price").toString());
    }

    @Step("Create User Product valid token")
    public void putUpdateUserProductEmptyImage(String idProd, File json) {
        JsonPath fileJson = new JsonPath(json);
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .pathParam("idproduct", idProd)
                .formParam("product_image", fileJson.get("product_image").toString())
                .formParam("product_name", fileJson.get("product_name").toString())
                .formParam("unit", fileJson.get("unit").toString())
                .formParam("stock", fileJson.get("stock").toString())
                .formParam("price", fileJson.get("price").toString());
    }

    @Step("Delete User Product valid token")
    public void deleteUserProducts(String id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .pathParam("id", id);
    }

    @Step("Delete User Product invalid token")
    public void deleteUserProductsInvalidToken(String id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_INVALID)
                .pathParam("id", id);
    }
}
