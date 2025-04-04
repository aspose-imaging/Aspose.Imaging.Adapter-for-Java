/*
 * Copyright (c) 2001-2025 Aspose Pty Ltd. All Rights Reserved.
 */

package com.aspose.imaging.heic.adapter.loader;

import com.aspose.imaging.IImageLoader;
import com.aspose.imaging.Image;
import com.aspose.imaging.LoadOptions;
import com.aspose.imaging.StreamContainer;
import com.aspose.imaging.heic.adapter.HEICImage;


/**
 * <p>
 * The HEIC image loader of {@code IImageLoader}
 * </p>
 *
 * @see com.aspose.imaging
 */
public class HEICImageLoader implements IImageLoader
{
    /**
     * <p>
     * Loads the image from the specified stream container.
     * </p>
     *
     * @param streamContainer {@code The stream container.}
     * @param loadOptions     {@code The load options.}
     * @return {@code Aspose.Imaging.Image}
     */
    @Override
    public final Image load(StreamContainer streamContainer, LoadOptions loadOptions)
    {
        return new HEICImage(StreamContainer.to_Stream(streamContainer));
    }
}
