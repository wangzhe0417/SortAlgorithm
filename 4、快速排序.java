/**
 * @author wangzhe
 *
 * 快速排序
 * 基于分治的思想，是冒泡排序的改进型。
 * 首先在数组中选择一个基准点（该基准点的选取可能影响快速排序的效率，后面讲解选取的方法），
 * 然后分别从数组的两端扫描数组，设两个指示标志（lo指向起始位置，hi指向末尾)，
 * 首先从后半部分开始，如果发现有元素比该基准点的值小，就交换lo和hi位置的值，
 * 然后从前半部分开始扫秒，发现有元素大于基准点的值，就交换lo和hi位置的值，如此往复循环，
 * 直到lo>=hi,然后把基准点的值放到hi这个位置。一次排序就完成了。
 * 以后采用递归的方式分别对前半部分和后半部分排序，当前半部分和后半部分均有序时该数组就自然有序了。 
 *
 * 快速排序的时间复杂度也是O(nlogn)
 */
public class QuickSort {
	//查找基准点所在位置，并划分为左右两半
	public static int partition(int [] array, int low, int high) {
		int key = array[low];//固定基准点的划分方式,数组第一个数
		while(low < high) {
			while(low < high && array[high] >= key) //从后向前扫描，找到小于key的值
				high --;
			array[low] = array[high];
			while(low < high && array[low] <= key)  //从前向后扫描，找到大于key的值
				low ++;
			array[high] = array[low];
		}
		array[high] = key;//跳出循环后low==high
		return high;

	}
	//递归形式的分治排序算法
	public static void quickSort(int[] array, int low, int high) {
		if(low > high)
			return ;
		int keyIndex = partition(array, low, high);
		quickSort(array, low, keyIndex-1);
		quickSort(array, keyIndex+1, high);
	}

	//快速排序调用
	public static void quick(int[] array) {
		if (array != null && array.length != 0) {
			quickSort(array, 0, array.length-1);
		}
	}
}
