package com.fintech.intellinews.entity;

import com.fintech.intellinews.base.BaseEntity;

/**
 * @author wanghao
 * create 2018-03-11 21:39
 **/
public class FeedbackEntity extends BaseEntity{
    private Long id;
    private Long userId;
    private Boolean isRead;
    private String msg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
