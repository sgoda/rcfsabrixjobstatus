package com.nike.rcfsabrixjobstatus.resource;

import com.nike.blueprint.rest.ApplicationInfo;
import com.nike.blueprint.rest.resource.Resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Example endpoint that returns version information about the application.
 */
@Path("example")
public class ExampleResource extends Resource {

    private static final int MAX_CACHE_AGE_IN_SECONDS = 3600;

    /**
     * Provides a map with information about the application's name, version, and environment drawn from Archaius
     * deployment properties.
     *
     * @return response with JSON body containing application name, version and environment.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response about() {
        Map<String, Object> entity = new LinkedHashMap<>();
        entity.put("name", ApplicationInfo.getApplicationId());
        entity.put("version", ApplicationInfo.getApplicationVersion());
        entity.put("environment", ApplicationInfo.getEnvironment());

        CacheControl cacheControl = new CacheControl();
        cacheControl.setMaxAge(MAX_CACHE_AGE_IN_SECONDS);

        return Response.ok(entity)
                .cacheControl(cacheControl)
                .build();
    }
}
