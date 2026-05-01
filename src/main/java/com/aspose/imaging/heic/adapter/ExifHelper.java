/*
 * Copyright (c) 2001-2026 Aspose Pty Ltd.
 * All Rights Reserved.
 * Author : Stanislav Popov
 * Date: 06.10.2025 11:55
 */

package com.aspose.imaging.heic.adapter;

import com.drew.lang.Rational;
import openize.heic.decoder.ExifData;
import openize.heic.decoder.ExifDirectoryType;


final class ExifHelper
{
    public static final int DefaultResolution = 96;

    /**
     * <p>
     * Gets the resolution.
     * </p>
     *
     * @param exif The exif.
     * @param tag  The tag.
     * @return The resolution.
     */
    public static double getRationalValue(ExifData exif, int tag)
    {
        if (exif == null)
        {
            return DefaultResolution;
        }

        Object exifRawData = exif.getExifRawData(ExifDirectoryType.ExifIfd0Directory, tag);
        Rational value = exifRawData instanceof Rational ? ((Rational) exifRawData) : null;
        if (value == null || value.getDenominator() == 0)
        {
            return DefaultResolution;
        }

        return value.getNumerator() * 1.00d / value.getDenominator();
    }
}
