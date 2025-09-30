package com.GFG_MDQs.SegmentTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SegmetTree {

    SegmentTreeNode root;
    List<List<Integer>> levelOrderTreeData;

    public SegmetTree() {
        this.levelOrderTreeData = new ArrayList<>();
    }

    public void build(int[] arr) {

        root = buildSegmentTree(arr, 0, arr.length - 1);
    }
    private SegmentTreeNode buildSegmentTree(int[] arr, int l, int r) {

        SegmentTreeNode node = new SegmentTreeNode(l, r);

        if(l == r) {
            node.sum = arr[l]; // or arr[r]
            return node;
        }

        int mid = l + (r - l) / 2;
        node.leftChild = buildSegmentTree(arr, l, mid);
        node.rightChild = buildSegmentTree(arr, mid + 1, r);

        node.sum = node.leftChild.sum + node.rightChild.sum;

        return node;
    }

    public void printSegmentTreeData() {

        levelOrderTreeData.clear();
        buildListOfTree(root);

        for(List<Integer> level : levelOrderTreeData) {
            System.out.println(level.toString() + " ");
        }
    }

    public void buildListOfTree(SegmentTreeNode root) {

        if(root == null) return;

        Queue<SegmentTreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {

            int currentLevelSize = q.size();
            List<Integer> newLevel = new ArrayList<>();

            while(currentLevelSize > 0) {

                SegmentTreeNode node = q.poll();

                if(node.leftChild != null) q.add(node.leftChild);
                if(node.rightChild != null) q.add(node.rightChild);

                newLevel.add(node.sum);
                currentLevelSize--;
            }

            levelOrderTreeData.add(new ArrayList<>(newLevel));
            newLevel.clear();
        }
    }


    // TODO: complete this by 01-10-2025
    public int raneQuery(SegmentTreeNode node, int left, int right) {
        return 0;
    }

    public void pointUpdate(SegmentTreeNode node, int idx, int value) {

    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};

        SegmetTree tree = new SegmetTree();

        tree.build(arr);
        tree.printSegmentTreeData();
    }
}
