package com.wenbobi.springiocdemo1.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "dbtypes")
@Data
public class Dbtypes {
    private List<String> name;
    private Map<String,String> map;
}
