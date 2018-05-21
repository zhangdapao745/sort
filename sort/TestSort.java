package sort;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class TestSort {
	
	static int[] test1;
    static int[] test2;
    static int[] test3;
    static int[] test4;
    static int size = 5000;
    @Before
	public void beforeTest(){
		test1 = new int[size];
	    test2 = new int[size];
	    test3 = new int[size];
	    //正序
        for(int i = 0; i < size;i++){
            test1[i] = i;
        }
        //倒序
        for(int i = 0; i < size;i++){
            test2[i] = size - i;
        }
        //乱序,随机
        for(int i = 0;i < size;i++){
            test3[i] = (int) (Math.random() * size);
        }
	}

	@Test
	public void sevenSortTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		int[] test = test1;
		Mysort.testSort("insertionSort", Arrays.copyOf(test, size));
		Mysort.testSort("shellSort", Arrays.copyOf(test, size));
		Mysort.testSort("selectionSort", Arrays.copyOf(test, size));
		Mysort.testSort("bubbleSort", Arrays.copyOf(test, size));
		Mysort.testSort("quickSort", Arrays.copyOf(test, size));
		Mysort.testSort("mergeSort", Arrays.copyOf(test, size));
		Mysort.testSort("heapSort", Arrays.copyOf(test, size));
		Mysort.testSort("heapSortPriority", Arrays.copyOf(test, size));
		
		test = test2;
		Mysort.testSort("insertionSort", Arrays.copyOf(test, size));
		Mysort.testSort("shellSort", Arrays.copyOf(test, size));
		Mysort.testSort("selectionSort", Arrays.copyOf(test, size));
		Mysort.testSort("bubbleSort", Arrays.copyOf(test, size));
		Mysort.testSort("quickSort", Arrays.copyOf(test, size));
		Mysort.testSort("mergeSort", Arrays.copyOf(test, size));
		Mysort.testSort("heapSort", Arrays.copyOf(test, size));
		Mysort.testSort("heapSortPriority", Arrays.copyOf(test, size));
		
		test = test3;
		Mysort.testSort("insertionSort", Arrays.copyOf(test, size));
		Mysort.testSort("shellSort", Arrays.copyOf(test, size));
		Mysort.testSort("selectionSort", Arrays.copyOf(test, size));
		Mysort.testSort("bubbleSort", Arrays.copyOf(test, size));
		Mysort.testSort("quickSort", Arrays.copyOf(test, size));
		Mysort.testSort("mergeSort", Arrays.copyOf(test, size));
		Mysort.testSort("heapSort", Arrays.copyOf(test, size));
		Mysort.testSort("heapSortPriority", Arrays.copyOf(test, size));
	}
	
	/**
	 * 检测排序正确性
	 */
	@Test
	public void onlyCheck(){
		int[] a = {18,17,0,4,10,10,15,16,12,18,18,0,11,2,19,5,5,12,17,11};
		Mysort.heapSortWrong(a);
//		Mysort.heapSort(a);
//		Mysort.shellSort(a);
		print(a);
	}
	
	public static void print(int a[]){
		for(int i = 0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}