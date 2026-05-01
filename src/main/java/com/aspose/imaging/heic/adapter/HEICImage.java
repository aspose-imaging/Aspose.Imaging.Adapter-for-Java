/*
 * Copyright (c) 2001-2026 Aspose Pty Ltd.
 * All Rights Reserved.
 */

package com.aspose.imaging.heic.adapter;

import com.aspose.imaging.*;
import com.aspose.imaging.heic.adapter.loader.HEICImageLoaderDescriptor;
import com.aspose.imaging.heic.io.ImageStream;
import com.aspose.imaging.system.io.Stream;
import openize.heic.decoder.HeicImage;
import openize.heic.decoder.HeicImageFrame;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * <p>
 * The heic Image of {@code RasterCachedMultipageImage}
 * </p>
 *
 * @see com.aspose.imaging
 */
public final class HEICImage extends RasterCachedMultipageImage
{

    /**
     * <p>
     * The registered
     * </p>
     */
    private static boolean registered;
    /**
     * <p>
     * The image
     * </p>
     */
    private final HeicImage image;

    /**
     * <p>
     * The pages
     * </p>
     */
    private final HEICImagePage[] pages;

    /**
     * <p>
     * The x resolution
     * </p>
     */
    private final double xResolution;

    /**
     * <p>
     * The y resolution
     * </p>
     */
    private final double yResolution;

    /**
     * <p>
     * Initializes a new instance of the {@link HEICImage} class.
     * </p>
     *
     * @param stream The stream.
     */
    public HEICImage(Stream stream)
    {
        this.image = HeicImage.load(new ImageStream(stream));
        this.xResolution = ExifHelper.getRationalValue(this.image.getExif(), 282);
        this.yResolution = ExifHelper.getRationalValue(this.image.getExif(), 283);
        List<Map.Entry<Long, HeicImageFrame>> frames =
                image.getFrames()
                    .entrySet()
                    .stream()
                    .filter(f -> f.getValue().isImage())
                    .collect(Collectors.toList());

        this.pages = new HEICImagePage[frames.size()];
        final HeicImageFrame defaultFrame = this.image.getDefaultFrame();
        this.setDataLoader(new HEICDataLoader(defaultFrame));
        int i = 1;
        this.pages[0] = new HEICImagePage(defaultFrame, this);
        if (frames.size() > 1)
        {
            for (Map.Entry<Long, HeicImageFrame> frame : frames)
            {
                if (frame.getValue() == defaultFrame)
                {
                    continue;
                }

                this.pages[i] = new HEICImagePage(frame.getValue(), this);
                i++;
            }
        }
    }

    /**
     * <p>
     * Register HEIC Adapter
     * </p>
     */
    public static void register()
    {
        if (registered)
        {
            return;
        }

        ImageLoadersRegistry.registerLoader(new HEICImageLoaderDescriptor());
        registered = true;
    }

    /**
     * <p>
     * Gets a value indicating whether image data is cached currently.
     * </p>Value:
     * {@code true} if image data is cached; otherwise, {@code false}.
     *
     * @return a value indicating whether image data is cached currently.
     */
    @Override
    public /*override*/ boolean isCached()
    {
        return false;
    }

    /**
     * <p>
     * Gets the page count.
     * </p>Value:
     * The page count.
     *
     * @return the page count.
     */
    @Override
    public /*override*/ int getPageCount()
    {
        return this.pages.length;
    }

    /**
     * <p>
     * Gets the pages, where pages are an array of {@code Image}.
     * </p>Value:
     * The pages.
     *
     * @return the pages, where pages are an array of {@code Image}.
     */
    @Override
    public /*override*/ Image[] getPages()
    {
        return this.pages;
    }

    /**
     * <p>
     * Gets a value indicating whether image has transparent color.
     * </p>
     *
     * @return a value indicating whether image has transparent color.
     */
    @Override
    public /*override*/ boolean hasTransparentColor()
    {
        return false;
    }

    /**
     * <p>
     * Gets the {@code color} of the background.
     * </p>Value:
     * The color of the background.
     *
     * @return the {@code color} of the background.
     */
    @Override
    public /*override*/ Color getBackgroundColor()
    {
        return Color.getTransparent();
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
        return (int) this.image.getDefaultFrame().getWidth();
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
        return (int) this.image.getDefaultFrame().getHeight();
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
        return this.image.getDefaultFrame().hasAlpha();
    }

    /**
     * <p>
     * Gets the vertical resolution.
     * </p>Value:
     * The vertical resolution.
     * @return the vertical resolution.
     */
    @Override
    public /*override*/ double getVerticalResolution() { return this.yResolution; }

    /**
     * <p>
     * Gets the horizontal resolution.
     * </p>Value:
     * The horizontal resolution.
     * @return the horizontal resolution.
     */
    @Override
    public /*override*/ double getHorizontalResolution() { return this.xResolution; }

    /**
     * <p>
     * Gets the exif data.
     * </p>Value:
     * The exif data.
     * @return the exif data.
     */
    @Override
    public com.aspose.imaging.exif.ExifData getExifData()
    {
        if (this.pages[0] != null)
        {
            return this.pages[0].getExifData();
        }

        return null;
    }

    /**
     * <p>
     * Caches the data private.
     * </p>
     */
    @Override
    public /*override*/ void cacheData()
    {
        // Do nothing (Unsupported)
    }

    /**
     * <p>
     * Saves the data.
     * </p>
     *
     * @param stream The stream to save data to.
     * @throws UnsupportedOperationException Not supported.
     */
    @Override
    protected /*override*/ void saveData(Stream stream)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Updates the image dimensions.
     * </p>
     *
     * @param newWidth  The new image width.
     * @param newHeight The new image height.
     * @throws UnsupportedOperationException Not supported.
     */
    @Override
    protected /*override*/ void updateDimensions(int newWidth, int newHeight)
    {
        throw new UnsupportedOperationException();
    }
}
