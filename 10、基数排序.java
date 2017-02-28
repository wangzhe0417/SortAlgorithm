/**
 * @author wangzhe
 *
 * 基数排序
 * 基数排序（radix sorting）将所有待比较数值(正整数)统一为同样的数位长度，
 * 数位较短的数前面补零。 然后 从最低位开始，依次进行一次排序。这样从最低位排
 * 序一直到最高位排序完成以后， 数列就变成一个有序序列
 */

public class RadixSort {
    public static void radixSort(int[] arr) {
        if(arr == null && arr.length == 0)
            return ;
        int maxBit = getMaxBit(arr);

        for(int i=1; i<=maxBit; i++) {

            List<List<Integer>> buf = distribute(arr, i); //分配
            collecte(arr, buf); //收集
        }

    }

    //分配
    public static List<List<Integer>> distribute(int[] arr, int iBit) {
        List<List<Integer>> buf = new ArrayList<List<Integer>>();
        for(int j=0; j<10; j++) {
            buf.add(new LinkedList<Integer>());
        }
        for(int i=0; i<arr.length; i++) {
            buf.get(getNBit(arr[i], iBit)).add(arr[i]);
        }
        return buf;
    }

    //收集
    public static void collecte(int[] arr, List<List<Integer>> buf) {
        int k = 0;
        for(List<Integer> bucket : buf) {
            for(int ele : bucket) {
                arr[k++] = ele;
            }
        }

    }

    //获取最大位数
    public static int getMaxBit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int ele : arr) {
            int len = (ele+"").length();
            if(len > max)
                max = len;
        }
        return max;
    }

    //获取x的第n位，如果没有则为0.
    public static int getNBit(int x, int n) {

        String sx = x + "";
        if(sx.length() < n)
            return 0;
        else
            return sx.charAt(sx.length()-n) - '0';
    }

}