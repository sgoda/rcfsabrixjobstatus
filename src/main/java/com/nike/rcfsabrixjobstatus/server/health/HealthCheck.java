package com.nike.rcfsabrixjobstatus.server.health;

import com.netflix.karyon.server.eureka.HealthCheckInvocationStrategy;
import com.netflix.karyon.spi.HealthCheckHandler;
import org.apache.http.HttpStatus;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeoutException;

/**
 * Monitors the health of the service and returns an appropriate HTTP status code based upon the health.
 * <p>
 * The health check is done in a separate thread on a scheduled basis to prevent frequent calls to the health check
 * endpoint from affecting the overall performance of the service.
 * </p>
 */
public class HealthCheck implements HealthCheckHandler, HealthCheckInvocationStrategy {
    private static final long INITIAL_DELAY_IN_MS = 0L;
    private static final long PERIOD_IN_MS = 10000L;

    private volatile int status = HttpStatus.SC_SERVICE_UNAVAILABLE;

    /** Default constructor, invoked by framework. */
    public HealthCheck() {
        Timer timer = new Timer("HealthCheckTaskTimer", true);
        timer.schedule(new HealthCheckTask(), INITIAL_DELAY_IN_MS, PERIOD_IN_MS);
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public int invokeCheck() throws TimeoutException {
        return getStatus();
    }

    @Override
    public HealthCheckHandler getHandler() {
        return this;
    }

    /**
     * Task that determines the health of the service.
     */
    private class HealthCheckTask extends TimerTask {

        @Override
        public void run() {
            // Put your logic to determine the health of your service here!
            status = HttpStatus.SC_OK;
        }
    }
}
