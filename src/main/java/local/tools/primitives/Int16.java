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
 * Type represents 16 bits integer type
 * Alias: Short
 * Size: 16 bits (2 byte)
 * Range: -32,768 to 32,767
 */
public class Int16 extends Number {

    public static final short MIN_VALUE = Short.MIN_VALUE;
    public static final short MAX_VALUE = Short.MAX_VALUE;

    private final short value;

    public Int16(int value) {
        this.value = (short) value;
    }

    public Int16(short value) {
        this.value = value;
    }

    public Int16(int a, int b) {
        this((byte) a, (byte) b);
    }

    public Int16(byte a, byte b) {
        this.value = packBytes(a, b);
    }

    public Int16(byte[] bytes) {
        this(bytes[0], bytes[1]);
    }

    public static short packBytes(int a, int b) {
        return packBytes((byte) a, (byte) b);
    }

    public static short packBytes(byte a, byte b) {
        return (short) (((a & 0xff) << 8) | (b & 0xff));
    }

    public static byte[] getBytes(short value, byte[] output) {
        output[0] = (byte) (value >>> 8);
        output[1] = (byte) (value);
        return output;
    }

    public byte[] getBytes() {
        return new byte[]{(byte) (value >>> 8), (byte) (value)};
    }

    @Override
    public int intValue() {
        return value;
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
        int hash = 3;
        hash = 59 * hash + this.value;
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
        final Int16 other = (Int16) obj;
        if (this.value != other.value) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
