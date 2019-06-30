package com.lpp.domain;

public class Permission {
    private Integer id;
    private String permissionDesc;
    private String permissionTag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }

    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
    }

    public String getPermissionTag() {
        return permissionTag;
    }

    public void setPermissionTag(String permissionTag) {
        this.permissionTag = permissionTag;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionDesc='" + permissionDesc + '\'' +
                ", permissionTag='" + permissionTag + '\'' +
                '}';
    }
}
