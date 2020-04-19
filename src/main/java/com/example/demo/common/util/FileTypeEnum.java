package com.example.demo.common.util;

/**
 * @author Dante
 * @package com.aoto.common.util
 * @date 2019/3/4 000416:33
 */
public enum FileTypeEnum {
    CARD(1, "有卡"), NO_CARD(2, "无卡");

    private String info;
    private Integer type;

    public String getInfo() {
        return info;
    }

    public Integer getType() {
        return type;
    }

    FileTypeEnum(int type, String info) {
        this.type = type;
        this.info = info;
    }

    public FileTypeEnum getByType(int type) {
        for (FileTypeEnum f : FileTypeEnum.values()) {
            if (f.getType() == type) {
                return f;
            }
        }
        return null;
    }

}
