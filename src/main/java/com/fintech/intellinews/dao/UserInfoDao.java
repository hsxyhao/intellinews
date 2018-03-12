package com.fintech.intellinews.dao;

import com.fintech.intellinews.entity.UserInfoEntity;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserInfoDao {

    /**
     * 获取用户信息
     *
     * @param userInfo 用户信息对象
     * @return 用户信息对象
     */
    List<UserInfoEntity> listUserInfos(UserInfoEntity userInfo);

    /**
     * 根据用户id获取信息
     * @param id 用户id
     * @return 用户信息
     */
    UserInfoEntity getUserInfoById(@Param("userId") Long id);

    /**
     * 添加用户信息
     *
     * @param userInfoEntity 用户信息对象
     */
    void insertUserInfo(UserInfoEntity userInfoEntity);


    /**
     * 根据用户id列表获取用户列表
     *
     * @param ids 用户id列表
     * @return 用户列表
     */
    @MapKey("id")
    Map<Long, UserInfoEntity> mapUserByIds(List<Long> ids);
}