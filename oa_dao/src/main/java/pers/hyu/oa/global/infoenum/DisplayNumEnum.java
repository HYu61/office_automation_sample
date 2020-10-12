package pers.hyu.oa.global.infoenum;

public enum DisplayNumEnum {
    DEPT_PAGE(5),
    EMP_PAGE(10);

    private final int displayNum;

    DisplayNumEnum(int displayNum) {
        this.displayNum = displayNum;
    }

    public int getDisplayNum() {
        return this.displayNum;
    }
}
