package com.hck.huawei.bean;

import java.io.Serializable;

public class CarBean implements Serializable{

 private String carNum;
 private String carNianJI;
 private String carChang;
 private String carUser;
public String getCarNum() {
    return carNum;
}
public void setCarNum(String carNum) {
    this.carNum = carNum;
}
public String getCarNianJI() {
    return carNianJI;
}
public void setCarNianJI(String carNianJI) {
    this.carNianJI = carNianJI;
}
public String getCarChang() {
    return carChang;
}
public void setCarChang(String carChang) {
    this.carChang = carChang;
}
public String getCarUser() {
    return carUser;
}
public void setCarUser(String carUser) {
    this.carUser = carUser;
}
 

}
