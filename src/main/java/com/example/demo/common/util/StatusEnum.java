package com.example.demo.common.util;

/**
 * Created by Dante on 2019/1/20.
 */
public enum StatusEnum {


    WAIT(1, "待"), SUCCESS(2, "成功"), FAILED(3, "失败"),
    REFUND(4,"已退款");


    private int type;
    private String info;

    StatusEnum(int type, String info) {
        this.type = type;
        this.info = info;
    }

    public static StatusEnum getByType(int type) {
        for (StatusEnum s : StatusEnum.values()) {
            if (s.getType() == type) {
                return s;
            }
        }
        return FAILED;
    }


    public int getType() {
        return this.type;
    }
    public String getInfo(){return this.info;}

}
