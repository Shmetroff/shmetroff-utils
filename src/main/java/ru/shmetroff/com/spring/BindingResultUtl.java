package ru.shmetroff.com.spring;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * Helper class for work with BindingResult
 *
 * @author Alex Alejandro Shmetroff
 * @date 30.07.2026
 */
public class BindingResultUtl {
    /**
     * Returns concatenated string with all errors dilimited by semicolon from bindingResult
     *
     * @param bindingResult target object
     * @return concatenated string with all errors dilimited by semicolon
     */
    public static String errors(BindingResult bindingResult) {
        StringBuilder errorMsg = new StringBuilder();
        for (FieldError error : bindingResult.getFieldErrors())
            errorMsg.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("; ");
        errorMsg.deleteCharAt(errorMsg.length() - 1);
        return errorMsg.toString();
    }
}
