package tests;

import com.github.javafaker.Faker;
import data.LoadProperties;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import pages.GetRequest;
import pages.BaseClass;
import pages.PostRequest;
import pages.UpdateRequest;


public class TestBase {
    Faker fakeData;
    String name;
    String id;
    SoftAssert softAssert;
    BaseClass baseClass;
    PostRequest postRequest;
    Response response;
    GetRequest getRequest;
    UpdateRequest updateRequest;
    String baseURL = LoadProperties.userData.getProperty("baseURL");

    }




