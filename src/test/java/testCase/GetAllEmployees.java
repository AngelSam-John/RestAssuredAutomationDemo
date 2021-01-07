package testCase;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetAllEmployees extends TestBase {

    @BeforeClass
    void getAllEmployees()
    {
        logger.info("************ Started Get All Employee *************");
        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
        requestSpecification=RestAssured.given();
        response=requestSpecification.request(Method.GET,"/employees");

    }

    @Test
    void checkResponseBody()
    {
        logger.info("********** Checking response body *************");

        String responseBody=response.getBody().asString();
        logger.info("Response body -->" +responseBody);
        Assert.assertTrue(responseBody!=null);
    }

    @Test
    void checkStatusCode()
    {
        logger.info("************ Checking Status Code ***************");

        int statusCode=response.getStatusCode();
        logger.info("Status code-->" +statusCode);
        Assert.assertEquals(statusCode,200);
    }
    @Test
    void checkStatusLine()
    {
        logger.info("************ Checking Status Line ***************");

        String statusLine=response.getStatusLine();
        logger.info("Status code-->" +statusLine);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
    }


    @AfterClass
    void tearDown()
    {
        logger.info("************Finishing Get All EMployees *********");
    }
}


