/*
this program solves the next permutation problem.
all code written by christian souders for CSCD 316, Winter 2016
I make my
 */
package com.company;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] perm1 = new int[] {1, 2, 3, 4};
        //int [] nextPerm = null;
        do{
            perm1 = nextPermutaion(perm1);
            if(perm1!= null) {
                System.out.println("Next Permutation");
                System.out.println(Arrays.toString(perm1));
            }
        }while(perm1!= null);

        perm1 = new int[] { 5, 2, 1 ,3 , 4};
        perm1 = nextPermutaion(perm1);
        System.out.println("Next Permutation");
        System.out.println(Arrays.toString(perm1));

        perm1 = new int[] {10, 9, 8, 7,6, 5, 4, 3, 1, 2};
        perm1 = nextPermutaion(perm1);
        System.out.println("Next Permutation");
        System.out.println(Arrays.toString(perm1));

        perm1 = new int[] {9, 10, 8 ,7, 6, 5, 4, 3, 2,1};
        perm1 = nextPermutaion(perm1);
        System.out.println("Next Permutation");
        System.out.println(Arrays.toString(perm1));

        perm1 = new int[] {1};
        perm1 = nextPermutaion(perm1);
        System.out.println("Next Permutation");
        System.out.println(Arrays.toString(perm1));

        perm1 = new int[] {1, 2};
        perm1 = nextPermutaion(perm1);
        System.out.println("Next Permutation");
        System.out.println(Arrays.toString(perm1));

        perm1 = new int[] {2, 1};
        perm1 = nextPermutaion(perm1);
        System.out.println("Next Permutation");
        System.out.println(Arrays.toString(perm1));

    }


    public static int[] nextPermutaion(int[] perm)
    {
        System.out.println("Initial Permutation: ");
        System.out.println(Arrays.toString(perm));
        int length = perm.length;
        if(length <= 1)
        {
            return null;
        }
        int indexA, indexB;
        indexA = length-1;
        indexB = length-2;
        if(perm[indexA] > perm[indexB])
        {
            int hold = perm[indexA];
            perm[indexA] = perm[indexB];
            perm[indexB] = hold;
            return perm;
        }
        else
        if(length > 2)
        {
            boolean moved = false;
            int tar;
            tar = indexB -1;
            int[] newSub= null;
            while(newSub == null && tar != -1)
            {
                newSub = findNextLargest(perm, tar);
                if(newSub == null)
                {
                    tar--;
                }
            }
            return newSub;


        }



        return null;
    }


    public static  int [] findNextLargest(int[] arr, int target)
    {
        int nextLargest = -1;
        int diff = 0;
        int tarDiff = 0;
        for(int i = target+1; i < arr.length; i ++)
        {
            tarDiff = arr[i] - arr[target];
            if(diff == 0 && tarDiff > 0)
            {
                diff = tarDiff;
                nextLargest = i;
            }
            else
            {
                if(tarDiff < diff && tarDiff > 0)
                {
                    diff = tarDiff;
                    nextLargest = i;
                }
            }
        }
        if(nextLargest == -1)
            return null;


        int hold = arr[target];
        arr[target] = arr[nextLargest];
        arr[nextLargest] = hold;

        Arrays.sort(arr, target+1, arr.length);
        return arr;
    }
}
