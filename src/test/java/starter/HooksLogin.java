package starter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import starter.Utils.Constants;

import java.io.File;

public class HooksLogin {

    @Before("@TokenUser")
    public void loginUser(){
        File json = new File("src/test/resources/JSON/ReqBody/Authentications/Login/ValidLoginUser.json");
        Response response= SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(Constants.BASE_URL+"/login");
        JsonPath jsonPath = response.jsonPath();
        Constants.TOKEN_USER = jsonPath.get("data.token");
    }

    @Before("@TokenAdmin")
    public void loginAdmin(){
        File json = new File("src/test/resources/JSON/ReqBody/Authentications/Login/ValidLoginAdmin.json");
        Response response= SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(Constants.BASE_URL+"/login");
        JsonPath jsonPath = response.jsonPath();
        Constants.TOKEN_ADMIN = jsonPath.get("data.token");
    }

    @After("@TokenUser")
    public void resetTokenUser() {
        Constants.TOKEN_USER = null;
    }
    @After("@TokenAdmin")
    public void resetTokenAdmin() {
        Constants.TOKEN_ADMIN = null;
    }
    @After("@TokenAdmin")
    public void resetTokenAdmin() {
        Constants.TOKEN_ADMIN = null;
    }
}