package com.pjj.pojo;

import java.io.Serializable;

/**
 * (ProductType)实体类
 *
 * @author makejava
 * @since 2021-09-06 18:29:13
 */
public class ProductType implements Serializable {
    private static final long serialVersionUID = -33700616657165569L;

    private Integer typeId;

    private String typeName;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
