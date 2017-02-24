/**
 * @author wangzhe
 *
 * 插入排序
 * 从第一个元素开始，该元素可以认为已经被排序
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描 
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置  
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置  
 * 将新元素插入到该位置中  
 *
 * 简单插入排序的时间复杂度也是O(n^2)
 */

public class InsertSort {
	public static void insertSort(int[] array) {
		if(array == null || array.length == 0)
			return ;
		for (int i = 1; i < array.length; i++) {
			int j = i;
			int temp = array[i];
			for(int j = i; (j > 0) && (temp < array[j-1]); j--) //比较并将大于target的数后移
				array[j] = array[j-1];
			//将target插入合适位置
			array[j] = temp;
		}
	}
}