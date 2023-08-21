/**
 * MIT License
 * <p>
 * Copyright (c) 2023 Alexander Perfilev
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package local.tools.bin;

import local.tools.primitives.*;

import java.io.IOException;
import java.io.InputStream;

public class BigEndianNumberReader implements NumberReader {

    private final InputStream source;

    public BigEndianNumberReader(InputStream source) {
        this.source = source;
    }

    //<editor-fold defaultstate="collapsed" desc="Basic Java Types">
    @Override
    public byte readByte() throws IOException {
        return (byte) source.read();
    }

    @Override
    public short readShort() throws IOException {
        int a = source.read();
        int b = source.read();
        return new Int16(a, b).shortValue();
    }

    @Override
    public int readInt() throws IOException {
        int a = source.read();
        int b = source.read();
        int c = source.read();
        int d = source.read();
        return new Int32(a, b, c, d).intValue();
    }

    @Override
    public long readLong() throws IOException {
        int a = source.read();
        int b = source.read();
        int c = source.read();
        int d = source.read();
        int e = source.read();
        int f = source.read();
        int g = source.read();
        int h = source.read();
        return new Int64(a, b, c, d, e, f, g, h).longValue();
    }

    @Override
    public float readFloat() throws IOException {
        int a = source.read();
        int b = source.read();
        int c = source.read();
        int d = source.read();
        return new Float32(a, b, c, d).floatValue();
    }

    @Override
    public double readDouble() throws IOException {
        int a = source.read();
        int b = source.read();
        int c = source.read();
        int d = source.read();
        int e = source.read();
        int f = source.read();
        int g = source.read();
        int h = source.read();
        return new Float64(a, b, c, d, e, f, g, h).floatValue();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Universal Primitives">
    @Override
    public Int8 readInt8() throws IOException {
        int a = source.read();
        return new Int8(a);
    }

    @Override
    public Int16 readInt16() throws IOException {
        int a = source.read();
        int b = source.read();
        return new Int16(a, b);
    }

    @Override
    public Int32 readInt32() throws IOException {
        int a = source.read();
        int b = source.read();
        int c = source.read();
        int d = source.read();
        return new Int32(a, b, c, d);
    }

    @Override
    public Int64 readInt64() throws IOException {
        int a = source.read();
        int b = source.read();
        int c = source.read();
        int d = source.read();
        int e = source.read();
        int f = source.read();
        int g = source.read();
        int h = source.read();
        return new Int64(a, b, c, d, e, f, g, h);
    }

    @Override
    public Float32 readFloat32() throws IOException {
        int a = source.read();
        int b = source.read();
        int c = source.read();
        int d = source.read();
        return new Float32(a, b, c, d);
    }

    @Override
    public Float64 readFloat64() throws IOException {
        int a = source.read();
        int b = source.read();
        int c = source.read();
        int d = source.read();
        int e = source.read();
        int f = source.read();
        int g = source.read();
        int h = source.read();
        return new Float64(a, b, c, d, e, f, g, h);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Unsigned Universal Primitives">
    @Override
    public UInt8 readUInt8() throws IOException {
        return new UInt8((byte) source.read());
    }

    @Override
    public UInt16 readUInt16() throws IOException {
        int a = source.read();
        int b = source.read();
        return new UInt16(a, b);
    }

    @Override
    public UInt32 readUInt32() throws IOException {
        int a = source.read();
        int b = source.read();
        int c = source.read();
        int d = source.read();
        return new UInt32(a, b, c, d);
    }

    @Override
    public UInt64 readUInt64() throws IOException {
        int a = source.read();
        int b = source.read();
        int c = source.read();
        int d = source.read();
        int e = source.read();
        int f = source.read();
        int g = source.read();
        int h = source.read();
        return new UInt64(a, b, c, d, e, f, g, h);
    }
    //</editor-fold>
}
