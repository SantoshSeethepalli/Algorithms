package com.DSA.TUF.Arrays.module_3;

import java.util.*;

public class LeadersInAnArray {

    public List<Integer> findLeaders(int[] arr) {

        int n = arr.length;
        int previousLeader = arr[n  -1];
        List<Integer> leaders = new ArrayList<>();
        leaders.add(previousLeader);

        for(int idx = n - 2; idx >= 0; idx--) {

            if(arr[idx] > previousLeader) {

                previousLeader = arr[idx];
                leaders.add(previousLeader);
            }
        }

        Collections.reverse(leaders);
        return leaders;
    }
}
