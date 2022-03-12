package tests;

import com.github.javafaker.Faker;

import data.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.GetRequest;
import pages.BaseClass;
import pages.PostRequest;

public class VerifyPostRequest extends TestBase {


    @Test
    public void verifyResponseCodeForCategories() {
        baseClass = new BaseClass();
        int responseCode = baseClass.getPageResponse(baseURL);
        Assert.assertEquals(responseCode, 200);

    }

    @Test(dependsOnMethods = {"verifyResponseCodeForCategories"})

    public String verifyPostRequestWithMandatoryFields() {
        postRequest = new PostRequest();
        getRequest = new GetRequest();
        softAssert = new SoftAssert();
        fakeData = new Faker();

        id = fakeData.letterify("??????");
        name = fakeData.app().name();
        response = postRequest.sendPostRequestWithMandatoryFields(baseURL, name, id);
        softAssert.assertEquals(response.getStatusCode(), 201);
        response = getRequest.getRequestSpecificParameterValue(baseURL, "id", id);
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertAll();
        getRequest.matchRequestSpecificParameterValue(baseURL, id, name, "name");
        return response.jsonPath().getString("id");
    }

    @Test(dependsOnMethods = {"verifyResponseCodeForCategories"})

    public void verifyPostRequestWithEmptyMandatoryFields() {
        postRequest = new PostRequest();
        softAssert = new SoftAssert();
        response = postRequest.sendPostRequestWithMandatoryFields(baseURL, name, id);
        softAssert.assertEquals(response.getStatusCode(), 400);
        softAssert.assertAll();


    }

    @Test(dependsOnMethods = {"verifyResponseCodeForCategories"})

    public void verifyPostRequestWithAdditionalProperties() {
        getRequest = new GetRequest();
        postRequest = new PostRequest();
        softAssert = new SoftAssert();
        fakeData = new Faker();

        response = postRequest.sendPostRequestWithAdditionalProperties(baseURL, name, id, LoadProperties.userData.getProperty("createdAt"), LoadProperties.userData.getProperty("updatedAt"));
        softAssert.assertEquals(response.getStatusCode(), 400);
        softAssert.assertEquals(response.jsonPath().getString("message"), LoadProperties.userData.getProperty("errorMsgForPostAdditionalProp2"));
        softAssert.assertEquals(response.jsonPath().getString("errors"), LoadProperties.userData.getProperty("errorMsgForPostAdditionalProp1"));
        softAssert.assertAll();


    }


}
