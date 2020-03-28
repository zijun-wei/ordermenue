package cn.zijun.ordermenue.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
/**
* 商品包含类目
*
* */

@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = 8102643862907001159L;
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<productInfoVo>productInfoVOList;
}
