package com.hxcf.manager.controller;

import com.hxcf.api.analysis.service.AdvertPlaceFeignApi;
import com.hxcf.api.analysis.vo.request.AdvertPlaceReqVO;
import com.hxcf.api.analysis.vo.response.AdvertPlaceResponseVO;
import com.hxcf.common.generic.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dm")
@Api(tags = "广告位查询接口", value = "广告位查询接口")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DataAdvertController {
    private final AdvertPlaceFeignApi advertPlaceFeignApi;

    @PostMapping("/findAdvertPlace")
    @ApiOperation(value = "查询")
    @PreAuthorize("hasRole('admin1')")
    public Result<AdvertPlaceResponseVO> findByParam(@RequestBody AdvertPlaceReqVO advertPlaceReqVO) {
        return advertPlaceFeignApi.findByParam(advertPlaceReqVO);
    }
}
