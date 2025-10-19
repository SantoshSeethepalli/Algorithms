package com.DSA.Custom;

public class HashMap {

    private static class Node {

        int key;
        int value;
        Node next;

        Node(int key, int value) {

            this.key = key;
            this.value = value;
            this.next = null;
        }

        Node(int key) {

            this.key = key;
            this.value = 0;
            this.next = null;
        }
    }

    Node[] hashMap;
    int size;

    public HashMap() {

        size = 10_000;
        hashMap = new Node[size];
    }

    private int getIndex(int key) {

        return key % size;
    }

    public void put(int key, int value) {

        int idx = getIndex(key);

        Node currentChain = hashMap[idx];

        Node temp = currentChain;
        while(temp != null) {

            if(temp.key == key) {

                temp.value = value;
                return;
            }

            temp = temp.next;
        }

        Node newChainHead = new Node(key, value);
        newChainHead.next = currentChain;
        hashMap[idx] = newChainHead;
    }

    public int get(int key) {

        int idx = getIndex(key);

        Node currentChain = hashMap[idx];
        while(currentChain != null) {

            if(currentChain.key == key) return currentChain.value;

            currentChain = currentChain.next;
        }

        return -1;
    }

    public void remove(int key) {

        int idx = getIndex(key);

        Node currentChain = hashMap[idx];
        Node previous = null;

        while(currentChain != null) {

            if(currentChain.key == key) {

                if(previous == null) {

                    hashMap[idx] = currentChain.next;
                } else {

                    previous.next = currentChain.next;
                    currentChain.next = null;
                }
                return;
            }

            previous = currentChain;
            currentChain = currentChain.next;

        }

    }
}
