package starter.Middleman;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

import static starter.Utils.Constants.*;

public class InoutboundsAPI {

    public static String POST_INOUTBOUNDS = Constants.BASE_URL + "/inoutbounds";
    public static String GET_LIST_INOUTBOUNDS = Constants.BASE_URL + "/inoutbounds";
    public static String GET_INVALID_INOUTBOUNDS = Constants.BASE_URL + "/inoutbounds/";
    public static String PUT_INOUTBOUND = Constants.BASE_URL + "/inoutbounds/{path}";
    public static String DELETE_INOUTBOUND = Constants.BASE_URL + "/inoutbounds/{path}";


    @Step("User without token")
    public void getUserInoutboundsWithoutToken() {
        SerenityRest.given()
                .header("Authorization", "Bearer ");
    }

    @Step("User invalid token")
    public void getInoutboundsInvalidToken() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_INVALID);
    }

    @Step("User valid token")
    public void getUserInoutbounds() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER);
    }

    @Step("Admin valid token")
    public void getAdminInoutbounds() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN_ADMIN);
    }

    /**
     * POST
     */
    @Step("Create new inoutbounds")
    public void postCreateInounboundsUser(File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN_USER)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Create new inoutbounds admin")
    public void postCreateInounboundsAdmin(File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN_ADMIN)
                .contentType(ContentType.JSON)
                .body(json);
    }


    /**
     * GET
     */
    @Step("Get admin carts on inoutbounds with path")
    public void getCartInoutboundsAdminWithPath(String path) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_ADMIN)
                .pathParam("path",path);
    }

    /**
     * UPDATE
    */
    @Step("User put without token")
    public void putInoutboundsWithoutToken(String path) {
        SerenityRest.given()
                .headers("Authorization", "Bearer ")
                .pathParam("path",path);
    }

    @Step("User put with invalid token")
    public void putInoutboundsInvalidToken(String path) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_INVALID)
                .pathParam("path",path);
    }

    @Step("Update qty product inoutbounds")
    public void updateQtyInoutboundsQTY(File json, String path){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_USER)
                .pathParam("path", path)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Admin update qty product inoutbounds")
    public void adminUpdateQtyInoutboundsQTY(File json, String path){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_ADMIN)
                .pathParam("path", path)
                .contentType(ContentType.JSON)
                .body(json);
    }

    /**
     * DELETE
     */
    @Step("User without token")
    public void deleteInoutboundsWithoutToken(String path) {
        SerenityRest.given()
                .header("Authorization", "Bearer ")
                .pathParam("path", path);
    }

    @Step("Delete product inoutbounds token invalid")
    public void deleteProductInoutboundsInvalid(String path) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_INVALID)
                .pathParam("path", path);
    }

    @Step("Delete product inoutbounds token user")
    public void deleteProductInoutboundsUser(String path) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_USER)
                .pathParam("path", path);
    }

    @Step("Delete product inoutbounds Admin")
    public void deleteProductInoutboundsAdmin(String path) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + TOKEN_ADMIN)
                .pathParam("path", path);
    }
}
