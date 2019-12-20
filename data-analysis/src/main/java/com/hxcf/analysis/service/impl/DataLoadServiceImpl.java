package com.hxcf.analysis.service.impl;

import com.hxcf.analysis.mapper.wealth.AdvertPlaceMapper;
import com.hxcf.analysis.model.wealth.AdvertPlace;
import com.hxcf.analysis.service.DataLoadService;
import com.hxcf.api.analysis.vo.request.AdvertPlaceReqVO;
import com.hxcf.api.analysis.vo.response.AdvertPlaceResponseVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DataLoadServiceImpl implements DataLoadService {
    private final AdvertPlaceMapper advertPlaceMapper;


    public AdvertPlaceResponseVO findByParam(AdvertPlaceReqVO reqVO) {
        AdvertPlaceResponseVO advertPlaceResponseVO = new AdvertPlaceResponseVO();
        AdvertPlace advertPlace = advertPlaceMapper.selectByPrimaryKey(reqVO.getId());
        if (advertPlace != null) {
            BeanUtils.copyProperties(advertPlace, advertPlaceResponseVO);
        }
        return advertPlaceResponseVO;
    }
}
