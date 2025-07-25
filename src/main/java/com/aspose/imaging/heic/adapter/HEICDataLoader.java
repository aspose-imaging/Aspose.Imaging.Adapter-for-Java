/*
 * Copyright (c) 2001-2025 Aspose Pty Ltd. All Rights Reserved.
 */

package com.aspose.imaging.heic.adapter;

import com.aspose.imaging.*;
import openize.heic.decoder.HeicImageFrame;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * The Heic data loader of {@code IRasterImageArgb32PixelLoader}
 * </p>
 *
 * @see com.aspose.imaging
 */
public class HEICDataLoader implements IRasterImageArgb32PixelLoader
{
    /**
     * <p>
     * The image
     * </p>
     */
    private final HeicImageFrame image;

    /**
     * <p>
     * Initializes a new instance of the {@link HEICDataLoader} class.
     * </p>
     *
     * @param image The image.
     */
    public HEICDataLoader(HeicImageFrame image)
    {
        this.image = image;
    }

    /**
     * <p>
     * Loads raw data.
     * </p>
     *
     * @param rectangle       The rectangle to load raw data from.
     * @param rawDataSettings The raw data settings to use for loaded data. Note if data is not in the format specified then data conversion will be performed.
     * @param rawDataLoader   The raw data loader.
     * @throws UnsupportedOperationException It does not support.
     */
    @Override
    public final void loadRawData(Rectangle rectangle, RawDataSettings rawDataSettings, IPartialRawDataLoader rawDataLoader)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Gets a value indicating whether raw data loading is supported.
     * </p>Value:
     * {@code true} if raw data loading is supported; otherwise, {@code false}.
     *
     * @return a value indicating whether raw data loading is supported.
     */
    @Override
    public final boolean isRawDataAvailable()
    {
        return false;
    }

    /**
     * <p>
     * Gets the current raw data settings. Note when using these settings the data loads without conversion.
     * </p>Value:
     * The current raw data settings.
     *
     * @return the current raw data settings.
     */
    @Override
    public final RawDataSettings getRawDataSettings()
    {
        return null;
    }

    /**
     * <p>
     * Loads 32-bit ARGB pixels partially (by blocks).
     * </p>
     *
     * @param rectangle          The rectangle to load pixels from.
     * @param partialPixelLoader The partial pixel loader.
     */
    @Override
    public final void loadPartialArgb32Pixels(Rectangle rectangle, IPartialArgb32PixelLoader partialPixelLoader)
    {
        final long threadID = Thread.currentThread().getId();
        Rectangle rec = maps.get(threadID);
        if (rec != null && (rectangle.getWidth() != image.getWidth() || rectangle.getHeight() != image.getHeight()))
        {
            maps.remove(threadID);
            throw new UnsupportedOperationException("OutOfMemory: HEIC Adapter does not support the partial processing.");
        }
        maps.put(threadID, rectangle);

        int[] argbPixels = this.image.getInt32Array(openize.heic.decoder.PixelFormat.Argb32,
                new openize.heic.decoder.Rectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight()), null);
        partialPixelLoader.process(rectangle, argbPixels,
                rectangle.getLocation(), new Point(rectangle.getRight(), rectangle.getBottom()));
        maps.remove(threadID);
    }

    private final Map<Long, Rectangle> maps = Collections.synchronizedMap(new HashMap<>());
}
