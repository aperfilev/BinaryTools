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

public interface NumberWriter {

    public void writeByte(int v) throws IOException;

    public void writeShort(int v) throws IOException;

    public void writeInt(int v) throws IOException;

    public void writeLong(long v) throws IOException;

    public void writeFloat(float v) throws IOException;

    public void writeDouble(double v) throws IOException;

    public void writeInt8(Int8 v) throws IOException;

    public void writeInt16(Int16 v) throws IOException;

    public void writeInt32(Int32 v) throws IOException;

    public void writeInt64(Int64 v) throws IOException;

    public void writeUInt8(UInt8 v) throws IOException;

    public void writeUInt16(UInt16 v) throws IOException;

    public void writeUInt32(UInt32 v) throws IOException;

    public void writeUInt64(UInt64 v) throws IOException;

    public void writeFloat32(Float32 v) throws IOException;

    public void writeFloat64(Float64 v) throws IOException;
}
