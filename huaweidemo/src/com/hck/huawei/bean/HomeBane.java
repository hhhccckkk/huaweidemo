package com.hck.huawei.bean;

public class HomeBane {
/**
 * -{"code":0,
"data":-{"total":3480,
"status":-{"enRoute":1401,
"picking":876,
"dispatching":1203
},
"attribute":-{"highValue":725,
"dangerous":426,
"urgent":527,
"unNormal":401,
"normal":1401
},
"safe":-{"warning":56,
"alarm":35
}
}
}
 */
/**
 * attribute:
高价值 - highValue
危险品 - dangerous
紧急 - urgent
异常 - unNormal
正常 - normal
safe：
预警 - warning
报警- alarm    
 */
    private String total;
    private String highValue;
    private String urgent;
    private String dangerous;
    private String unNormal;
    private String normal;
    private String warning;
    private String alarm;
    
    public String getDangerous() {
        return dangerous;
    }
    public void setDangerous(String dangerous) {
        this.dangerous = dangerous;
    }
    public String getTotal() {
        return total;
    }
    public void setTotal(String total) {
        this.total = total;
    }
    public String getHighValue() {
        return highValue;
    }
    public void setHighValue(String highValue) {
        this.highValue = highValue;
    }
    public String getUrgent() {
        return urgent;
    }
    public void setUrgent(String urgent) {
        this.urgent = urgent;
    }
    public String getUnNormal() {
        return unNormal;
    }
    public void setUnNormal(String unNormal) {
        this.unNormal = unNormal;
    }
    public String getNormal() {
        return normal;
    }
    public void setNormal(String normal) {
        this.normal = normal;
    }
    public String getWarning() {
        return warning;
    }
    public void setWarning(String warning) {
        this.warning = warning;
    }
    public String getAlarm() {
        return alarm;
    }
    public void setAlarm(String alarm) {
        this.alarm = alarm;
    }
    

}
