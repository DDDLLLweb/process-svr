package com.process.auth.app.sys.entity;

import com.process.common.domain.PsEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

@Data
@EqualsAndHashCode(callSuper = true)
public class PsAppMenuEntity extends PsEntity {

    /**
     * 菜单ID - S_MENUS.MENU_ID
     */
    private String menuId;

    /**
     * 父菜单ID(NULL表示顶级菜单) - S_MENUS.UPPER_ID
     */
    private String upperId;

    /**
     * 打开画面的URI(一级菜单为空) - S_MENUS.MENU_URI
     */
    private String menuUri;

    /**
     * 菜单图标(FONTAWESOME) - S_MENUS.MENU_ICO
     */
    private String menuIco;

    /**
     * 菜单文字 - S_MENUS.MENU_LABEL
     */
    private String menuLabel;

    /**
     * 菜单类型 - S_MENUS.MENU_TYPE
     */
    private String menuType;

    /**
     * 子菜单
     */
    private List<PsAppMenuEntity> children;

    /**
     * 将菜单列表封装成树列表
     *
     * @param items 组织列表
     * @return 树列表
     */
    public static List<PsAppMenuEntity> toTrees(List<PsAppMenuEntity> items) {
        final PsAppMenuEntity root = new PsAppMenuEntity();
        Map<String, PsAppMenuEntity> treeMap = items.stream()
                .collect(Collectors.toMap(PsAppMenuEntity::getMenuId, identity()));
        items.stream().filter(item -> item.getUpperId() != null).collect(Collectors.toList()).forEach(item -> treeMap.getOrDefault(item.getUpperId(), root).children.add(item));
        return root.children;
    }
}
