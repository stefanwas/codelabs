package com.stefan.training.trees;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
    public static int operations = 0;

    private String value;
    private BinaryTree leftNode;
    private BinaryTree rightNode;

    public BinaryTree(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BinaryTree getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTree leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTree getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTree rightNode) {
        this.rightNode = rightNode;
    }

    public int getTreeDepth() {
        return getDepth(this);
    }

    private int getDepth(BinaryTree tree) {
        if (tree == null) {
             return 0;
        }

        int lDepth = getDepth(tree.leftNode);
        int rDepth = getDepth(tree.rightNode);

        return 1 + Math.max(lDepth, rDepth);
    }

    public void printByLevels() {
        int treeDepth = getTreeDepth();
        for (int i=0; i<treeDepth; i++) {
            String levelNodes = printLevel(this, i);
            System.out.println("L" + i + "=" + levelNodes);
        }
    }

    private String printLevel(BinaryTree tree, int level) {
        operations++;

        if (tree == null) {
            return "";
        }

        if (level == 0) {
            return  tree.value;
        }
        String result = printLevel(tree.leftNode, level - 1) + "," + printLevel(tree.rightNode, level - 1);
        return result;
    }

    public List<String> serialize() {
        List<String> out = serialize(this);
        return out;
    }

    private List<String> serialize(BinaryTree tree) {
        List<String> output = new LinkedList<String>();

        output.add(tree.value);

        if (tree.leftNode != null) {
            output.addAll(serialize(tree.leftNode));
        } else {
            output.add(null);
        }

        if (tree.rightNode != null) {
            output.addAll(serialize(tree.rightNode));
        } else {
            output.add(null);
        }

        return output;
    }

    public static BinaryTree deserialize(List<String> input) {
        BinaryTree tree = new BinaryTree(input.get(0));

        if (input.get(1) != null) {
            tree.leftNode = deserialize(input.subList(1, input.size()));
        } else {
            tree.leftNode = null;
        }

        if (input.get(2) != null) {
            tree.rightNode = deserialize(input.subList(2, input.size()));
        } else {
            tree.rightNode = null;
        }

        return tree;
    }


//    private static class Builder {
//
//        private BinaryTree tree;
//
//        public Builder withLeftNode(String value) {
//
//        }
//
//        public Builder withRightNode(String Value) {
//
//        }
//
//        public BinaryTree build() {
//
//        }
//    }

    public static void main(String[] args) {

        BinaryTree a = new BinaryTree("A"); //0

        BinaryTree b = new BinaryTree("B"); //1
        BinaryTree c = new BinaryTree("C");

        BinaryTree d = new BinaryTree("D"); //2
        BinaryTree e = new BinaryTree("E");
        BinaryTree f = new BinaryTree("F");
        BinaryTree g = new BinaryTree("G");

        BinaryTree h = new BinaryTree("H"); //3

        BinaryTree j = new BinaryTree("J"); //4


        a.setLeftNode(b);
        a.setRightNode(c);

        b.setLeftNode(d);
        b.setRightNode(e);

        c.setLeftNode(f);
        c.setRightNode(g);

        d.setLeftNode(h);

        h.setRightNode(j);

        System.out.println("Depth=" + a.getTreeDepth());

        a.printByLevels();

        System.out.println("Operations=" + BinaryTree.operations);

        List<String> ser = a.serialize();
        System.out.println("SER=" + ser);

        BinaryTree tree = BinaryTree.deserialize(ser);

    }
}
