package com.meiya.springcloudstudy.system.controller;

import com.meiya.springcloudstudy.common.response.BuildResponseUtil;
import com.meiya.springcloudstudy.common.response.ResponseData;
import com.meiya.springcloudstudy.system.bean.dto.SystemUserInfoDto;
import com.meiya.springcloudstudy.system.service.ISystemUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author bai bing
 * @since 2021-06-11
 */
@RestController
@RequestMapping(value = "system")
public class SystemUserInfoController {

    @Autowired
    private ISystemUserInfoService systemUserInfoService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseData login(@Valid @RequestBody SystemUserInfoDto userInfoDto, BindingResult result){
        FieldError fieldError = result.getFieldError();
        if(result.hasErrors() && fieldError != null){
            return BuildResponseUtil.buildFailResponse(fieldError.getDefaultMessage());
        }
        return BuildResponseUtil.buildSuccessResponse(systemUserInfoService.login(userInfoDto));
    }

}

