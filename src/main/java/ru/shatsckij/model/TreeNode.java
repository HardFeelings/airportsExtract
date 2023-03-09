package ru.shatsckij.model;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private final char value;
    private int id;
    private List<TreeNode> children;

    public TreeNode(char value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addNode(String data, int id){
        if(data.length() == 0){
            return;
        }
        if (children == null){
            children = new ArrayList<>();
        }
        char c = data.toLowerCase().charAt(0);
        TreeNode child = findNodeByChar(c);
        if(child == null){
            child = new TreeNode(c);
            if(data.length() == 1){
                child.setId(id);
            }
            children.add(child);
        }
        child.addNode(data.substring(1), id);
    }

    public TreeNode findNodeByString(String str){
        if(!containString(str)){
            return null;
        }
        TreeNode current = this;
        for (int i = 0; i < str.length(); i++) {
            current = current.findNodeByChar(str.toLowerCase().charAt(i));
        }
        return current;

    }

    private TreeNode findNodeByChar(char c){
        if(children != null){
            for (TreeNode node : children) {
                if(node.value == c){
                    return node;
                }
            }
        }
        return null;
    }

    public boolean containString(String str){
        TreeNode current = this;
        for (int i = 0; i < str.length(); i++) {
            current = current.findNodeByChar(str.toLowerCase().charAt(i));
            if(current == null){
                return false;
            }
        }
        return true;
    }
}
