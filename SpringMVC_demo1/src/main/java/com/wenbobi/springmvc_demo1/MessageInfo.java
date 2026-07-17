package com.wenbobi.springmvc_demo1;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageInfo {
    private String from;
    private String to;
    private String message;

}
