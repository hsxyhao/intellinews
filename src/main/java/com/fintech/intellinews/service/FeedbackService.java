package com.fintech.intellinews.service;

import com.fintech.intellinews.vo.FeedbackVO;

import java.util.List;

/**
 * @author wanghao
 * create 2018-03-11 21:38
 **/
public interface FeedbackService {
    /**
     * 获取所有未读反馈信息列表
     * @return 未读反馈信息
     */
    List<FeedbackVO> listNotReadFeedback();

    /**
     * 未读取信息数量
     * @return 未读取信息数量
     */
    Integer notReadFeedbackCount();

    /**
     * 根据用户id获取该用户未读取信息
     * @param userId 用户id
     * @return 未读反馈信息
     */
    List<FeedbackVO> listNotReadFeedbackById(Long userId);

    /**
     * 根据用户id获取该用户未读取信息数量
     * @param userId 用户id
     * @return 未读反馈信息数量
     */
    Integer countNotFeedbackById(Long userId);

    /**
     * 添加反馈信息
     * @param userId 用户id
     * @param msg 用户反馈信息
     * @return 新增反馈信息id
     */
    Integer addFeedback(Long userId,String msg);
}
