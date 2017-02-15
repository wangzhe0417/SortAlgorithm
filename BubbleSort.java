/*************************************************************************
	> File Name: BubbleSort.java
	> Author: wangzhe
	> Mail: 582165168@qq.com 
	> Created Time: 三  1/1 23:11:37 2017
 ************************************************************************/

public class BubbleSort{
	/**
	* 冒泡排序
	* 比较相邻的元素。如果第一个比第二个大，就交换他们两个。  
	* 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。  
	* 针对所有的元素重复以上的步骤，除了最后一个。
	* 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
	*
	* @param numbers 需要排序的整型数组                             
	*/
	public static void bubbleSort(int[] numbers){
		for(int i = 0 ; i < numbers.length -1 ; i ++){
			for(int j = 0 ; j < numbers.length - i -1 ; j ++){
				if(numbers[j] > numbers[j+1]){
					swap(numbers, j, j+1);
				}
			}
		}
	}

	public static void swap(int[] numbers, int x, int y){
		int tmp = numbers[x];
		numbers[x] = numbers[y];
		numbers[y] = tmp;
	}

	public static void main(String[] args){
		int[] a = {4, 2, 1, 6, 3, 6, 0, -5, 1, 1};
		bubbleSort(a);
		for(int i = 0; i < a.length; i ++){
			System.out.printf("%d", a[i]);
		}
	}


}
