package pages;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UpdateRequest extends BaseClass {
    Map<String, Object> map = new HashMap<>();

    public Response updateRequest(String path, String categoryName, String categoryId) {
        map.put("name", categoryName);
        map.put("id", categoryId);
        return response = given().header("Content-type", "application/json").and().body(map).when().put(path + categoryId).then().extract().response();


    }
}
