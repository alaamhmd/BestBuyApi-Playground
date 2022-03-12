package tests;

import com.github.javafaker.Faker;
import data.LoadProperties;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UpdateRequest;

public class VerifyUpdateRequest extends TestBase {
    @Test
    public void updateExistRecord() {
        VerifyPostRequest verifyPostRequest = new VerifyPostRequest();
        fakeData = new Faker();
        softAssert = new SoftAssert();
        name = fakeData.app().name();
        updateRequest = new UpdateRequest();
        response = updateRequest.updateRequest(baseURL, name, verifyPostRequest.verifyPostRequestWithMandatoryFields());
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(response.jsonPath().getString("name"), name);
        softAssert.assertAll();


    }

    @Test
    public void verifyUpdateNonExistRecord() {
        fakeData = new Faker();
        softAssert = new SoftAssert();
        id = fakeData.numerify("#####");
        name = fakeData.letterify("???????");
        updateRequest = new UpdateRequest();
        response = updateRequest.updateRequest(baseURL, name, id);
        softAssert.assertEquals(response.getStatusCode(), 404);
        softAssert.assertEquals(response.jsonPath().getString("name"), LoadProperties.userData.getProperty("errorMsgForNotFoundRecords"));
        softAssert.assertAll();

    }


}
