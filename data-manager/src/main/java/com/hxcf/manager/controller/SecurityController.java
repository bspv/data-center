package com.hxcf.manager.controller;

import com.hxcf.common.generic.Result;
import com.hxcf.common.generic.TipsCodeEnum;
import com.hxcf.common.util.JsonUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

@ApiIgnore
@RestController
@RequestMapping("/security")
public class SecurityController {

    @PostMapping("/forward")
    public Result<String> forward(HttpServletRequest request) {
        Result<String> result;
        try {
            result =
                    JsonUtil.parseResult((String) request.getAttribute("security_result"), String.class);
        } catch (Exception e) {
            result = Result.failure(TipsCodeEnum.CODE_0011.getCode(), e.getMessage());
        }
        return result;
    }
}
