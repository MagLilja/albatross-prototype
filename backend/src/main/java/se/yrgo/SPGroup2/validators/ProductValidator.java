package se.yrgo.SPGroup2.validators;

import org.springframework.web.util.HtmlUtils;

public class ProductValidator {

    public static String validateStringInput(String strongToValidate) {
        String escape = HtmlUtils.htmlEscape(strongToValidate);
        return escape;
//        if (escape.equals(strongToValidate)) {
//            return escape;
//        } else {
//            throw new IllegalArgumentException("Input contains illegal characters");
//        }
    }
}
