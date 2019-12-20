package com.hxcf.api.analysis.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AdvertPlaceResponseVO implements Serializable {
    private static final long serialVersionUID = -3948048092395483896L;

    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "页面名")
    private String pageName;

    @ApiModelProperty(value = "页面类型")
    private Integer pageType;

    @ApiModelProperty(value = "广告位名称")
    private String placeName;

    @ApiModelProperty(value = "广告位编号")
    private Integer placeNo;

    @ApiModelProperty(value = "广告位尺寸")
    private String placeSize;

    @ApiModelProperty(value = "示意图地址")
    private String schematicUrl;

    @ApiModelProperty(value = "同时仅支持单个广告，0单个，1多个")
    private Integer single;

    @ApiModelProperty(value = "创建人")
    private String createUser;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
