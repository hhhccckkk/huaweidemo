package com.hck.huawei.net;

import android.R.string;

import com.hck.httpserver.HCKHttpClient;
import com.hck.httpserver.HCKHttpResponseHandler;
import com.hck.httpserver.RequestParams;

public class Request {
    private static final int TIME_OUT = 15 * 1000;
    public static final int REQUEST_SUCCESS = 1;
    private static HCKHttpClient client = new HCKHttpClient();
    static {
        client.setTimeout(TIME_OUT);
    }


    public static void getOrderData(String data, HCKHttpResponseHandler handler) {
        client.get(data, handler);
    }
    
    public static void getTongZhi(String data, HCKHttpResponseHandler handler){
        client.get(data, handler);
    }
    public static void getHomeData(String data, HCKHttpResponseHandler handler){
        client.get(data, handler);
    }

}
