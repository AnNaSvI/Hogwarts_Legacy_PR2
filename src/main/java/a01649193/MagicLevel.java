package a01649193;

public enum MagicLevel {
    NOOB(50, "*"),
    ADEPT(100, "**"),
    STUDENT(200, "***"),
    EXPERT(500, "****"),
    MASTER(1000,"*****");

    private int mp;
    private String s;
    MagicLevel(int mp, String s) {
        this.mp = mp;
        this.s = s;
    }

    public int toMana() {
        return mp;
    }


    @Override
    public String toString() {
        return s;
    }
}
