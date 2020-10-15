package pers.hyu.oa.global.infoenum;

public enum StatusEnum {

    CREATED("Created"),
    SUBMIT("Submitted"),
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
