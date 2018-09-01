package com.study.springboot.jpa.dao;

import com.study.springboot.jpa.domin.MenuItemDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author guyun
 * @package com.study.springboot.jpa.dao
 * @class MenuItemResponsity
 * @date 2018/8/1919:02
 * @description
 */
@Repository
public interface MenuItemResponsity extends BaseResponsity<MenuItemDO, Long> {
    @Query("select m from MenuItemDO m order by m.level asc")
    List<MenuItemDO> queryMenuItemList();
}