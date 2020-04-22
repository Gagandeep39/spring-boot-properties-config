package com.gagan.springbootconfigdemo.controller;

import java.util.List;
import java.util.Map;

import com.gagan.springbootconfigdemo.config.DbSetting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingController {

    @Value("${my.greeting}")
    private String greetingMessage;

    @Value("${property.name: Default value ebcause proeprty ddoesnt exist}")
    private String defaultValue;

    @Value("Random stati value")
    private String staticValue;

    @Value("${my.list.value}")
    private List<String> listValue;

    /**
     * Spring Expression Language
     * We arent doing Anything special 
     * Theorotically: We will fetch the property value and Evaluate against an Epression
     * ${my.map.value} would have also given same outptu
     */
    @Value("#{${my.map.value}}")
    private Map<String, String> map;

    /**
     * Reading propreties file and mapping it with a class
     * @see DbSetting
     */
    @Autowired
    private DbSetting settings;

    /**
     * Use Spring Package
     * Dependency will be provided by Spring
     * get profile related info 
     * **Must be avoided
     * Always use @Value 
     */
    @Autowired
    private Environment env;

    @GetMapping("/greeting")
    public String greeting(){
        String temp = "";
        temp += "<br>Propert Value: " + greetingMessage;
        temp += "<br>Default Value: " + defaultValue;
        temp += "<br>Static Value: " + staticValue;
        temp += "<br>List Values: " + listValue;
        temp += "<br>Map: " + map;
        temp += "<br>Properties with 'db.*': " + settings;
        return temp;
    }

    @GetMapping("/environment")
    public String environmentDetails(){
        return env.toString();
    }



}