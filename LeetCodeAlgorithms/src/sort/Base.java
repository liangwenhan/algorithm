package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Base {

	public int[] createRandomArray(int max) {
		Random r = new Random(System.currentTimeMillis());
		int length = Math.abs(r.nextInt(max)) + 1;
		int array[] = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = Math.abs(r.nextInt(1000));
		}
		return array;
	}
	
	public void show(int[] tos) {
		for (int i : tos) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public void swap(int[] tos, int i, int j) {
		int tem = tos[i];
		tos[i] = tos[j];
		tos[j] = tem;
	}
	public boolean isSorted(int[] tos) {
		for (int i = 1; i < tos.length; i++) {
			if (tos[i] < tos[i - 1]) {
				return false;
			}
		}
		return true;
	}
	public void debug(int length) {
		Random r = new Random(System.currentTimeMillis());
		int array[] = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = Math.abs(r.nextInt(1000));
		}
		show(array);
		sort(array);
		show(array);
		System.out.println(isSorted(array));
	}
	public boolean test(int times) {
		for (int i = 0; i < times; i++) {
			int toSort[] = createRandomArray(12);
			try {
				
				sort(toSort);
				boolean result = isSorted(toSort);
				if (!result) {
					System.out.println("encounter error:");
					show(toSort);
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
				show(toSort);
			}
			
		}
		return true;
	}
	
	protected void sort(int toSort[]) {
		Arrays.sort(toSort);
	}
	public static void main(String[] args) {
		Base b = new Base();
		b.debug(100000000);
		//Collections.sort(null);
	}

}
