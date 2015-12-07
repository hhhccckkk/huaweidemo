package com.hck.huawei.util;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

import com.hck.huawei.bean.HomeBane;

public class JsonUtils {
    private static ObjectMapper sObjectMapper;

    private static ObjectMapper getMapper() {
        if (sObjectMapper == null) {
            synchronized (JsonUtils.class) {
                if (sObjectMapper == null) {
                    sObjectMapper = new ObjectMapper();
                    sObjectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                }
            }
        }
        return sObjectMapper;
    }

    public static <T> T parse(String json, Class<T> clasz) throws JsonParseException, JsonMappingException, IOException {
        return getMapper().readValue(json, clasz);
    }

    public static String toString(Object object) throws JsonGenerationException, JsonMappingException, IOException {
        return getMapper().writeValueAsString(object);
    }
    
    /**
     *   "attribute": {
            "dangerous": 0,
            "highValue": 0,
            "risky": 0,
            "normal": 0
        },
}
},
     * @param data
     * @param homeBane
     */
    public static void getHomeData(String data,HomeBane homeBane){
        JSONObject jsonObject=null;
        JSONArray jsonArray=null;
        try {
            jsonObject=new JSONObject(data);
            jsonObject=jsonObject.getJSONObject("data");
            String tatolString=jsonObject.getString("total");
            homeBane.setTotal(tatolString);
           JSONObject jsonObject1=jsonObject.getJSONObject("attribute");
           JSONObject jsonObject2=jsonObject.getJSONObject("safe");
           
            homeBane.setAlarm(jsonObject2.getString("alarm"));
            homeBane.setWarning(jsonObject2.getString("warning"));
            
            homeBane.setHighValue(jsonObject1.getString("highValue"));
            homeBane.setNormal(jsonObject1.getString("normal"));
            homeBane.setUnNormal(jsonObject1.getString("risky"));
            homeBane.setDangerous(jsonObject1.getString("dangerous"));
        } catch (Exception e) {
            Log.d("hck", "解析错误: "+e.toString());
        }
    }

}
