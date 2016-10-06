package com.nike.rcfsabrixjobstatus.server;

import com.nike.blueprint.rest.server.RestBootstrap;

/**
 * Configures the Jersey container that hosts this micro service.
 */
public class Bootstrap extends RestBootstrap {

    @Override
    public String getContextPath() {
        return "/*";
    }

    @Override
    public String[] getPackagesToScan() {
        return new String[] {
          "com.nike.rcfsabrixjobstatus"
        };
    }
}
