package com.example.demo.util.webservice.Data;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/8/17 22:05
 * @modified by:
 * @versions：0.1.0
 */
public class ReqData {
    /**
     * 请求编码编码
     */
    @XStreamAlias("nt01")
    private String encoding;
    /**
     * 请求入参
     */
    @XStreamAlias("nt02")
    private String param;

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
