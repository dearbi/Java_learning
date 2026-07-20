package com.wenbobi.springiocdemo1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfo {
    private Integer id;
    private String name;
}
