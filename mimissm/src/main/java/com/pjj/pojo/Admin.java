package com.pjj.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2021-09-06 18:29:14
 */
@Data
public class Admin implements Serializable {
    private static final long serialVersionUID = -76349303379475878L;

    private Integer aId;

    private String aName;

    private String aPass;


    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaPass() {
        return aPass;
    }

    public void setaPass(String aPass) {
        this.aPass = aPass;
    }



}
