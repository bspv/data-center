package com.hxcf.job.tests.feign;

import com.hxcf.api.analysis.service.AdvertPlaceFeignApi;
import com.hxcf.api.analysis.vo.request.AdvertPlaceReqVO;
import com.hxcf.api.analysis.vo.response.AdvertPlaceResponseVO;
import com.hxcf.common.generic.Result;
import com.hxcf.job.tests.TestBase;
import org.junit.Test;

import javax.annotation.Resource;

public class TestFeignApi extends TestBase {
    @Resource
    private AdvertPlaceFeignApi advertPlaceFeignApi;

    @Test
    public void testLoadAdvertPlace(){
        AdvertPlaceReqVO reqVO = new AdvertPlaceReqVO();
        reqVO.setId(1);
        Result<AdvertPlaceResponseVO> result = advertPlaceFeignApi.findByParam(reqVO);
        print(result);
    }
}
