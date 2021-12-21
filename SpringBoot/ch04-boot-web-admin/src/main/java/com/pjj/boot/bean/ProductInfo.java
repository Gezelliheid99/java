package com.pjj.boot.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName product_info
 */
@TableName(value ="product_info")
public class ProductInfo implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer pId;

    /**
     * 
     */
    private String pName;

    /**
     * 
     */
    private String pContent;

    /**
     * 
     */
    private Integer pPrice;

    /**
     * 
     */
    private String pImage;

    /**
     * 
     */
    private Integer pNumber;

    /**
     * 
     */
    private Integer typeId;

    /**
     * 
     */
    private Date pDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getpId() {
        return pId;
    }

    /**
     * 
     */
    public void setpId(Integer pId) {
        this.pId = pId;
    }

    /**
     * 
     */
    public String getpName() {
        return pName;
    }

    /**
     * 
     */
    public void setpName(String pName) {
        this.pName = pName;
    }

    /**
     * 
     */
    public String getpContent() {
        return pContent;
    }

    /**
     * 
     */
    public void setpContent(String pContent) {
        this.pContent = pContent;
    }

    /**
     * 
     */
    public Integer getpPrice() {
        return pPrice;
    }

    /**
     * 
     */
    public void setpPrice(Integer pPrice) {
        this.pPrice = pPrice;
    }

    /**
     * 
     */
    public String getpImage() {
        return pImage;
    }

    /**
     * 
     */
    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    /**
     * 
     */
    public Integer getpNumber() {
        return pNumber;
    }

    /**
     * 
     */
    public void setpNumber(Integer pNumber) {
        this.pNumber = pNumber;
    }

    /**
     * 
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * 
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * 
     */
    public Date getpDate() {
        return pDate;
    }

    /**
     * 
     */
    public void setpDate(Date pDate) {
        this.pDate = pDate;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ProductInfo other = (ProductInfo) that;
        return (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.getpName() == null ? other.getpName() == null : this.getpName().equals(other.getpName()))
            && (this.getpContent() == null ? other.getpContent() == null : this.getpContent().equals(other.getpContent()))
            && (this.getpPrice() == null ? other.getpPrice() == null : this.getpPrice().equals(other.getpPrice()))
            && (this.getpImage() == null ? other.getpImage() == null : this.getpImage().equals(other.getpImage()))
            && (this.getpNumber() == null ? other.getpNumber() == null : this.getpNumber().equals(other.getpNumber()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getpDate() == null ? other.getpDate() == null : this.getpDate().equals(other.getpDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((getpName() == null) ? 0 : getpName().hashCode());
        result = prime * result + ((getpContent() == null) ? 0 : getpContent().hashCode());
        result = prime * result + ((getpPrice() == null) ? 0 : getpPrice().hashCode());
        result = prime * result + ((getpImage() == null) ? 0 : getpImage().hashCode());
        result = prime * result + ((getpNumber() == null) ? 0 : getpNumber().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getpDate() == null) ? 0 : getpDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pId=").append(pId);
        sb.append(", pName=").append(pName);
        sb.append(", pContent=").append(pContent);
        sb.append(", pPrice=").append(pPrice);
        sb.append(", pImage=").append(pImage);
        sb.append(", pNumber=").append(pNumber);
        sb.append(", typeId=").append(typeId);
        sb.append(", pDate=").append(pDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}