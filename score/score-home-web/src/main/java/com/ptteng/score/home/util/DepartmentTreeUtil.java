package com.ptteng.score.home.util;



import com.ptteng.score.home.constant.ConstantItem;
import com.ptteng.score.home.model.Department;
import com.ptteng.score.home.responseStructure.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Title:    score
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/10/22
 */
public class DepartmentTreeUtil {

    public static List<Node> recursionQuery(List<Department> parentlist, List<Department> allList) {
        /**
         *@Author hfismyangel@163.com
         *@Description:递归生成树形结构部门分级
         *@Date: 20:19 2017/9/28
         * @param parentlist
         * @param allList
         */
        List resultList = new ArrayList<>();
        for (Department department : parentlist) {
            //如果是父节点。DB中由isParent字段，从pojo中获取参数判断是否父节点
            if (department.getIsParent() == 1) {
                Node node = new Node();
                //详见json结构体，
                node.setId(department.getId());
                node.setName(department.getName());
                List<Department> list1 = new ArrayList<>();
                for (Department department1 : allList) {
                    if (department.getId() == department1.getParentId().longValue()) {
                        list1.add(department1);
                    }
                }
                node.setNode(recursionQuery(list1, allList));
                //把node添加到列表
                resultList.add(node);
            } else {
                //如果是叶子节点
                Node node = new Node();
                node.setId(department.getId());
                node.setName(department.getName());
                resultList.add(node);
            }
        }
        return resultList;
    }

    public static Set<Long> getAllTrueId(Long parentId, List<Department> list) {
        /**
         *@Description:递归遍历所有子部门
         *@Date: 20:19 2017/9/28
         * @param parentId
         * @param list
         */
        Set<Long> longs = new HashSet<>();
        longs.add(parentId);
        Set<Long> allTrueId = new HashSet<>();
        //循环递归
        for (Department department : list) {
            if (department.getParentId() == parentId.longValue()) {
                if (department.getIsParent() == ConstantItem.ONE) {
                    allTrueId = getAllTrueId(department.getId(), list);
                }
                longs.add(department.getId());
                longs.addAll(allTrueId);
            }
        }
        return longs;
    }
}
