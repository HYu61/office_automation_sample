package pers.hyu.oa.global.infoenum;

import java.util.EnumSet;

public enum ExpenseEnum {
    TRAFFIC("Traffic Expense"),
    MEAL("Meal Fee"),
    ACCOMMODATION("Accommodation Fee"),
    OFFICE("Office Expense");

    private final String cate;
    ExpenseEnum(String cate) {
        this.cate = cate;
    }

    public String getCate() {
        return cate;
    }

    public static EnumSet<ExpenseEnum> getAllExpense(){
        return EnumSet.allOf(ExpenseEnum.class);
    }

}
