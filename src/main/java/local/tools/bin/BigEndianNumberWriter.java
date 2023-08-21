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
import java.io.OutputStream;

/**
 * @author dell
 */
public class BigEndianNumberWriter implements NumberWriter {

    private final OutputStream target;

    public BigEndianNumberWriter(OutputStream target) {
        this.target = target;
    }

    //<editor-fold defaultstate="collapsed" desc="Basic Java Types">
    @Override
    public void writeByte(int v) throws IOException {
        writeInt8(new Int8(v));
    }

    @Override
    public void writeShort(int v) throws IOException {
        writeInt16(new Int16(v));
    }

    @Override
    public void writeInt(int v) throws IOException {
        writeInt32(new Int32(v));
    }

    @Override
    public void writeLong(long v) throws IOException {
        writeInt64(new Int64(v));
    }

    @Override
    public void writeFloat(float v) throws IOException {
        byte[] data = new Float32(v).getBytes();
        target.write(data);
    }

    @Override
    public void writeDouble(double v) throws IOException {
        byte[] data = new Float64(v).getBytes();
        target.write(data);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Universal Primitives">
    @Override
    public void writeInt8(Int8 v) throws IOException {
        target.write(v.getBytes());
    }

    @Override
    public void writeInt16(Int16 v) throws IOException {
        target.write(v.getBytes());
    }

    @Override
    public void writeInt32(Int32 v) throws IOException {
        target.write(v.getBytes());
    }

    @Override
    public void writeInt64(Int64 v) throws IOException {
        target.write(v.getBytes());
    }

    @Override
    public void writeFloat32(Float32 v) throws IOException {
        byte[] data = v.getBytes();
        target.write(data);
    }

    @Override
    public void writeFloat64(Float64 v) throws IOException {
        byte[] data = v.getBytes();
        target.write(data);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Unsigned Universal Primitives">
    @Override
    public void writeUInt8(UInt8 v) throws IOException {
        target.write(v.getBytes());
    }

    @Override
    public void writeUInt16(UInt16 v) throws IOException {
        target.write(v.getBytes());
    }

    @Override
    public void writeUInt32(UInt32 v) throws IOException {
        target.write(v.getBytes());
    }

    @Override
    public void writeUInt64(UInt64 v) throws IOException {
        target.write(v.getBytes());
    }
    //</editor-fold>
}
