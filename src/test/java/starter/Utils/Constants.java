package starter.Utils;

public class Constants {
    public static String BASE_URL = "https://middleman.altapro.online";

    public static final  String DIR = System.getProperty("user.dir");

    public static String JSON = DIR+"/src/test/resources/JSON";
    public static String IMAGES = DIR+"/src/test/resources/Images/";

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

    public static String JSON_SCHEMA_LIST_CART = JSON + "/JSONSchema/Carts/ListCart/";
    public static String JSON_SCHEMA_DELETE_CART = JSON + "/JSONSchema/Carts/DeleteCart/";

    public static String JSON_SCHEMA_GET_USER_PRODUCTS = JSON + "/JSONSchema/UserProducts/ListUserProduct/";
    public static String JSON_SCHEMA_SEARCH_USER_PRODUCTS = JSON + "/JSONSchema/UserProducts/SearchUserProduct/";
    public static String JSON_SCHEMA_CREATE_USER_PRODUCTS = JSON + "/JSONSchema/UserProducts/CreateUserProduct/";
    public static String JSON_SCHEMA_UPDATE_USER_PRODUCTS = JSON + "/JSONSchema/UserProducts/UpdateUserProduct/";
    public static String JSON_SCHEMA_DELETE_USER_PRODUCTS = JSON + "/JSONSchema/UserProducts/DeleteUserProduct/";
    public static String REQ_BODY_CREATE_USER_PRODUCTS = JSON + "/ReqBody/UserProducts/CreateUserProduct/";
    public static String REQ_BODY_UPDATE_USER_PRODUCTS = JSON + "/ReqBody/UserProducts/UpdateUserProduct/";


    /**
     * Authentications
     */
    public static String REQ_BODY_LOGIN = JSON + "/ReqBody/Authentications/Login/";
    public static String JSON_SCHEMA_LOGIN = JSON + "/JSONSchema/Authentications/Login/";
    public static String REQ_BODY_REGISTER = JSON + "/ReqBody/Authentications/Register/";
    public static String JSON_SCHEMA_REGISTER = JSON + "/JSONSchema/Authentications/Register/";

    /**
     * Inoutbounds
     */
    public static String REQ_BODY_INOUTBOUNDS_POST = JSON + "/ReqBody/Inoutbounds/PostInoutbounds/";
    public static String REQ_BODY_INOUTBOUNDS_GET = JSON + "/ReqBody/Inoutbounds/GetInoutbounds/";
    public static String REQ_BODY_INOUTBOUNDS = JSON + "/ReqBody/Inoutbounds/";

    public static String JSON_SCHEMA_INOUTBOUNDS = JSON + "/JSONSchema/Inoutbounds/";
    public static String JSON_SCHEMA_INOUTBOUNDS_GET = JSON + "/JSONSchema/Inoutbounds/GetInoutbounds/";
    public static String JSON_SCHEMA_INOUTBOUNDS_PUT = JSON + "/JSONSchema/Inoutbounds/PutInoutbounds/";
    public static String JSON_SCHEMA_LIST_ADMIN_PRODUCTS = JSON + "/JSONSchema/AdminProducts/ListProducts/";
    public static String JSON_SCHEMA_CREATE_ADMIN_PRODUCTS = JSON + "/JSONSchema/AdminProducts/CreateProducts/";
    public static String JSON_SCHEMA_SEARCH_ADMIN_PRODUCTS = JSON + "/JSONSchema/AdminProducts/SearchProducts/";
    public static String JSON_SCHEMA_UPDATE_ADMIN_PRODUCTS = JSON + "/JSONSchema/AdminProducts/UpdateProducts/";
    public static String JSON_SCHEMA_DELETE_ADMIN_PRODUCTS = JSON + "/JSONSchema/AdminProducts/DeleteProducts/";

    public static String REQ_BODY_CREATE_ADMIN_PRODUCTS = JSON + "/ReqBody/AdminProducts/CreateProducts/";
    public static String REQ_BODY_UPDATE_ADMIN_PRODUCTS = JSON + "/ReqBody/AdminProducts/UpdateProducts/";

    /**
     * Inventories
     */
    public static String REQ_BODY_INVENTORY = JSON + "/ReqBody/Inventory/";
    public static String JSON_SCHEMA_INVENTORY = JSON + "/JSONSchema/Inventory/";

}
