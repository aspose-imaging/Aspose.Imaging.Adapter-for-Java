/*
 * Copyright (c) 2001-2025 Aspose Pty Ltd. All Rights Reserved.
 */

package com.aspose.imaging.heic.io;

import com.aspose.imaging.system.IDisposable;
import com.aspose.imaging.system.io.Stream;
import openize.io.IOSeekMode;
import openize.io.IOStream;

/**
 * <p>
 *     The adaptor over the Aspose.Imaging Stream class
 * </p>
 * @author Evgeniy Sidenko
 * @version 1.0
 */
public class ImageStream implements IOStream, IDisposable
{
    /**
     * <p>
     *     Aspose.Imaging Stream class
     * </p>
     */
    private final Stream stream;

    private long streamLength;

    /**
     * <p>
     *     Creates an instance.
     * </p>
     * @param stream The underlying file/memory data stream
     */
    public ImageStream(Stream stream)
    {
        this.stream = stream;
        this.streamLength = stream.getLength();
    }

    /**
     * <p>
     *     Reads bytes into the array {@code bytes}.
     * </p>
     * @param bytes The output array.
     * @return The read byte count.
     */
    @Override
    public int read(byte[] bytes)
    {
        return stream.read(bytes, 0, bytes.length);
    }

    /**
     * <p>
     *     Reads bytes into the array {@code bytes}.
     * </p>
     * @param bytes The output array.
     * @param offset The offset in the output array.
     * @param length The count of bytes to read.
     * @return The read byte count.
     */
    @Override
    public int read(byte[] bytes, int offset, int length)
    {
        return stream.read(bytes, offset, length);
    }

    /**
     * <p>
     *     Writes bytes into the file/memory data stream.
     * </p>
     * @param bytes The array to be written.
     */
    @Override
    public void write(byte[] bytes)
    {
        stream.write(bytes, 0, bytes.length);
        this.streamLength = stream.getLength();
    }

    /**
     * <p>
     *     Writes bytes into the file/memory data stream.
     * </p>
     * @param bytes The array to be written.
     * @param offset The offset in the input array.
     * @param length The count of bytes to write.
     */
    @Override
    public void write(byte[] bytes, int offset, int length)
    {
        stream.write(bytes, offset, length);
        this.streamLength = stream.getLength();
    }

    /**
     * <p>
     *     Moves the active data stream position to a {@code position}.
     * </p>
     * @param position The new position.
     * @return The new position.
     */
    @Override
    public long setPosition(long position)
    {
        stream.setPosition(position);
        return stream.getPosition();
    }

    /**
     * <p>
     *     Returns the current position in the data stream.
     * </p>
     * @return The current position.
     */
    @Override
    public long getPosition()
    {
        return stream.getPosition();
    }

    /**
     * <p>
     *     Moves the active data stream position to a {@code newPosition} according the {@code mode}.
     * </p>
     * @param newPosition The new position.
     * @param mode The seeking mode.
     * @see IOSeekMode
     */
    @Override
    public void seek(long newPosition, IOSeekMode mode)
    {
        stream.seek(newPosition, mode.ordinal());
    }

    /**
     * <p>
     *     Returns the stream length.
     * </p>
     * @return The stream length.
     */
    @Override
    public long getLength()
    {
        return this.streamLength;
    }

    /**
     * <p>
     *     Sets the stream length to {@code newLength}.
     * </p>
     * @param newLength The new length.
     */
    @Override
    public void setLength(long newLength)
    {
        stream.setLength(newLength);
        this.streamLength = stream.getLength();
    }

    /**
     * <p>
     *     Closes the stream.
     * </p>
     */
    @Override
    public void close()
    {
        stream.close();
    }

    /**
     * <p>
     *     Closes the stream.
     * </p>
     */
    @Override
    public void dispose()
    {
        close();
    }
}
