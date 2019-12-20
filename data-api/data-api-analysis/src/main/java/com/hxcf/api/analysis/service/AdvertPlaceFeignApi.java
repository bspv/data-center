package com.hxcf.api.analysis.service;

import com.hxcf.api.analysis.vo.request.AdvertPlaceReqVO;
import com.hxcf.api.analysis.vo.response.AdvertPlaceResponseVO;
import com.hxcf.common.generic.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "data-analysis")
public interface AdvertPlaceFeignApi {

    @PostMapping("/advert/findAdvertPlaceByParam")
    Result<AdvertPlaceResponseVO> findByParam(@RequestBody AdvertPlaceReqVO advertPlaceReqVO);
}
