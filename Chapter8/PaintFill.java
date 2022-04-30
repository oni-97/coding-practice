package Chapter8;

public class PaintFill {
    void paintFill(int[][] screen, int r, int c, int color) {
        if (screen[r][c] == color)
            return;
        fill(screen, r, c, color, screen[r][c]);
    }

    void fill(int[][] screen, int r, int c, int color, int preColor) {
        if (r < 0 || c < 0 || r >= screen[0].length || c >= screen.length) {
            return;
        }

        if (screen[r][c] != preColor)
            return;

        screen[r][c] = color;
        fill(screen, r + 1, c, color, preColor);
        fill(screen, r - 1, c, color, preColor);
        fill(screen, r, c + 1, color, preColor);
        fill(screen, r, c - 1, color, preColor);
    }
}
