package starter.Middleman;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

import static starter.Utils.Constants.TOKEN_ADMIN;
import static starter.Utils.Constants.TOKEN_USER;

public class InventoriesAPI {
    public static String POST_USERS_INVENTORY = Constants.BASE_URL + "/users/inventory";
    public static String POST_USERS_INVENTORY_PATH = Constants.BASE_URL + "/users/inventory/{path}";
    public static String POST_USERS_INVENTORYS = Constants.BASE_URL + "/users/inventorys";
    public static String POST_ADMIN_INVENTORY = Constants.BASE_URL + "/admins/inventory";
    public static String POST_ADMIN_INVENTORY_PATH = Constants.BASE_URL + "/admins/inventory/{path}";

    @Step("User without token")
    public void getUserInventoryWithoutToken() {
        SerenityRest.given()
                .header("Authorization", "Bearer ");
    }

    @Step("User invalid token")
    public void getUserInventoryInvalidToken() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_INVALID);
    }

    @Step("User valid token")
    public void getUserInventoryValidToken() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN_USER);
    }


    @Step("User valid token")
    public void setUserInventoryValidToken(File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("User valid admin")
    public void getAdminInventoryValidToken() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_ADMIN);
    }
    @Step("User valid admin")
    public void setAdminInventoryValidToken(File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN_ADMIN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get user inventory")
    public void getUserInventory(String path){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .pathParam("path", path);
    }

    @Step("Get admin inventory")
    public void getAdminInventory(String path){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_ADMIN)
                .pathParam("path", path);
    }

    @Step("Get invalid inventory")
    public void getInvalidTokenInventory(String path){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_INVALID)
                .pathParam("path", path);
    }

    @Step("Get invalid inventory")
    public void getWithoutTokenInventory(String path){
        SerenityRest.given()
                .header("Authorization", "Bearer ")
                .pathParam("path", path);
    }
}
