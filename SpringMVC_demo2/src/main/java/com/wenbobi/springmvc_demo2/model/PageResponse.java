package com.wenbobi.springmvc_demo2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@AllArgsConstructor
//@NoArgsConstructor
@Data
@RequiredArgsConstructor
public class PageResponse<T> {
    private final Integer total;
    private List<T> records;

}
