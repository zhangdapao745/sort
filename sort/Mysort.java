package sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.PriorityQueue;

public class Mysort {
	
	/**
	 * 测试排序时间
	 * @param methodName
	 * @param a
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static void testSort(String methodName,int a[]) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Method method = Mysort.class.getMethod(methodName, int[].class);
		long startTime=System.nanoTime();
		method.invoke(null, a);
        long endTime=System.nanoTime();
        System.out.println("time:" + (endTime-startTime)+"ns\t"+ methodName + "\t");
	}
	/**
	 * 直接插入排序
	 * 
	 * @param array
	 */
	public static void insertionSort(int[] array) {
		int temp,j;
		for (int i = 0; i < array.length; i++) {
			temp = array[i];
			for (j = i; j > 0 && temp<array[j-1]; j--) {
				array[j] = array[j - 1];
			}
			array[j] = temp;
		}
	}

	/**
	 * 希尔排序
	 * 
	 * @param array
	 */
	public static void shellSort(int[] array) {
		int temp,j;
		for (int d = array.length / 2; d >= 1; d /= 2) {
			for (int i = 0; i < array.length; i++) {
				temp = array[i];
				for (j = i; j >= d && temp<array[j-d]; j -= d) {
					array[j] = array[j - d];
				}
				array[j] = temp;
			}
		}
	}

	/**
	 * 选择排序
	 * 
	 * @param array
	 */
	public static void selectionSort(int[] array) {
		int temp, swap;
		for (int i = 0; i < array.length; i++) {
			temp = i;
			for (int j = i; j < array.length; j++) {
				if (array[i] < array[temp]) {
					temp = i;
				}
			}
			swap = array[i];
			array[i] = array[temp];
			array[temp] = swap;
		}
	}
	
	/**
	 * 用PriorityQueue模拟堆排序
	 * @param array
	 */
	public static void heapSortPriority(int[] array) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i = 0;i<array.length;i++){
			queue.add(array[i]);
		}
		for(int i = 0;i<array.length;i++){
			array[i] = queue.poll();
		}
	}
	
	/**
	 * 堆排序
	 * @param array
	 */
	public static void heapSort(int[] array) {
		int swap;
		heaplify(array,array.length - 1);
		swap = array[0];
		array[0] = array[array.length-1];
		array[array.length-1] = swap;
		for(int i = 1;i<array.length;i++){
			siftDown(array, array.length -i-1, 0);
			
			swap = array[0];
			array[0] = array[array.length - i-1];
			array[array.length - i-1] = swap;
		}
	}
	
	/**
	 * 堆排序每次都建堆（on^2）
	 * 
	 * @param array
	 */
	public static void heapSortWrong(int[] array) {
		int swap;
		for(int i = 0;i<array.length;i++){
			heaplify(array, array.length - i-1);
			
			swap = array[0];
			array[0] = array[array.length - i-1];
			array[array.length - i-1] = swap;
		}
	}
	
	/**
	 * 建堆过程
	 * @param array
	 * @param size
	 */
	public static void heaplify(int[] array,int size){
		for(int i = (size-1)/2;i>=0;i--){//从最后一个子节点的父节点开始下沉
			siftDown(array, size, i);
		}
	}

	/**
	 * 对第parent个元素进行下沉调整
	 * @param array
	 * @param size
	 * @param parent
	 */
	public static void siftDown(int[] array,int size,int parent) {
		int swap,big;
		while(size >= (parent*2)+1){//如果存在左子节点
			big = (parent*2)+1;
			if((parent*2)+2<=size && array[big] < array[big+1]){//存在右子节点
				big++;
			}
			if(array[big] >array[parent]){
				swap = array[big];
				array[big] = array[parent];
				array[parent] = swap;
				
				parent = big;
			}else {
				break;
			}
		}
	}
	/**
	 * 冒泡排序
	 * 
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		int swap;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					swap = array[j];
					array[j] = array[j + 1];
					array[j + 1] = swap;
				}
			}
		}
	}

	/**
	 * 快速排序
	 * 
	 * @param array
	 */
	public static void quickSort(int[] array) {
		qSort(array, 0, array.length - 1);
	}
	
	public static void qSort(int[] array, int l, int r) {
		if (l < r) {
			int ll = l;
			int rr = r;
			int x = array[ll];
			while (ll < rr) {
				while (array[rr] >= x && ll < rr)
					rr--;
				array[ll] = array[rr];
				while (array[ll] <= x && ll < rr)
					ll++;
				array[rr] = array[ll];
			}
			array[ll] = x;
			qSort(array, l, ll-1);
			qSort(array, ll+1, rr);
		}
	}

	/**
	 * 归并排序
	 * 
	 * @param array
	 */
	public static void mergeSort(int[] array) {
		copy = new int[array.length];
		mSort(array, 0, array.length-1);
	}
	
	public static void mSort(int[] array,int l,int r){
		if(l<r){
			int mid = (l+r)/2;
			mSort(array, l, mid);
			mSort(array, mid+1, r);
			merge(array, l, mid, r);
		}
	}
	static int[] copy;
	public static void merge(int[] array,int l,int mid,int r){//合并
		int i = l,j = mid+1;
		for(int k = l;k<=r;k++){
			copy[k] = array[k];
		}
		
		for(int k = l; k<=r;k++){
			if(i>mid){
				array[k] = copy[j++];
			}else if (j>r) {
				array[k] = copy[i++];
			}else if (copy[i] <= copy[j]) {
				array[k] = copy[i++];
			}else {
				array[k] = copy[j++];
			}
		}
	}
}
