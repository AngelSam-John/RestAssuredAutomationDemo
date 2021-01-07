package testCase;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.RestUtils;

public class PostEmployeeRecord extends TestBase {

    String empName= RestUtils.employeeName();
    String empSalary=RestUtils.employeeSalary();
    String empAge=RestUtils.employeeAge();

    @BeforeClass
    void createEmployee()
    {
        logger.info("************ Started Create Employee *************");

        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
        requestSpecification=RestAssured.given();

        JSONObject requestParams=new JSONObject();

        requestParams.put("name",empName);
        requestParams.put("salary",empSalary);
        requestParams.put("age",empAge);

        requestSpecification.header("Content-Type","application/json");

        requestSpecification.body(requestParams.toJSONString());

        response=requestSpecification.request(Method.POST,"/create");

    }


    @Test
    void checkResponseBody()
    {
        logger.info("********** Checking response body *************");

        String responseBody=response.getBody().asString();
        logger.info("Response body -->" +responseBody);
        Assert.assertEquals(responseBody.contains(empName),true);
        Assert.assertEquals(responseBody.contains(empSalary),true);
        Assert.assertEquals(responseBody.contains(empAge),true);
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
        logger.info("************Finishing CReate Employee *********");
    }

}
