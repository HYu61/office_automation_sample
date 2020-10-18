package pers.hyu.oa.global.infoenum;

/**
 * used for setting the limitation that the approver can approve
 */
public enum ReimbursementLevelEnum {
    DM_LIMIT(5000),
    FIN_DM_LIMIT(10000);

    private final double limit;
    ReimbursementLevelEnum(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

}
