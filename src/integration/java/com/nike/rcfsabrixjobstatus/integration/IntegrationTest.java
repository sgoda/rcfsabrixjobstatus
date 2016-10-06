package com.nike.rcfsabrixjobstatus.integration;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import org.junit.BeforeClass;

/**
 * Blueprint integration testing class that setups RestAssured.
 */
public class IntegrationTest {

    @BeforeClass
    public static void bootRestAssured() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://" + System.getProperty("integration.server"))
                .setPort(Integer.parseInt(System.getProperty("integration.port")))
                .build();

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
