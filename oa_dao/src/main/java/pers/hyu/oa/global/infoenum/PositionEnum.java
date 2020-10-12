package pers.hyu.oa.global.infoenum;

import java.util.EnumSet;

public enum PositionEnum {
    SF("Staff"),
    AUD("Auditor"),
    DM("Department Manager"),
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
