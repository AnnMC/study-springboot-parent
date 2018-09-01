package com.study.springboot.jpa.domin;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author guyun
 * @package com.study.springboot.jpa.domin
 * @class MenuItem
 * @date 2018/8/1918:54
 * @description
 */
@Data
@Entity
@Table(name = "t_menuitem")
public class MenuItemDO implements Serializable {
    private static final long serialVersionUID = -2884749730176283322L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "menu_code")
    private String menuCode;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "level")
    private Integer level;
    /**
     *
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 是否启用
     */
    private Integer state;
}