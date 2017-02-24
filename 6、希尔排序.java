/**
 * @author wangzhe
 *
 * 希尔排序（缩小增量插入排序）
 * 先将整个待排记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录基本有
 * 序时再对全体记录进行一次直接插入排序。
 * 
 */

public class ShellSort {
	public static void shellSort(int[] array) {
		if (array == null || array.length == 0) 
			return ;
		//每次将步长缩短为原来的一半
		for (int increment = array.length / 2; increment > 0; increment /= 2) {
			for (int i = increment; i < array.length; i++) {
				int temp = array[i];
				for (int j = i; (j >= increment) && (temp < array[j - increment]); j -= increment) {
					array[j] = array[j-increment];
				}
				array[j] = temp;
			}
		}
	}
}