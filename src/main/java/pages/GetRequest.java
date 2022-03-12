package pages;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest extends BaseClass {
    public Response getRequestSpecificParameterValue(String url, String parmName, String parmValue) {
        return given().contentType(ContentType.JSON).param(parmName, parmValue).when().get(url + parmValue).then().extract().response();

    }

    public void matchRequestSpecificParameterValue(String url, String parmValue1, String parmValue2, String parmName) {
        given().contentType(ContentType.JSON).when().get(url + parmValue1).then().body(parmName, equalTo(parmValue2));


    }
}
