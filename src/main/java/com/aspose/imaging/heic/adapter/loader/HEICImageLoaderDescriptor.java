/*
 * Copyright (c) 2001-2025 Aspose Pty Ltd. All Rights Reserved.
 */

package com.aspose.imaging.heic.adapter.loader;


import com.aspose.imaging.*;
import com.aspose.imaging.heic.io.ImageStream;
import openize.heic.decoder.HeicImage;

/**
 * <p>
 * The HEIC Image Loader descriptor of {@code IImageLoaderDescriptor}
 * </p>
 *
 * @see com.aspose.imaging
 */
public class HEICImageLoaderDescriptor implements IImageLoaderDescriptor
{
    /**
     * <p>
     * Gets the supported format.
     * </p>
     *
     * @return The supported format.
     */
    @Override
    public final long getSupportedFormat()
    {
        return FileFormat.Custom;
    }

    /**
     * <p>
     * Determines whether image loader can read a new image from the specified stream and optionally using the {@code loadOptions}.
     * </p>
     *
     * @param streamContainer {@code The stream container.}
     * @param loadOptions     {@code The load options.}
     */
    @Override
    public final boolean canLoad(StreamContainer streamContainer, LoadOptions loadOptions)
    {
        return HeicImage.canLoad(new ImageStream(StreamContainer.to_Stream(streamContainer)));
    }

    /**
     * <p>
     * Creates a new loader instance.
     * </p>
     *
     * @return {@code Aspose.Imaging.IImageLoader}
     */
    @Override
    public final IImageLoader createInstance()
    {
        return new HEICImageLoader();
    }
}
