package starter.Middleman;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class CartsAPI {

    public static String POST_CARTS = Constants.BASE_URL + "/carts";
    public static String POST_CARTS_PATH = Constants.BASE_URL + "/carts/{id}";
    public static String POST_CARTS_INVALID = Constants.BASE_URL + "/cartss";
    public static String GET_LIST_CARTS = Constants.BASE_URL + "/{path}";
    public static String DELETE_CARTS = Constants.BASE_URL + "/carts/{idproduct}";

    @Step("Post cart without token")
    public void postCartWithoutToken(){
        SerenityRest.given()
                .header("Authorization", "Bearer ");
    }

    @Step("Post cart with token user")
    public void postCartWithTokenUser(){
        SerenityRest.given()
                .header("Authorization", "Bearer "+ Constants.TOKEN_USER);
    }

    @Step("Post cart with token admin")
    public void postCartWithTokenAdmin(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_ADMIN);
    }

    @Step("Post cart invalid token")
    public void postCartWithTokenInvalid(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_INVALID);
    }

    @Step("Post Cart valid token user")
    public void postCart(File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Cart valid token admin")
    public void postCartAdmin(File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_ADMIN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Cart valid token admins")
    public void postCartAdmisn(String path) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_ADMIN)
                .pathParam("path", path);
    }


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

    public void putInvalidPath(File json, String id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    public void putsInvalidPath(File json, String id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_INVALID)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    public void putsInvalidPaths(File json, String id){
        SerenityRest.given()
                .header("Authorization", "Bearer ")
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

}
