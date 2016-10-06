package com.nike.rcfsabrixjobstatus.resource;
import com.nike.blueprint.rest.ApplicationInfo;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for example endpoint.
 */
public class ExampleResourceTest {

    @Test
    public void testAbout() {

        ExampleResource resource = new ExampleResource();

        Response response = resource.about();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        Object entity = response.getEntity();
        assertTrue(entity instanceof LinkedHashMap);

        @SuppressWarnings("unchecked")
        LinkedHashMap<String, String> map = (LinkedHashMap<String, String>) entity;
        assertEquals(ApplicationInfo.getApplicationId(), map.get("name"));
        assertEquals(ApplicationInfo.getApplicationVersion(), map.get("version"));
        assertEquals(ApplicationInfo.getEnvironment(), map.get("environment"));

    }

}