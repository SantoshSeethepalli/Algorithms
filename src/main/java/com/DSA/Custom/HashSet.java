package com.DSA.Custom;

import java.util.HashMap;

public class HashSet {

    private static class Node {
        int data;
        Node next;

        Node(int key) {
            this.data = key;
            this.next = null;
        }
    }

    Node[] hashSet;
    int size;

    public HashSet() {

        size = 10_000;
        hashSet = new Node[size];
    }

    int getIndex(int key) {

        return key % size;
    }

    public void add(int key) {

        int idx = getIndex(key);

        if (hashSet[idx] == null) {

            hashSet[idx] = new Node(key);
            return;
        }

        Node currentChain = hashSet[idx];

        while(currentChain != null) {

            if(currentChain.data == key) return;

            currentChain = currentChain.next;
        }

        Node newNode = new Node(key);
        newNode.next = hashSet[idx];
        hashSet[idx] = newNode;
    }

    public void remove(int key) {

        int idx = getIndex(key);

        Node previous = null;
        Node currentChain = hashSet[idx];

        while(currentChain != null) {

            if(currentChain.data == key) {

                if(previous == null) hashSet[idx] = currentChain.next;
                else previous.next = currentChain.next;
            }

            previous = currentChain;
            currentChain = currentChain.next;
        }
    }

    public boolean contains(int key) {

        int idx = getIndex(key);

        Node currentChain = hashSet[idx];

        while(currentChain != null) {

            if(currentChain.data == key) return true;

            currentChain = currentChain.next;
        }

        return false;
    }
}