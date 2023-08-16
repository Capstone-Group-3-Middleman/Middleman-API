package starter.Utils;

public class Constants {
    public static String BASE_URL = "https://middleman.altapro.online";
    public static final  String DIR = System.getProperty("user.dir");
    public static String JSON = DIR+"/src/test/resources/JSON";

    public static String TOKEN_USER = "";
    public static String TOKEN_ADMIN = "";
    public static String TOKEN_INVALID = "AHsEIClTRVltSkCnavjivYX8mdM68aaxJC7zEbFowB0XCCdbcNCH5SXTsZXdVxhGiCbf8Yw7UlpB6kIj6UUj1ch3GrYOTeC7rHyE";

    /**
     * Inoutbounds
     */
    public static String REQ_BODY_INOUTBOUNDS_POST = JSON + "/ReqBody/Inoutbounds/PostInoutbounds/";
    public static String REQ_BODY_INOUTBOUNDS_GET = JSON + "/ReqBody/Inoutbounds/GetInoutbounds/";
    public static String REQ_BODY_INOUTBOUNDS = JSON + "/ReqBody/Inoutbounds/";

    public static String JSON_SCHEMA_INOUTBOUNDS = JSON + "/JSONSchema/Inoutbounds/";
    public static String JSON_SCHEMA_INOUTBOUNDS_GET = JSON + "/JSONSchema/Inoutbounds/GetInoutbounds/";
    public static String JSON_SCHEMA_INOUTBOUNDS_PUT = JSON + "/JSONSchema/Inoutbounds/PutInoutbounds/";
}
