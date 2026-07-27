package com.wenbobi.springmvc_demo2.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum BookStatus {
    DELETED(0,"无效"),
    NORMAL(1,"正常"),
    FORBIDDEN(2,"不允许借阅");
    private int code;
    @Getter
    private String name;


    public static BookStatus getNameByCode(int code){
        switch (code){
            case 0:
                return DELETED;
            case 1:
                return NORMAL;
            case 2:
                return FORBIDDEN;
        }
        return null;
    }
}
