package com.nike.rcfsabrixjobstatus.exception;

import com.nike.blueprint.rest.exception.BaseErrorCode;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Application Error Codes
 * <p>
 * Add your application specific error codes to this enumeration.
 * </p>
 */
public enum ErrorCode implements BaseErrorCode {

    /** Error code representing a non-specific internal server error. */
    INTERNAL_ERROR("99999");

    // Add your service specific error codes here!

    private static final Map<String, ErrorCode> LOOKUP = new HashMap<>();

    static {
        for (ErrorCode errorCode : EnumSet.allOf(ErrorCode.class)) {
            LOOKUP.put(errorCode.getValue(), errorCode);
        }
    }

    private final String value;

    /**
     * Implicitly private enum constructor.
     *
     * @param value a error code that is unique to this enum value.
     */
    ErrorCode(String value) {
        this.value = value;
    }

    /**
     * The error code for this {@link ErrorCode}.
     *
     * @return The error code for this {@link ErrorCode}.
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * Acquire the {@link ErrorCode} for a particular {@link ErrorCode#getValue value}.
     *
     * @param value the {@link ErrorCode#getValue value} for which you want an {@link ErrorCode}.
     * @return the {@link ErrorCode} for the given value, or null if there is no such {@link ErrorCode}.
     */
    public static ErrorCode get(String value) {
        return LOOKUP.get(value);
    }
}
