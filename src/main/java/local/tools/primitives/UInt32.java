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
 * Type represents 32 bits (4 bytes) unsigned integer type
 * Alias: UInt
 * Size: 32 bits (4 bytes)
 * Range: 0 to 4,294,967,295
 */
public final class UInt32 extends Number {

    public static final long MIN_VALUE = 0;
    public static final long MAX_VALUE = 4294967295L;

    private final long value;

    public UInt32(long value) throws IllegalArgumentException {
        if (!withinRange(value))
            throw new IllegalArgumentException(String.format("Value '%d' is out of 4-Byte Unsigned Integer range.", value));
        this.value = value;
    }

    public UInt32(int a, int b, int c, int d) {
        this((byte) a, (byte) b, (byte) c, (byte) d);
    }

    public UInt32(byte a, byte b, byte c, byte d) {
        this.value = Integer.toUnsignedLong(Int32.packBytes(a, b, c, d));
    }

    public UInt32(byte[] data) {
        this(data[0], data[1], data[2], data[3]);
    }

    public static long trimRange(long number) {
        return number & 0xffffffffL;
    }

    public static byte[] getBytes(long value, byte[] output) {
        output[0] = (byte) (value >>> 24);
        output[1] = (byte) (value >>> 16);
        output[2] = (byte) (value >>> 8);
        output[3] = (byte) (value);
        return output;
    }

    public byte[] getBytes() {
        return new byte[]{(byte) (value >>> 24), (byte) (value >>> 16), (byte) (value >>> 8), (byte) (value)};
    }

    @Override
    public int intValue() {
        return (int) value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (int) (this.value ^ (this.value >>> 32));
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
        final UInt32 other = (UInt32) obj;
        if (this.value != other.value) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    private static boolean withinRange(long value) {
        return MIN_VALUE <= value && value <= MAX_VALUE;
    }
}
