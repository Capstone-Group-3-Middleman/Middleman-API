package starter.Middleman;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class AdminProductsAPI {
    public static String LIST_ADMIN_PRODUCTS = Constants.BASE_URL + "/admins/{path}";

    public static String CREATE_ADMIN_PRODUCTS = Constants.BASE_URL + "/admins/products";

    public static String SEARCH_ADMIN_PRODUCTS = Constants.BASE_URL + "/admins/products/search?productname={prodName}";

    public static String UPDATE_ADMIN_PRODUCTS = Constants.BASE_URL + "/admins/products/{idProd}";

    @Step("List Admin Products")
    public void getListAdminProduct(String path) {
        SerenityRest.given()
                .pathParam("path", path);
    }

    @Step("Create new admin product")
    public void postCreateAdminProduct(File json) {
        JsonPath fileJson = new JsonPath(json);
        File image = new File(Constants.IMAGES + "gambar1.jpg");
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_ADMIN)
                .multiPart("product_image", image)
                .formParam("product_name", fileJson.get("product_name").toString())
                .formParam("unit", fileJson.get("unit").toString())
                .formParam("stock", fileJson.get("stock").toString())
                .formParam("price", fileJson.get("price").toString());
    }

    @Step("Search Admin Products")
    public void getSearchAdminProduct(String prodName) {
        SerenityRest.given()
                .pathParam("prodName", prodName);
    }

    @Step("Update User Product valid token")
    public void putUpdateAdminProduct(String idProd, File json) {
        JsonPath fileJson = new JsonPath(json);
        File image = new File(Constants.IMAGES + "gambar1.jpg");
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_ADMIN)
                .pathParam("idProd", idProd)
                .multiPart("product_image", image)
                .formParam("product_name", fileJson.get("product_name").toString())
                .formParam("unit", fileJson.get("unit").toString())
                .formParam("stock", fileJson.get("stock").toString())
                .formParam("price", fileJson.get("price").toString());
    }

}
