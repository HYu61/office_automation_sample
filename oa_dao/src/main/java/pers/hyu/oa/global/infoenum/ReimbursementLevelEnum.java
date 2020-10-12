package pers.hyu.oa.global.infoenum;

public enum ReimbursementLevelEnum {
    DM_LIMIT(5000);

    private final double limit;
    ReimbursementLevelEnum(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

}
