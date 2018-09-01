package com.study.springboot.jpa.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.study.springboot.jpa.dao.MenuItemResponsity;
import com.study.springboot.jpa.domin.MenuItemDO;
import com.study.springboot.jpa.dto.MenuItemVO;
import com.study.springboot.jpa.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guyun
 * @package com.study.springboot.jpa.service.impl
 * @class MenuItemServiceImpl
 * @date 2018/8/1919:04
 * @description
 */
@Service(value = "menuItemService")
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemResponsity menuItemResponsity;

    @Override
    public String processMenuItem() {
        List<MenuItemDO> menuItemDOList = menuItemResponsity.queryMenuItemList();

        List<MenuItemVO> menuItemVOS = new ArrayList<>();

        for (MenuItemDO menuItemDO : menuItemDOList) {
            MenuItemVO newMenuItemVO = new MenuItemVO();

            newMenuItemVO.setParentId(menuItemDO.getParentId());
            newMenuItemVO.setMenuCode(menuItemDO.getMenuCode());
            newMenuItemVO.setMenuName(menuItemDO.getMenuName());
            newMenuItemVO.setId(menuItemDO.getId());
            newMenuItemVO.setLevel(menuItemDO.getLevel());

            if (menuItemDO.getParentId() == null) {
                menuItemVOS.add(newMenuItemVO);
            } else {
                tryAgain(menuItemVOS, newMenuItemVO);
            }
        }
        return JSONArray.toJSONString(menuItemVOS);
    }

    /**
     * 下级
     *
     * @param menuItemVOS
     * @param newMenuItemVO
     */
    private void tryAgain(List<MenuItemVO> menuItemVOS, MenuItemVO newMenuItemVO) {

        for (MenuItemVO menuItemVO : menuItemVOS) {
            if (menuItemVO.getId() == newMenuItemVO.getParentId()) {
                if (CollectionUtils.isEmpty(menuItemVO.getChilds())) {
                    menuItemVO.setChilds(new ArrayList<>());
                }
                menuItemVO.getChilds().add(newMenuItemVO);
                return;
            }
            if (CollectionUtils.isEmpty(menuItemVO.getChilds())) {
                menuItemVO.setChilds(new ArrayList<>());
            }

            tryAgain(menuItemVO.getChilds(), newMenuItemVO); // 递归
        }
    }
}