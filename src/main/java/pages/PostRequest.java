package pages;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostRequest extends BaseClass {
    Map<String, Object> map = new HashMap<>();

    public Response sendPostRequestWithMandatoryFields(String url, String categoryName, String categoryId) {
        map.put("name", categoryName);
        map.put("id", categoryId);


        return given().baseUri(url).accept(ContentType.JSON).contentType(ContentType.JSON).body(map).when().post();
    }

    public Response sendPostRequestWithAdditionalProperties(String url, String categoryName, String categoryId, String createdDate, String updatedDate) {
        map.put("name", categoryName);
        map.put("id", categoryId);
        map.put("createdAt", createdDate);
        map.put("updatedAt", updatedDate);


        return given().baseUri(url).accept(ContentType.JSON).contentType(ContentType.JSON).body(map).when().post();
    }
}
