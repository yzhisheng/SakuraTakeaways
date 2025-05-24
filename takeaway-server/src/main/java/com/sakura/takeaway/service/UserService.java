package com.sakura.takeaway.service;

import com.sakura.takeaway.dto.UserLoginDTO;
import com.sakura.takeaway.entity.User;

/**
 * @Description
 * @ClassName UserService
 * @Author Sakura
 * @DateTime 2025-05-25 06:36:29
 * @Version 1.0
 */
public interface UserService {
    /**
     * 微信登录
     * @param userLoginDTO
     * @return
     */
    User wxLogin(UserLoginDTO userLoginDTO);
}
