package com.nike.rcfsabrixjobstatus.exception;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for ErrorCode
 */
public class ErrorCodeTest {

    @Test
    public void testInternalError() {
        assertEquals("99999", ErrorCode.INTERNAL_ERROR.getValue());
        assertEquals(ErrorCode.INTERNAL_ERROR, ErrorCode.get("99999"));
    }

}