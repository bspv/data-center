package com.hxcf.analysis.service;

import com.hxcf.api.analysis.vo.request.AdvertPlaceReqVO;
import com.hxcf.api.analysis.vo.response.AdvertPlaceResponseVO;

public interface DataLoadService {

    AdvertPlaceResponseVO findByParam(AdvertPlaceReqVO reqVO);
}
