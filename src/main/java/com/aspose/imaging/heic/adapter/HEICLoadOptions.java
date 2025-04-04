/*
 * Copyright (c) 2001-2025 Aspose Pty Ltd. All Rights Reserved.
 */

package com.aspose.imaging.heic.adapter;


import com.aspose.imaging.LoadOptions;

/**
 * <p>
 * The Heic load options of {@code LoadOptions}
 * </p>
 *
 * @see com.aspose.imaging
 */
public class HEICLoadOptions extends LoadOptions
{
    /**
     * <p>
     * Prevents a default instance of the {@link HEICLoadOptions} class from being created.
     * </p>
     */
    private HEICLoadOptions()
    {
        HEICImage.register();
    }

    /**
     * <p>
     * Creates this instance.
     * </p>
     * @return A new instance.
     */
    public static HEICLoadOptions create()
    {
        return new HEICLoadOptions();
    }
}
