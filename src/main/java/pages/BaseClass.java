package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class BaseClass {


    Response response;


    public int getPageResponse(String url) {

        return given().get(url).getStatusCode();

    }


}


