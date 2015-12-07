package com.hck.huawei.bean;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class TongZhiData implements Serializable{
    @JsonProperty("result")
  private List<TongZhiBean> tongZhiBeans;

public List<TongZhiBean> getTongZhiBeans() {
    return tongZhiBeans;
}

public void setTongZhiBeans(List<TongZhiBean> tongZhiBeans) {
    this.tongZhiBeans = tongZhiBeans;
}
  

}
