package com.hxcf.analysis.controller;

import com.hxcf.analysis.service.DataLoadService;
import com.hxcf.api.analysis.vo.request.AdvertPlaceReqVO;
import com.hxcf.api.analysis.vo.response.AdvertPlaceResponseVO;
import com.hxcf.common.generic.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advert")
@Api(tags = "APP风险测评接口", value = "APP风险测评接口")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdvertPlaceController {
    private final DataLoadService dataLoadService;

    @PostMapping("/findAdvertPlaceByParam")
    @ApiOperation(value = "查询")
    public Result<AdvertPlaceResponseVO> findByParam(@RequestBody AdvertPlaceReqVO advertPlaceReqVO) {
        return Result.success(dataLoadService.findByParam(advertPlaceReqVO));
    }
}
