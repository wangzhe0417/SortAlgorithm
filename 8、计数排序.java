/**
 * @author wangzhe
 *
 * 计数排序
 * 待排序的数要满足一定的范围的整数，比如 [0~100]，[10000~19999] 这样的数据，
 * 而且计数排序需要比较多的辅助空间，仅适用于数据比较集中的情况。
 *
 * 基本思想是：对每一个输入的元素arr[i]，确定小于 arr[i] 的元素个数。
 * 需要三个数组:
 *    待排序数组 int[] arr = new int[]{4,3,6,3,5,1};
 *    辅助计数数组 int[] help = new int[max - min + 1]; //该数组大小为待排序数组中的最大值减最小值+1
 *    输出数组 int[] res = new int[arr.length];
 *
 * 1.建一个长度为K+1的的数组C，里面的每一个元素初始都置为0(Java里面默认就是0)。
 * 2.遍历待排序的数组，计算其中的每一个元素出现的次数，比如一个key为i的元素出现了3次，那么C[i]=3。
 * 3.累加C数组，获得元素的排位，从0开始遍历C, C[i+1]=C[i]+C[i-1]
 * 4.建一个临时数组T，长度与待排序数组一样。从数组末尾遍历待排序数组，把元素都安排到T里面，
 *   直接从C里面就可以得到元素的具体位置， 不过记得每处理过一个元素之后都要把C里面对应位置的计数减1。
 * 
 * 计数排序的时间复杂度也是O(n)，稳定排序算法。
 */

public class CountSort {

    public static void countSort(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;

        int max = max(arr);

        int[] count = new int[max+1];
        Arrays.fill(count, 0);

        for(int i=0; i<arr.length; i++) {
            count[arr[i]] ++;
        }

        int k = 0;
        for(int i=0; i<=max; i++) {
            for(int j=0; j<count[i]; j++) {
                arr[k++] = i;
            }
        }

    }

    public static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int ele : arr) {
            if(ele > max)
                max = ele;
        }

        return max;
    }

}