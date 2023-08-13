package starter.Utils;

public class Constants {
    public static String BASE_URL = "https://middleman.altapro.online";

    public static final  String DIR = System.getProperty("user.dir");

    public static String JSON = DIR+"/src/test/resources/JSON";

    public static String TOKEN_USER = "";
    public static String TOKEN_ADMIN = "";
    public static String TOKEN_INVALID = "AHsEIClTRVltSkCnavjivYX8mdM68aaxJC7zEbFowB0XCCdbcNCH5SXTsZXdVxhGiCbf8Yw7UlpB6kIj6UUj1ch3GrYOTeC7rHyE";

    /**
     * Users
     */

    public static String JSON_SCHEMA_USER = JSON + "/JSONSchema/Users/GetUser/";
    public static String JSON_SCHEMA_UPDATE_USER = JSON + "/JSONSchema/Users/UpdateUser/";
    public static String JSON_SCHEMA_DELETE = JSON + "/JSONSchema/Users/DeleteUser/";
    public static String REQ_BODY_UPDATE = JSON + "/ReqBody/Users/UpdateUser/";

    public static String REQ_BODY_UPDATE = JSON + "/ReqBody/Users/UpdateUser/";



    /**
     * Authentications
     */

    public static String REQ_BODY_LOGIN = JSON + "/ReqBody/Authentications/Login/";
    public static String JSON_SCHEMA_LOGIN = JSON + "/JSONSchema/Authentications/Login/";
    public static String REQ_BODY_REGISTER = JSON + "/ReqBody/Authentications/Register/";
    public static String JSON_SCHEMA_REGISTER = JSON + "/JSONSchema/Authentications/Register/";
}
