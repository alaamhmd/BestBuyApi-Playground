package tests;

import com.github.javafaker.Faker;
import data.LoadProperties;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DeleteRequest;

public class VerifyDeleteRequest extends TestBase {
    @Test
    public void verifyDeleteExistRecord() {
        VerifyPostRequest verifyPostRequest = new VerifyPostRequest();
        fakeData = new Faker();
        softAssert = new SoftAssert();
        DeleteRequest deleteRequest = new DeleteRequest();
        response = deleteRequest.deleteCategory(baseURL,
                verifyPostRequest.verifyPostRequestWithMandatoryFields());
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertAll();

    }

    @Test
    public void verifyDeleteNonExistRecord() {
        fakeData = new Faker();
        softAssert = new SoftAssert();
        id = fakeData.numerify("#####");
        DeleteRequest deleteRequest = new DeleteRequest();
        response = deleteRequest.deleteCategory(baseURL, id);
        softAssert.assertEquals(response.getStatusCode(), 404);
        softAssert.assertEquals(response.jsonPath().getString("name"),
                LoadProperties.userData.getProperty("errorMsgForNotFoundRecords"));
        softAssert.assertAll();

    }
}
