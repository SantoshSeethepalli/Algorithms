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
    public SegmetTree(int[] arr) {

        build(arr);
        this.levelOrderTreeData = new ArrayList<>();

    }

    public void build(int[] arr) {

        if(arr == null || arr.length == 0) return;

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

    // TODO: complete this by 01-10-2025 - Completed on 01-10-2025
    public int rangeQuery(int left, int right) {

        if(root == null || left > right || left < root.l || root.r < right) {

            return 0;
        }

        return rangeQueryHelper(root, left, right);
    }
    private int rangeQueryHelper(SegmentTreeNode node, int left, int right) {

        // completely out of bounds
        if(right < node.l || left > node.r) return 0;

        // completely in-bounds
        if(left <= node.l && node.r <= right) return node.sum;

        // partially in-bounds -> find the child in completely in-bounds
        return rangeQueryHelper(node.leftChild, left, right) + rangeQueryHelper(node.rightChild, left, right);
    }

    public void rangeUpdate(int left, int right, int value) {

        rangeUpdateHelper(root, left, right, value);
    }
    private void rangeUpdateHelper(SegmentTreeNode node, int left, int right, int value) {

        if (right < node.l || left > node.r) return;

        if(left <= node.l && node.r <= right) {

            // sum of all the elements in the array between these indices
            node.sum += (node.r - node.l + 1) * value;
            return;
        }

        rangeUpdateHelper(node.leftChild, left, right, value);
        rangeUpdateHelper(node.rightChild, left, right, value);

        node.sum = node.leftChild.sum + node.rightChild.sum;
    }

    public void pointUpdate(int idx, int value) {

        if(root == null || idx < root.l ||root.r < idx) {

            return;
        }

        pointUpdateHelper(root, idx, value);
    }
    private void pointUpdateHelper(SegmentTreeNode node, int idx, int value) {

        // if leaf node(target idx node) update th value
        if(node.l == node.r) {
            node.sum = value;
            return;
        }

        int mid = node.l + (node.r - node.l) / 2;
        if(idx <= mid) {

            pointUpdateHelper(node.leftChild, idx, value);
        } else {

            pointUpdateHelper(node.rightChild, idx, value);
        }


        // recalculate the parent sum while traversing back
        node.sum = node.leftChild.sum + node.rightChild.sum;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};

        SegmetTree tree = new SegmetTree();

        tree.build(arr);
        tree.printSegmentTreeData();
        System.out.println(tree.rangeQuery(1, 6));
        tree.pointUpdate(0, 10);
        tree.printSegmentTreeData();

    }
}
