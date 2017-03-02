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

    //将元素array[k]自上往下逐步调整树形结构
	public static void heapAdjust(int[] array, int k, int length) {
        //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整,左右孩子的节点分别为2*i+1,2*i+2
        for(int i = 2 * k + 1; i < length; i = 2 * i + 1) {
            //选择出左右孩子较小的下标,i+1<length在前可以排除右孩子不存在而出现的数组下标越界异常
            if(i < length && i+1 < length && array[i] < array[i+1]) {
                i ++; //如果节点的右孩子>左孩子，则取右孩子节点的下标
            }
            if(temp >= array[i]) { //根节点 >=左右子女中关键字较大者，保持稳定
                break; 
            }else {
                swap(array, k, i) //将子节点与根节点交换
                k = i; //【关键】修改k值，以便继续向下调整
            }
        }
    }

    public static void heapSort(int[] array) {
        if(array == null || array.length == 0)
            return ;
        //建堆：从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            heapAdjust(array, i, array.length);
        }
        //排序过程
        for(int i=array.length-1; i>0; i--) {
            swap(array, 0, i);
            heapAdjust(array, 0, i-1);//整理，将剩余的元素整理成堆
        }
    }
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}