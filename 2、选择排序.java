/**
 * @author wangzhe
 *
 * 选择排序
 * 在未排序序列中找到最小元素，并与待排序列的首位进行交换。
 * 选择排序可以看成冒泡排序的优化，因为其目的相同，只是选择排序只有在确定了最小数的
 * 前提下才进行交换，大大减少了交换的次数。
 *
 * 选择排序的时间复杂度为O(n^2)                 
 */

public class SelectSort {
	public static void selectSort(int [] arr) {
		if(arr.length == 0 || arr == null)
			return ;
		int minIndex = 0;
		for(int i = 0; i < arr.length-1; i++) {
			minIndex = i;
			for (int j = i+1; j < arr.length-i-1; j++) {
				if (arr[minIndex] > arr[j])
					minIndex = j;
			}
			if(minIndex != i)
				swap(arr, i, minIndex);
		}
	}

	public void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}