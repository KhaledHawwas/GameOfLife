package gol;

import java.util.Random;


public class Game {

    private Board board;
    private Rule rule;

    public Game(int w, int h) {
        board = new Board(w, h);
    }

    /**
     * run all cells,then set the next generation.
     */
    public void run() {
        int height = board.getHeight(), width = board.getWidth();
        Board nextGeneration = new Board(width, height);
        nextGeneration.setEdged(board.isEdged());
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                nextGeneration.setAt(x, y, rule.isLive(x, y, board));
            }
        }
        board = nextGeneration;
    }

    /**
     *
     * @param cellRatio the ratio of the cell between 0 and 100
     */
    public void restart(int cellRatio) {
        if(cellRatio>100||cellRatio<0)
            throw new IllegalArgumentException("the ratio of the cell must be between 0 and 100");
        int height = board.getHeight(), width = board.getWidth();
        Random random = new Random();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                board.setAt(x, y, random.nextInt(0,101) < cellRatio);
            }
        }
    }

    /**
     * remove all cells.
     */
    public void clear() {
        int height = board.getHeight(), width = board.getWidth();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                board.setAt(x, y, false);
            }
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }


}
