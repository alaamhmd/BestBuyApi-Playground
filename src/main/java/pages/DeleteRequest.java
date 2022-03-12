package pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteRequest extends BaseClass {

    public Response deleteCategory(String url, String parmValue1) {
        return given().baseUri(url + parmValue1).delete();


    }
}

