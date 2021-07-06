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

    /**
     * 用户登录
     * @param userInfoDto 登录参数实体
     * @return 成功：返回token 失败:返回异常信息
     */
    String login(SystemUserInfoDto userInfoDto);
}
