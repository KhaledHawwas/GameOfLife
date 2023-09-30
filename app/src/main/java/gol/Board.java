package gol;

public class Board {

    private final int width, height;
    private final boolean[][] cells;
    private boolean edged = false;

    public Board(int w, int h) {
        cells = new boolean[h][w];
        this.height = h;
        this.width = w;
    }

    /**
     *
     * @param x of selected cell
     * @param y of selected cell
     * @return return cells around  selected cell at x and y
     */
    public boolean[] getNeighbours(int x, int y) {
        int index = x + (y * width);
        int scalesNum = width * height;
        boolean[] n = new boolean[8];
        int topLeft, top, topRight,
            left, right,
            bottomLeft, bottom, bottomRight;
        //TODO Find
        topLeft = (index - (width) - 1);
        topLeft = (topLeft < 0 ? topLeft + scalesNum : topLeft);
        n[0] = (edged ? (y > 0 && x > 0 && cells[y - 1][x - 1])
                : (cells[topLeft / width][topLeft % width]));
        top = (index - width);
        top = (top < 0 ? top + scalesNum : top);
        n[1] = (edged ? (y > 0 && cells[y - 1][x])
                : (cells[top / width][top % width]));
        topRight = (index - width + 1);
        topRight = (topRight < 0 ? topRight + scalesNum : topRight);
        n[2] = (edged ? (y > 0 && x + 1 < width && cells[y - 1][x + 1])
                : (cells[topRight / width][topRight % width]));
        left = (index - 1);
        left = (left < 0 ? left + scalesNum : left);
        n[3] = (edged ? (x > 0 && cells[y][x - 1])
                : (cells[left / width][left % width]));
        right = (index + 1) % scalesNum;
        n[4] = (edged ? (x + 1 < width && cells[y][x + 1])
                : (cells[right / width][right % width]));
        bottomLeft = (index + width - 1) % scalesNum;
        n[5] = (edged ? (x > 0 && y + 1 < height && cells[y + 1][x - 1])
                : (cells[bottomLeft / width][bottomLeft % width]));
        bottom = (index + width) % scalesNum;
        n[6] = (edged ? (y + 1 < height && cells[y + 1][x])
                : (cells[bottom / width][bottom % width]));
        bottomRight = (index + width + 1) % scalesNum;
        n[7] = (edged ? (y + 1 < height && x + 1 < width && cells[y + 1][x + 1])
                : (cells[bottomRight / width][bottomRight % width]));
        return n;
    }
//next are set and get
    public void setEdged(boolean edged) {
        this.edged = edged;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean getAt(int x, int y) {
        return cells[y][x];
    }

    public boolean setAt(int x, int y, boolean val) {
        return cells[y][x] = val;
    }

    public boolean isEdged() {
        return edged;
    }

}
