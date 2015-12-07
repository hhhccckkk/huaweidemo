package com.hck.huawei.bean;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class OrderBean implements Serializable {
    /**
     * 订单号 - orderid 承运商是 - companyname 运输安全 - transafe_remark 运输时效 -
    "id":"D752011265F58B411FD7C483DF21956D",
"orderid":"HTM201511281621",
"companyname":"DHL",
"carnum":"",
"drivername":"",
"driverphone":"",
"loadingtime":"2015-12-01 00:00:00",
"status":"0",
"eventstatus":"0",
"transafe":"",
"attribute":"高价值",
"ordertype":"2",
"deleted":"0"

     */
    @JsonProperty("orderid")
    private String orderId;
    @JsonProperty("companyname")
    private String companyname;
    @JsonProperty("transafe_remark")
    private String transafe;
    @JsonProperty("eventstatus_remark")
    private String eventstatus;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getTransafe() {
        return transafe;
    }

    public void setTransafe(String transafe) {
        this.transafe = transafe;
    }

    public String getEventstatus() {
        return eventstatus;
    }

    public void setEventstatus(String eventstatus) {
        this.eventstatus = eventstatus;
    }

}
