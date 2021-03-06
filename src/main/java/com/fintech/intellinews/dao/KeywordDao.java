package com.fintech.intellinews.dao;

import com.fintech.intellinews.base.BaseDao;
import com.fintech.intellinews.entity.KeywordEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeywordDao extends BaseDao<KeywordEntity> {
    /**
     * 获取热门关键字
     *
     * @return 关键字列表
     */
    List<KeywordEntity> listHotKeywords();

    /**
     * 更新关键字热度
     *
     * @param keyword 关键字
     * @return 影响的行数
     */
    int updateKeywordCount(String keyword);
}