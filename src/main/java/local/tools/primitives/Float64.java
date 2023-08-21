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
package local.tools.primitives;

/**
 * Type represents 64 bits (8 bytes) float type
 * Alias: Float, float64
 * Size: 64 bits (8 bytes)
 */
public class Float64 extends Number {

    private final double value;

    public Float64(double value) {
        this.value = value;
    }

    public Float64(int a, int b, int c, int d, int e, int f, int g, int h) {
        this((byte) a, (byte) b, (byte) c, (byte) d, (byte) e, (byte) f, (byte) g, (byte) h);
    }

    public Float64(byte a, byte b, byte c, byte d, byte e, byte f, byte g, byte h) {
        long joinedBytes = Int64.packBytes(a, b, c, d, e, f, g, h);
        value = Double.longBitsToDouble(joinedBytes);
    }

    public Float64(byte[] data) {
        this(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
    }

    public static double packBytes(int a, int b, int c, int d, int e, int f, int g, int h) {
        return packBytes((byte) a, (byte) b, (byte) c, (byte) d, (byte) e, (byte) f, (byte) g, (byte) h);
    }

    public static double packBytes(byte a, byte b, byte c, byte d, byte e, byte f, byte g, byte h) {
        long joinedBytes = Int64.packBytes(a, b, c, d, e, f, g, h);
        return Double.longBitsToDouble(joinedBytes);
    }

    public static byte[] getBytes(double value, byte[] output) {
        long v = Double.doubleToRawLongBits(value);
        output[0] = (byte) (v >>> 56);
        output[1] = (byte) (v >>> 48);
        output[2] = (byte) (v >>> 40);
        output[3] = (byte) (v >>> 32);
        output[4] = (byte) (v >>> 24);
        output[5] = (byte) (v >>> 16);
        output[6] = (byte) (v >>> 8);
        output[7] = (byte) (v);
        return output;
    }

    public byte[] getBytes(byte[] output) {
        long v = Double.doubleToRawLongBits(this.value);
        output[0] = (byte) (v >>> 56);
        output[1] = (byte) (v >>> 48);
        output[2] = (byte) (v >>> 40);
        output[3] = (byte) (v >>> 32);
        output[4] = (byte) (v >>> 24);
        output[5] = (byte) (v >>> 16);
        output[6] = (byte) (v >>> 8);
        output[7] = (byte) (v);
        return output;
    }

    public byte[] getBytes() {
        return getBytes(new byte[8]);
    }

    @Override
    public int intValue() {
        return (int) value;
    }

    @Override
    public long longValue() {
        return (long) value;
    }

    @Override
    public float floatValue() {
        return (float) value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.value) ^ (Double.doubleToLongBits(this.value) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Float64 other = (Float64) obj;
        if (Double.doubleToLongBits(this.value) != Double.doubleToLongBits(other.value)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
