package com.wenbobi.springmvc_demo2.model;

import lombok.Data;

@Data
public class PageRequest {
    private Integer currentPage=1;
    private Integer pageSize=10;

    private int offset;

    public int getOffset() {
        return (currentPage - 1) * pageSize;
    }
}
