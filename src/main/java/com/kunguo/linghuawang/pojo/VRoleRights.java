package com.kunguo.linghuawang.pojo;

import java.io.Serializable;

/**
 * @author zhaomaohui
 * @ClassName: VRoleRights
 * @Description:
 * @date 2020/5/21
 */
public class VRoleRights implements Serializable {

    public int id;
    public int roleId;
    public int rightId;
    public String name;
    public String controller;
    public String desc;
    public int isIntercept;
    public int parentId;
    public int indexs;
    public String roleName;
    public String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getRightId() {
        return rightId;
    }

    public void setRightId(int rightId) {
        this.rightId = rightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getIsIntercept() {
        return isIntercept;
    }

    public void setIsIntercept(int isIntercept) {
        this.isIntercept = isIntercept;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getIndexs() {
        return indexs;
    }

    public void setIndexs(int indexs) {
        this.indexs = indexs;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
