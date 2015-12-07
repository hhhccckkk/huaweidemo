package com.hck.huawei.bean;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class TongZhiBean {
    /**
         "id": "E9272A392F55E3ACF020AC24564A8AD3",
                "orgcode": "200HWS",
                "ordercode": "HTM201511281620",
                "carrier": "\u4e2d\u5916\u8fd0",
                "carnum": "\u4eacD890K5",
                "type": "2",
                "alarmtime": "2015-12-02 11:25:06",
                "alarmtime_end": "2015-12-02 11:25:06",
                "isdeal": "0",
                "lng": "104.0709390",
                "lat": "30.5421870",
                "address": "\u56db\u5ddd\u7701\u6210\u90fd\u5e02\u6b66\u4faf\u533a\u5929\u5e9c\u4e94\u8857"


   字段说明
订单号：ordercode
地址 ：address
报警类型：type(1-被拆报警，2-非指定地点开锁，3-离线报警，4-线路偏移)
承运商：carrier
时间：alarmtime
     */
    @JsonProperty("address")
    private String address;
    @JsonProperty("ordercode")
    private String ordercode;
    @JsonProperty("carrier")
    private String carrier;
    @JsonProperty("alarmtime")
    private String alarmtime;
    @JsonProperty("type")
    private String type;
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getOrdercode() {
        return ordercode;
    }
    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }
    public String getCarrier() {
        return carrier;
    }
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
    public String getAlarmtime() {
        return alarmtime;
    }
    public void setAlarmtime(String alarmtime) {
        this.alarmtime = alarmtime;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    

}
