package Chapter5;

public class DrawLine {
    static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int widthByte = width / 8;
        int startRow = widthByte * y;
        int startCol = x1 / 8 + startRow;
        int startPixel = x1 % 8;
        int endCol = x2 / 8 + startRow;
        int endPixel = x2 % 8;
        for (int i = startCol + 1; i < endCol; i++) {
            screen[i] = (byte) 0xff;
        }

        byte start = (byte) (0xFF >>> startPixel);
        byte end = (byte) ~(0xFF >>> (endPixel + 1));
        if (startCol == endCol) {
            screen[startCol] = (byte) (start & end);
        } else {
            screen[startCol] = start;
            screen[endCol] = end;
        }
    }
}
