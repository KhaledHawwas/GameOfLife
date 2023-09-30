package gol.ui;

import gol.Board;
import gol.GameOfLife;
import gol.Vars;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *this class draw the game.
 */
public class GamePanel extends JPanel {


    private int cellSize;

    @Override
    public void paint(Graphics g) {
        if (GameOfLife.game == null) {
            return;
        }
        Board board=GameOfLife.game.getBoard();
        int boardWidth = board.getWidth();
        int boardHeight = board.getHeight();
        cellSize = Math.min(this.getWidth() / boardWidth, this.getHeight() / boardHeight);
        //print background
        printBackground(g, boardWidth, boardHeight);
        //print cells
        printCells(g, boardWidth, boardHeight);
    }

    private void printCells(Graphics g, int boardWidth, int boardHeight) {
        Board board=GameOfLife.game.getBoard();
        g.setColor(Vars.aliveCellColor);
        for (int y = 0; y < boardHeight; y++) {
            for (int x = 0; x < boardWidth; x++) {
                if (board.getAt(x, y)) {
                    g.fillRect(cellSize * x, cellSize * y, cellSize, cellSize);
                }
            }
        }
    }

    private void printBackground(Graphics g, int boardWidth, int boardHeight) {
        g.setColor(Vars.backgroundColor);
        g.fillRect(0, 0, cellSize * boardWidth, cellSize * boardHeight);
    }

    /**     
     * kill or revival cell when user click.
     * @param mx mouse x position 
     * @param my mouse y position
     */
    public void click(int mx, int my) {
        int fx, fy;
        fx = mx / cellSize;
        fy = my / cellSize;
        Board board =GameOfLife.game.getBoard();
        if (fx>=0&&fy>=0&&fx <= board.getWidth() && fy <= board.getHeight()) {
            board.setAt(fx, fy, !board.getAt(fx, fy));
        }
    }

}
