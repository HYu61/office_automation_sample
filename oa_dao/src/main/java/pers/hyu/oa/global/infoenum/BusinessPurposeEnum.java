package pers.hyu.oa.global.infoenum;

import java.util.EnumSet;

public enum BusinessPurposeEnum {
    TRAFFIC("Traffic Expense"),
    MEAL("Meal Fee"),
    ACCOMMODATION("Accommodation Fee"),
    OFFICE("Office Expense");

    private final String reason;
    BusinessPurposeEnum(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public static EnumSet<BusinessPurposeEnum> getAllBusinessPurpose(){
        return EnumSet.allOf(BusinessPurposeEnum.class);
    }

}
