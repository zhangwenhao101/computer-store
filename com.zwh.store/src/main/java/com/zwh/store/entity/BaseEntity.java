package com.zwh.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author zwh
 * 作为实体类的基类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable {


    private String createdUser;//创建人
    private Date createdTime;//创建时间
    private String modifiedUser;//最后修改人
    private Date modifiedTime;//最后修改时间

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;

        if (!Objects.equals(createdUser, that.createdUser)) return false;
        if (!Objects.equals(createdTime, that.createdTime)) return false;
        if (!Objects.equals(modifiedUser, that.modifiedUser)) return false;
        return Objects.equals(modifiedTime, that.modifiedTime);
    }

    @Override
    public int hashCode() {
        int result = createdUser != null ? createdUser.hashCode() : 0;
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (modifiedUser != null ? modifiedUser.hashCode() : 0);
        result = 31 * result + (modifiedTime != null ? modifiedTime.hashCode() : 0);
        return result;
    }



}
