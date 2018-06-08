package com.kevin.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/7
 * <p>
 * <p>
 * id：节点的 id，它对于加载远程数据很重要。
 * text：要显示的节点文本。
 * state：节点状态，'open' 或 'closed'，默认是 'open'。当设置为 'closed' 时，该节点有子节点，并且将从远程站点加载它们。
 * checked：指示节点是否被选中。
 * attributes：给一个节点添加的自定义属性。
 * children：定义了一些子节点的节点数组
 */
public class Tree {
    private String id;//菜单ID
    private String text;//菜单名称
    private boolean checked;//是否被选中
    private List<Tree> children;//子菜单

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<Tree> getChildren() {
        if (null == children) {
            children = new ArrayList<Tree>();
        }
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }
}
