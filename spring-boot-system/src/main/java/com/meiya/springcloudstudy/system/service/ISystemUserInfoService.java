package com.meiya.springcloudstudy.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.meiya.springcloudstudy.system.bean.SystemUserInfo;
import com.meiya.springcloudstudy.system.bean.dto.SystemUserInfoDto;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bai bing
 * @since 2021-06-11
 */
public interface ISystemUserInfoService extends IService<SystemUserInfo> {

    String login(SystemUserInfoDto userInfoDto);
}
