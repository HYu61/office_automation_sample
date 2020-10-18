package pers.hyu.oa.global.infoenum;

/**
 * used for describe the state of the form
 */
public enum StatusEnum {

    CREATED("Created"),
    SUBMITTED("Submitted"),
    APPROVED("Approved"),
    ROLLED_BACK("Rolled Back"),
    TERMINATED("Terminated"),
    RECHECK("Waiting for Recheck"),
    PAID("Already Paid");

    private final String status;

    StatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
