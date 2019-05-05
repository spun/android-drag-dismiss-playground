package com.spundev.elasticdragdismissframelayout.util;

import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;

/**
 * Utility methods for working with colors.
 */
public class ColorUtils {

    /**
     * Set the alpha component of {@code color} to be {@code alpha}.
     */
    public static @CheckResult
    @ColorInt
    int modifyAlpha(@ColorInt int color, @IntRange(from = 0, to = 255) int alpha) {
        return (color & 0x00ffffff) | (alpha << 24);
    }
}