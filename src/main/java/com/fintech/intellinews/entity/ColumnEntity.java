package com.fintech.intellinews.entity;

import com.fintech.intellinews.base.BaseEntity;

/**
 * @author waynechu
 * Created 2017-10-27 13:56
 */
public class ColumnEntity extends BaseEntity {
    /** 专栏id */
    private Long id;
    /** 专栏名称 */
    private String name;
    /** 专栏中文名 */
    private String nameZh;
    /** 专栏缩略图 */
    private String thumbnail;
    /** 专栏描述 */
    private String depict;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }
}
