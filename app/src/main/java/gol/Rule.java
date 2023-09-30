package gol;

public abstract class Rule {

    public abstract String getName();

    /**
     *
     * @param x cell x position
     * @param y cell y position
     * @param board current board
     * @return <code>true</code> if cell will be alive
     */
    public abstract boolean isLive(int x, int y, Board board);

    @Override
    public String toString() {
        return getName();
    }

}
