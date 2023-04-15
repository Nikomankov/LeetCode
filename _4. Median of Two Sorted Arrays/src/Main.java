import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2,4,5,6};
        System.out.println(Solution.findMedianSortedArrays1(nums1,nums2));
//        System.out.println(nums1.length);
    }
}

class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.stream(nums1).forEach(list::add);
        Arrays.stream(nums2).forEach(list::add);
        list.sort(Comparator.naturalOrder());
        int middle = list.size()/2;
        return list.size()%2 == 0 ? (list.get(middle-1)*1.0 + list.get(middle))/2 : list.get(middle);
    }

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int l = l1 + l2;
        int[] newArray = new int[l];

        int i =0, j=0, k=0;
        while(i<=l1 & j<=l2){
            if(i==l1){
                while (j<l2) newArray[k++] = nums2[j++];
                break;
            } else if (j==l2) {
                while (i<l1) newArray[k++] = nums1[i++];
                break;
            }

            newArray[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }

        return l%2 == 0 ? (double)(newArray[l/2-1] + newArray[l/2])/2 : newArray[l/2];
    }
}