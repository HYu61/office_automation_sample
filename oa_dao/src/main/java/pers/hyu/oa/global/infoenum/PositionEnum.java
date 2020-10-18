package pers.hyu.oa.global.infoenum;

import java.util.EnumSet;

/**
 * used for describe the employee's position
 */
public enum PositionEnum {
    SF("Staff"),
    AUD("Auditor"),
    DM("Department Manager"),
    GM_ASST("General Manager Assistant"),
    GM("General Manager");


    private final String position;

    PositionEnum(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public static EnumSet<PositionEnum> getAllPosition(){
        return EnumSet.allOf(PositionEnum.class);
    }


}
