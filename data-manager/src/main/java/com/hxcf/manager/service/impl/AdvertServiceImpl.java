package com.hxcf.manager.service.impl;

import com.hxcf.api.analysis.service.AdvertPlaceFeignApi;
import com.hxcf.api.analysis.vo.request.AdvertPlaceReqVO;
import com.hxcf.api.analysis.vo.response.AdvertPlaceResponseVO;
import com.hxcf.common.generic.Result;
import com.hxcf.common.util.JsonUtil;
import com.hxcf.manager.service.AdvertService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class AdvertServiceImpl implements AdvertService {
    @Resource
    private AdvertPlaceFeignApi advertPlaceFeignApi;

    public void findAdvertPlace() {
        AdvertPlaceReqVO reqVO = new AdvertPlaceReqVO();
        reqVO.setId(1);
        Result<AdvertPlaceResponseVO> result = advertPlaceFeignApi.findByParam(reqVO);
        log.info(JsonUtil.toJsonString(result));
    }
}
