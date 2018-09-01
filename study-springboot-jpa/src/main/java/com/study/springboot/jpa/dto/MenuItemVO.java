package com.study.springboot.jpa.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author guyun
 * @package com.study.springboot.jpa.domin
 * @class MenuItem
 * @date 2018/8/1918:54
 * @description
 */
@Data
public class MenuItemVO implements Serializable {
    private static final long serialVersionUID = -2884749730176283322L;
    private Long id;

    private String menuCode;

    private String menuName;

    private Long parentId;

    private Integer level;

    private List<MenuItemVO> childs;

    @Override
    public String toString() {
        return "MenuItemVO{" +
                "id=" + id +
                ", menuCode='" + menuCode + '\'' +
                ", menuName='" + menuName + '\'' +
                ", parentId=" + parentId +
                ", level=" + level +
                ", childs=" + childs +
                '}';
    }
}