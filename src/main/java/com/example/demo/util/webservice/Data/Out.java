package com.example.demo.util.webservice.Data;

import java.io.Serializable;

/**
 * @Auther: mo.zongzhe
 * @Date: 2018/8/14 10:40
 * @Description:
 * @since 0.1.0
 */
public class Out implements Serializable {
    private String data;
    private String message;
    private String status;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
