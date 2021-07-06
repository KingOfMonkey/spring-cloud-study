package com.meiya.springcloudstudy.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meiya.springcloudstudy.common.exception.BusinessException;
import com.meiya.springcloudstudy.common.utils.JsonWebTokenUtil;
import com.meiya.springcloudstudy.system.bean.SystemUserInfo;
import com.meiya.springcloudstudy.system.bean.dto.SystemUserInfoDto;
import com.meiya.springcloudstudy.system.mapper.SystemUserInfoMapper;
import com.meiya.springcloudstudy.system.service.ISystemUserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bai bing
 * @since 2021-06-11
 */
@Service
public class SystemUserInfoServiceImpl extends ServiceImpl<SystemUserInfoMapper, SystemUserInfo> implements ISystemUserInfoService {

    @Override
    @Transactional(readOnly = true)
    public String login(SystemUserInfoDto userInfoDto) {
        SystemUserInfo userInfo = getOne(Wrappers.<SystemUserInfo>lambdaQuery().eq(SystemUserInfo::getUserName, userInfoDto.getUserName())
                .eq(SystemUserInfo::getPassWord, userInfoDto.getPassWord()));
        if(userInfo == null){
            throw new BusinessException("用户名或者密码错误!");
        }else{
            return JsonWebTokenUtil.create(String.valueOf(userInfo.getId()), userInfo.getName(), 3600000);
        }
    }
}
