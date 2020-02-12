package com.chs;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/2/11<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/2/11            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        addNode(result, root);
        return result;
    }

    public void addNode(List<Integer> result, TreeNode treeNode) {

        if (treeNode != null) {
            addNode(result, treeNode.left);
            result.add(treeNode.val);
            addNode(result, treeNode.right);
        }
    }
}
