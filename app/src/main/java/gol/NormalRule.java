package gol;

public class NormalRule extends Rule {

    private final boolean[] survivalRule = new boolean[9];
    private final boolean[] createRule = new boolean[9];
    private final String name;

    public NormalRule(String name, String rule) {
        this.name = name;

        setRule(rule);
    }

    public void setRule(String rule) {
        if (!rule.contains("/")) {
            throw new IllegalArgumentException();
        }
        String survive = rule.split("/")[0];
        String create = rule.split("/")[1];
        for (int i = 0; i < survivalRule.length; i++) {
            survivalRule[i] = survive.contains("" + i);
            createRule[i] = create.contains("" + i);
        }
    }

    @Override
    public boolean isLive(int x, int y, Board board) {
        int aliveN = 0;
        boolean n[] = board.getNeighbours(x, y);
        for (boolean b : n) {
            aliveN += (b ? 1 : 0);
        }
        return (board.getAt(x, y))
                ? (survivalRule[aliveN])
                : (createRule[aliveN]);
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean[] getSurvivalRule() {
        return survivalRule;
    }

    public boolean[] getCreateRule() {
        return createRule;
    }
  public void setCreateRule(int index,boolean value){
        createRule[index]=value;
  }
    public void setSurvivalRule(int index,boolean value){
        survivalRule[index]=value;
    } @Override
    public String toString() {
        return getName();
    }
}
