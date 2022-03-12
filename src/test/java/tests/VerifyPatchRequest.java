package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.PatchRequest;

public class VerifyPatchRequest extends TestBase {
    @Test
    public void patchExistRecord() {
        VerifyPostRequest verifyPostRequest = new VerifyPostRequest();
        fakeData = new Faker();
        softAssert = new SoftAssert();
        name = fakeData.app().name();
        PatchRequest patchRequest = new PatchRequest();
       response= patchRequest.patchRequest(baseURL,
                name, verifyPostRequest.verifyPostRequestWithMandatoryFields());
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(response.jsonPath().getString("name"), name);
        softAssert.assertAll();


    }

}
