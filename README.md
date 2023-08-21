# BinaryTools Java Library

BinaryTools is a Java library designed to simplify reading and writing binary data from various sources, offering support for both Little Endian and Big Endian formats. It provides two main components: `BinaryReader` and `BinaryWriter`, which enable users to seamlessly handle binary data in their applications.

## Features

- Read primitive types (e.g., integers, floating-point numbers) from binary sources.
- Read strings from binary sources, supporting various character encodings.
- Specify either Little Endian or Big Endian byte order for reading data.
- Write primitive types and strings to binary output streams.
- Flexible and easy-to-use API for interacting with binary data.

## Installation

You can include BinaryTools in your project using Maven or Gradle. Add the following dependency to your project configuration:

```xml
<dependency>
    <groupId>local.tools</groupId>
    <artifactId>binarytools</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

### BinaryReader

```java
import com.example.binarytools.BinaryReader;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryReaderExample {
    public static void main(String[] args) throws IOException {
        try (FileInputStream inputStream = new FileInputStream("data.bin")) {
            BinaryReader reader = new BinaryReader(inputStream, EndianType.LittleEndian);

            int intValue = reader.readInt();
            double doubleValue = reader.readDouble();
            String stringValue = reader.readString(10); // Read a string with maximum length 10

            System.out.println("Read values: " + intValue + ", " + doubleValue + ", " + stringValue);
        }
    }
}
```

### BinaryWriter

```java
import com.example.binarytools.BinaryWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryWriterExample {
    public static void main(String[] args) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream("output.bin")) {
            BinaryWriter writer = new BinaryWriter(outputStream, EndianType.LittleEndian);

            writer.writeInt(42);
            writer.writeDouble(3.14);
            writer.writeString("Hello, BinaryTools!");
        }
    }
}
```

## License

This library is released under the [MIT License](LICENSE).

## Contributions

Contributions are welcome! Feel free to submit issues and pull requests on the [GitHub repository](https://github.com/aperfilev/binarytools).

## Contact

For questions, suggestions, or feedback, you can reach us at alexperfilev@gmail.com
