package com.fintech.intellinews.dao;

import com.fintech.intellinews.entity.AdvertiseEntity;
import com.fintech.intellinews.entity.FeedbackEntity;

import java.util.List;

public interface FeedbackDao {

    List<FeedbackEntity> listNotReadFeedback();

    Integer countNotReadFeedback();

    List<FeedbackEntity> listNotReadFeedbackById(Long userId);

    Integer countNotFeedbackById(Long userId);

    Integer addFeedback(FeedbackEntity entity);
}
