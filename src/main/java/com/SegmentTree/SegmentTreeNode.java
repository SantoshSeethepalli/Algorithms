package com.SegmentTree;

public class SegmentTreeNode {

    int l, r;
    int sum;

    SegmentTreeNode leftChild;
    SegmentTreeNode rightChild;

    public SegmentTreeNode() {}
    public SegmentTreeNode(int l, int r) {
        this.l = l;
        this.r = r;
    }
}
