package com.hxcf.job.service;

import com.hxcf.api.analysis.service.AdvertPlaceFeignApi;
import com.hxcf.api.analysis.vo.request.AdvertPlaceReqVO;
import com.hxcf.api.analysis.vo.response.AdvertPlaceResponseVO;
import com.hxcf.common.generic.Result;
import com.hxcf.common.util.JsonUtil;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.core.util.DateUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@JobHandler(value = "simpleJob")
@Component
public class SimpleJob extends IJobHandler {

    @Resource
    private AdvertPlaceFeignApi advertPlaceFeignApi;

    public ReturnT<String> execute(String s) throws Exception {
        XxlJobLogger.log("XXL-JOB, Hello World." + DateUtil.formatDateTime(new Date()));

        for (int i = 0; i < 5; i++) {
            AdvertPlaceReqVO reqVO = new AdvertPlaceReqVO();
            reqVO.setId(1);
            Result<AdvertPlaceResponseVO> result = advertPlaceFeignApi.findByParam(reqVO);
            XxlJobLogger.log("beat at:" + i + ":" + JsonUtil.toJsonString(result.getData()));
            TimeUnit.SECONDS.sleep(2);
        }
        return SUCCESS;
    }
//    public ReturnT<String> execute(String s) throws Exception {
//        XxlJobLogger.log("XXL-JOB, Hello World."+ DateUtil.formatDateTime(new Date()));
//
//        for (int i = 0; i < 5; i++) {
//            XxlJobLogger.log("beat at:" + i);
//            TimeUnit.SECONDS.sleep(2);
//        }
//        return SUCCESS;
//    }
}
