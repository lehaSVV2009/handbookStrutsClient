package com.kadet.handbook.client.util;

/**
 * Date: 10.12.13
 * Time: 3:45
 *
 * @author Кадет
 */
public final class TextValidator {

    public static final boolean badText (String text) {
        return text == null
                || "".equals(text.trim());
    }

}
