/**
 * @author wangzhe
 *
 * 归并排序
 * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，
 * 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
 *
 * 归并排序的时间复杂度也是O(nlogn)，稳定排序方式。
 */

public class MergeSort {
    public static void mergeSort(int [] array) {
        divide(array, 0, array.length-1);
    }

    public static void divide(int [] array, int left, int right) {
        if (left == right) {
            return ;
        }
        int middle = (left + right) / 2;
        divide(array, left, middle);
        divide(array, middle+1, right);
        merge(array, left, middle, right);
    }

    public static void merge(int [] array, int left, int middle, int right) {
        //[left, middle][middle+1, right]
        int[] tempArray = new int[right - left + 1];

        int i = left;
        int j = middle + 1;
        int k = 0;

        //把较小的数先移到tempArray
        while (i <= middle && j <= right) {
            if (array[i] < array[j]) {
                tempArray[k++] = array[i++];
            }else {
                tempArray[k++] = array[j++];
            }
        }
        //把左边或者右边剩余数组移入新数组
        while(i < middle)
            tempArray[k++] = array[i++];
        while(j < right)
            tempArray[k++] = array[j++];

        //一次遍历，新数组覆盖原数组
        for (int m = 0; m < tempArray.length; m++) {
            array[m + left] = tempArray[m];
        }
    }
}