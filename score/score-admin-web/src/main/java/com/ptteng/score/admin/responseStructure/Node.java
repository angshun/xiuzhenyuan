package com.ptteng.score.admin.responseStructure;

import java.util.List;

/**
 * Title:    score
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/9/28
 */
public class Node {
    /**
    *@Author hfismyangel@163.com
    *@Description:部门树节点实体
    *@Date: 20:08 2017/10/13
       * @param null
    */
    private Long id;
    private String name;
    private List<Node> node;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getNode() {
        return node;
    }

    public void setNode(List<Node> node) {
        this.node = node;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", node=" + node +
                '}';
    }
}
