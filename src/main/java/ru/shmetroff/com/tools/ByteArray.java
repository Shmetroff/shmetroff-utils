package ru.shmetroff.com.tools;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Helper class for print array of bytes like hex editor
 * @author Alex Alejandro Shmetroff
 * @date 15.05.2026
 */
public class ByteArray {
    /**
     * Only for test
     */
    public static void main(String[] args) {
        // Get the default Charset object
        Charset defaultCharset = Charset.defaultCharset();
        System.out.println("Default Charset: " + defaultCharset.name());

        // You can also get it via a system property (though Charset.defaultCharset() is preferred)
//        String fileEncodingProperty = Charset.defaultCharset().displayName();
        String fileEncodingProperty = System.getProperty("file.encoding");
        System.out.println("System Property file.encoding: " + fileEncodingProperty);

        String str = "0123456789" +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "abcdefghijklmnopqrstuvwxyz" +
                "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯ" +
                "абвгдеёжзийклмнопрстуфхцчшщьыъэюя";
        printHex(str.getBytes(Charset.forName("Cp1251")), "Cp1251");
        System.out.println(str);
        System.out.println();

        byte[] ascii = new byte[0x100];
        for (int i = 0x0; i < 0x100; i++) {
            ascii[i] = (byte) i;
        }
        System.out.println("***************************************************************************");
        System.out.println("*   ASCII WIN 1251                                                        *");
        System.out.println("***************************************************************************");
        printHex(ascii, "Cp1251");
        System.out.println("***************************************************************************");
        System.out.println("*   ASCII DOS 866                                                         *");
        System.out.println("***************************************************************************");
        printHex(ascii, "Cp866");
        System.out.printf("0x%04X%n", (short) 'Q');
        System.out.printf("0x%04X%n", (short) 'Й');
        System.out.println((char) 0x00D1);
        System.out.println(((int) 0x0A));
        System.out.println(0x0A);
    }

    /**
     * Prints array of byte in a beautiful hex table with offsets and chars
     * @param buffer
     *        Byte array for print
     * @param charsetName
     *        Char set of byte array
     */
    public static void printHex(byte[] buffer, String charsetName) {
        StringBuilder result = new StringBuilder();
        StringBuilder text = new StringBuilder();
        result.append("\n=================================   HEX   =================================");
        result.append("\n Offset   00 01 02 03 04 05 06 07 08 09 0A 0B 0C 0D 0E 0F  0123456789ABCDEF");
        result.append("\n--------  -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --  ----------------");
        final int LEN = buffer.length;
        int i = 0;
        byte[] buf = new byte[1];
        for (byte b : buffer) {
            // appends offset in the start of current line
            if (i % 0x10 == 0) result.append(String.format("%n%08X  ", i));
            // "%02X" formats the byte as a two-digit uppercase hex value, zero-padded
            result.append(String.format("%02X ", b));
            //    0 (NUL): Нулевой символ (NULL).
            //    7 (BEL): Звуковой сигнал (Bell).
            //    8 (BS): Возврат на шаг (Backspace).
            //    9 (HT): Горизонтальная табуляция (Horizontal Tab).
            //    10 (LF): Перевод строки (Line Feed, \n).
            //    13 (CR): Возврат каретки (Carriage Return, \r).
            //    27 (ESC): Escape-символ.
            //    127 (DEL): Забой/удаление (Delete)
//            if (b != (byte) 0x00 &&
//                    b != (byte) 0x07 &&
//                    b != (byte) 0x08 &&
//                    b != (byte) 0x09 &&
//                    b != (byte) 0x0A &&
//                    b != (byte) 0x0D &&
//                    b != (byte) 0x1B &&
//                    b != (byte) 0x7F) {
//            if (b != 0x0A && b != 0x0D) {
            //    0 NUL, 1 SOH, 2 STX, 3 ETX, 4 EOT, 5 ENQ, 6 ACK, 7 BEL,
            //    8 BS, 9 HT, 10 LF, 11 VT, 12 FF, 13 CR, 14 SO, 15 SI,
            //    16 DLE, 17 DC1, 18 DC2, 19 DC3, 20 DC4, 21 NAK, 22 SYN, 23 ETB,
            //    24 CAN, 25 EM, 26 SUB, 27 ESC, 28 FS, 29 GS, 30 RS, 31 US.
            if ((b & 0xFF) > 0x1F) {
                // copies each char from current byte to buffer
                buf[0] = b;
                try {
                    text.append(new String(buf, charsetName));
                } catch (UnsupportedEncodingException e) {
                    text.append(new String(buf));
                }
            } else
                text.append((char) 0);
            // adds extra spaces
            if (++i == LEN && i % 0x10 != 0) {
                final int EXT = 0x10 - i % 0x10; // number of extra spaces
                for (int j = 0; j < EXT; j++) {
                    result.append("   ");
                    i++;
                }
            }
            // appends text from char buffer to the end of current line
            if (i % 0x10 == 0) {
                result.append(" ").append(text);
                text.setLength(0);
            }
        }
        result.append("\n===========================================================================\n");
        System.out.println(result);
    }

    /**
     * Like above but with defaultCharset
     * @param buffer
     *        Byte array for print
     */
    public static void printHex(byte[] buffer) {
        printHex(buffer, Charset.defaultCharset().name());
    }
}
