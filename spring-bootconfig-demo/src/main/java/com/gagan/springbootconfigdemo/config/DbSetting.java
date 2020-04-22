/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 11:51:11
 * @modify date 2020-04-22 11:51:11
 * @desc [description]
 */
package com.gagan.springbootconfigdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration Implies this is a Bean
 * @ConfigurationProperties Implies this class has Properties data
 * Properties of Class is mapped with property files value
 * DOnt forget to create getters and setters
 * Class Proeprties name must be same as property file names
 * YUsed when Multiple values are meant to be used together at multiple places
 */

 @Configuration
 @ConfigurationProperties("db")
public class DbSetting {

    private String url;
    private String username;
    private String password;
    private int port;

    public DbSetting(){

    }


    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "{" +
            " url='" + getUrl() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", port='" + getPort() + "'" +
            "}";
    }

    public DbSetting(String url, String username, String password, int port) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.port = port;
    }


}