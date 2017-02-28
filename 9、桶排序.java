/**
 * @author wangzhe
 *
 * 桶排序
 * 桶排序算是计数排序的一种改进和推广，要比计数排序复杂许多。
 * 
 * 桶排序的基本思想：
 *	 假设有一组长度为N的待排关键字序列K[1....n]。首先将这个序列划分成M个的子区间(桶)。
 *	 然后基于某种映射函数 ，将待排序列的关键字k映射到第i个桶中(即桶数组B的下标 i) ，那
 *	 么该关键字k就作为B[i]中的元素(每个桶B[i]都是一组大小为N/M的序列)。接着对每个桶B[i]
 *	 中的所有元素进行比较排序(可以使用快排)。然后依次枚举输出B[0]….B[M]中的全部内容即是
 *	 一个有序序列。bindex=f(key) 其中，bindex 为桶数组B的下标(即第bindex个桶), k为
 *	 待排序列的关键字。桶排序之所以能够高效，其关键在于这个映射函数，它必须做到：如果关键
 *	 字k1 < k2，那么f(k1)<=f(k2)。也就是说B(i)中的最小数据都要大于B(i-1)中最大数据。很
 *	 显然，映射函数的确定与数据本身的特点有很大的关系。
 * 
 * 对N个关键字进行桶排序的时间复杂度分为两个部分：
 * 	1.循环计算每个关键字的桶映射函数，这个时间复杂度是O(N)。
 *	2.利用先进的比较排序算法对每个桶内的所有数据进行排序，其时间复杂度为 ∑ O(Ni*logNi) 。其中Ni 为第i个桶的数据量。
 */

public class BucketSort {

    public static void bucketSort(int[] arr) {
        if(arr == null && arr.length == 0)
            return ;

        int bucketNums = 10; //这里默认为10，规定待排数[0,100)
        List<List<Integer>> buckets = new ArrayList<List<Integer>>(); //桶的索引

        for(int i=0; i<10; i++) {
            buckets.add(new LinkedList<Integer>()); //用链表比较合适
        }

        //划分桶
        for(int i=0; i<arr.length; i++) {
            buckets.get(f(arr[i])).add(arr[i]);
        }

        //对每个桶进行排序
        for(int i=0; i<buckets.size(); i++) {
            if(!buckets.get(i).isEmpty()) {
                Collections.sort(buckets.get(i)); //对每个桶进行快排
            }
        }

        //还原排好序的数组
        int k = 0;
        for(List<Integer> bucket : buckets) {
            for(int ele : bucket) {
                arr[k++] = ele;
            }
        }
    }
    //映射函数
    public static int f(int x) {
        return x / 10;
    }

}