/**
 * @author wangzhe
 *
 * 堆排序
 * 堆排序是一种树形选择排序，是对直接选择排序的有效改进。
 * 
 * 初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个堆，
 * 时堆的根节点的数最大。然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调
 * 整使之成为堆。依此类推，直到只有两个节点的堆，并对 它们作交换，最后得到有n个节点的有
 * 序序列。
 * 从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。
 * 所以堆排序有两个函数组成。一是建堆的函数，二是反复调用建堆函数实现排序的函数。
 *
 * 堆排序的时间复杂度也是O(nlogn)
 */

//大顶堆
public class HeapSort {
	public static void heapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];

        for(int i=2*start+1; i<=end; i*=2) {
            //左右孩子的节点分别为2*i+1,2*i+2

            //选择出左右孩子较小的下标
            if(i < end && arr[i] < arr[i+1]) {
                i ++; 
            }
            if(temp >= arr[i]) {
                break; //已经为大顶堆，=保持稳定性。
            }
            arr[start] = arr[i]; //将子节点上移
            start = i; //下一轮筛选
        }

        arr[start] = temp; //插入正确的位置
    }

    public static void heapSort(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;

        //建立大顶堆
        for(int i=arr.length/2; i>=0; i--) {
            heapAdjust(arr, i, arr.length-1);
        }

        for(int i=arr.length-1; i>=0; i--) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i-1);
        }

    }

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}