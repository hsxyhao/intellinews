package com.fintech.intellinews.service.impl;

import com.fintech.intellinews.AppException;
import com.fintech.intellinews.dao.FeedbackDao;
import com.fintech.intellinews.dao.UserInfoDao;
import com.fintech.intellinews.entity.FeedbackEntity;
import com.fintech.intellinews.entity.UserInfoEntity;
import com.fintech.intellinews.enums.ResultEnum;
import com.fintech.intellinews.service.FeedbackService;
import com.fintech.intellinews.service.UserService;
import com.fintech.intellinews.vo.FeedbackVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @author wanghao
 * create 2018-03-11 21:38
 **/
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackDao feedbackDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public List<FeedbackVO> listNotReadFeedback() {
        List<FeedbackEntity> feedbackList = feedbackDao.listNotReadFeedback();
        List<Long> listId = new ArrayList<>();
        if (feedbackList.isEmpty()) {
            throw new AppException(ResultEnum.NO_LIST_NOT_READ_FEEDBACK);
        }
        for (FeedbackEntity feedbackEntity : feedbackList) {
            listId.add(feedbackEntity.getUserId());
        }
        Map<Long,UserInfoEntity> userInfoMap = userInfoDao.mapUserByIds(listId);
        List<FeedbackVO> feedbackVOS = new ArrayList<>();
        for (FeedbackEntity feedbackEntity : feedbackList) {
            FeedbackVO feedbackVO = new FeedbackVO();
            feedbackVO.setId(feedbackEntity.getId());
            feedbackVO.setUserId(feedbackEntity.getUserId());
            feedbackVO.setMsg(feedbackEntity.getMsg());
            feedbackVO.setCreateTime(feedbackEntity.getGmtCreate());
            feedbackVO.setUserName(userInfoMap.get(feedbackEntity.getId()).getUsername());
            feedbackVOS.add(feedbackVO);
        }
        return feedbackVOS;
    }

    @Override
    public Integer notReadFeedbackCount() {
        return feedbackDao.countNotReadFeedback();
    }

    @Override
    public List<FeedbackVO> listNotReadFeedbackById(Long userId) {
        List<FeedbackEntity> feedbackList = feedbackDao.listNotReadFeedbackById(userId);
        if (feedbackList.isEmpty()){
            throw new AppException(ResultEnum.NO_LIST_NOT_READ_FEEDBACK);
        }
        UserInfoEntity userInfoEntity = userInfoDao.getUserInfoById(userId);
        List<FeedbackVO> feedbackVOS = new ArrayList<>();
        for (FeedbackEntity feedbackEntity : feedbackList) {
            FeedbackVO feedbackVO = new FeedbackVO();
            feedbackVO.setId(feedbackEntity.getId());
            feedbackVO.setUserId(feedbackEntity.getUserId());
            feedbackVO.setMsg(feedbackEntity.getMsg());
            feedbackVO.setCreateTime(feedbackEntity.getGmtCreate());
            feedbackVO.setUserName(userInfoEntity.getUsername());
            feedbackVOS.add(feedbackVO);
        }
        return feedbackVOS;
    }

    @Override
    public Integer countNotFeedbackById(Long userId) {
        return feedbackDao.countNotFeedbackById(userId);
    }

    @Override
    public Integer addFeedback(Long userId, String msg) {
        FeedbackEntity feedback = new FeedbackEntity();
        feedback.setId(userId);
        feedback.setMsg(msg);
        feedback.setRead(false);
        feedback.setGmtCreate(Calendar.getInstance().getTime());
        feedback.setGmtModified(Calendar.getInstance().getTime());
        Integer count = feedbackDao.addFeedback(feedback);
        if (count == 0) {
            throw new AppException(ResultEnum.INSERT_FEEDBACK_FAILED_ERROR);
        }
        return count;
    }

}
