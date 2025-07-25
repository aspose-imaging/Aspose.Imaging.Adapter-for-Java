/*
 * Copyright (c) 2001-2025 Aspose Pty Ltd. All Rights Reserved.
 */

package com.aspose.imaging.heic.adapter;

import com.aspose.imaging.*;
import com.aspose.imaging.system.io.Stream;
import openize.heic.decoder.HeicImageFrame;


/**
 * <p>
 * The HEIC image page
 * </p>
 *
 * @see com.aspose.imaging
 */
public class HEICImagePage extends RasterImage
{

    /**
     * <p>
     * The frame
     * </p>
     */
    private final HeicImageFrame frame;

    /**
     * <p>
     * Initializes a new instance of the {@link HEICImagePage} class.
     * </p>
     *
     * @param frame     The frame.
     * @param container The container.
     */
    public HEICImagePage(HeicImageFrame frame, Image container)
    {
        this.frame = frame;
        this.setDataLoader(new HEICDataLoader(frame));
        this.updateContainer(container);
    }

    /**
     * <p>
     * Gets a value indicating whether object's data is cached currently and no data reading is required.
     * </p>Value:
     * {@code true} if object's data is cached; otherwise, {@code false}.
     *
     * @return a value indicating whether object's data is cached currently and no data reading is required.
     */
    @Override
    public /*override*/ boolean isCached()
    {
        return false;
    }

    /**
     * <p>
     * Gets the image bits per pixel count.
     * </p>Value:
     * The image bits per pixel count.
     *
     * @return the image bits per pixel count.
     */
    @Override
    public /*override*/ int getBitsPerPixel()
    {
        return 32;
    }

    /**
     * <p>
     * Gets the image width.
     * </p>Value:
     * The image width.
     *
     * @return the image width.
     */
    @Override
    public /*override*/ int getWidth()
    {
        return (int) this.frame.getWidth();
    }

    /**
     * <p>
     * Gets the image height.
     * </p>Value:
     * The image height.
     *
     * @return the image height.
     */
    @Override
    public /*override*/ int getHeight()
    {
        return (int) this.frame.getHeight();
    }

    /**
     * <p>
     * Gets a value indicating whether this instance has alpha.
     * </p>Value:
     * {@code true} if this instance has alpha; otherwise, {@code false}.
     *
     * @return a value indicating whether this instance has alpha.
     */
    @Override
    public /*override*/ boolean hasAlpha()
    {
        return this.frame.hasAlpha();
    }

    /**
     * <p>
     * Updates the image dimensions.
     * </p>
     *
     * @param newWidth  The new image width.
     * @param newHeight The new image height.
     * @throws UnsupportedOperationException The resizing is unsupported feature.
     */
    @Override
    protected void updateDimensions(int newWidth, int newHeight)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Caches the data and ensures no additional data loading will be performed from the underlying
     * {@link DataStreamSupporter#getDataStreamContainer()}.
     * </p>
     */
    @Override
    public /*override*/ void cacheData()
    {
        // Do nothing (Unsupported)
    }

    /**
     * <p>
     * Rotates, flips, or rotates and flips the image.
     * </p>
     *
     * @param rotateFlipType Type of the rotate flip.
     * @see com.aspose.imaging.RotateFlipType
     */
    @Override
    public /*override*/ void rotateFlip(int rotateFlipType)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Performs dithering on the current image.
     * </p>
     *
     * @param ditheringMethod The dithering method.
     * @param bitsCount       The final bits count for dithering.
     * @param customPalette   The custom palette for dithering.
     * @throws UnsupportedOperationException Not supported!
     * @see com.aspose.imaging.DitheringMethod
     */
    @Override
    public /*override*/ void dither(int ditheringMethod, int bitsCount, IColorPalette customPalette)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Saves the data.
     * </p>
     *
     * @param stream The stream to save data to.
     * @throws UnsupportedOperationException Not supported!
     */
    @Override
    protected /*override*/ void saveData(Stream stream)
    {
        throw new UnsupportedOperationException();
    }
}
