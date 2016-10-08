package sort;

import java.util.Collections;
import java.util.Stack;

public class QuickSort extends Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collections.sort(null);
		Base b = new QuickSort();
		b.test(10);
		//b.debug(10);
	}
	
	
	
	
	@Override
	protected void sort(int[] toSort) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(0);
		stack.add(toSort.length);
		while (!stack.isEmpty()) {
			int end = stack.pop();
			int beg = stack.pop();
			int p = partition(toSort, beg, end);
			if (beg < p - 1) {
				stack.add(beg);
				stack.add(p);
			}
			if (end > p + 2) {
				stack.add(p + 1);
				stack.add(end);
			}
		}
	}
	
	private int partition(int toS[], int beg, int end) {
		end -= 1;
		int pv = beg;
		while (true) {
			while (beg <= end && toS[beg] <= toS[pv]) {
				beg++;
			} 
			while (beg <= end && toS[end] >= toS[pv]) {
				end--;
			}
			if (beg <= end) {
				swap(toS, beg++, end--);
			} else {
				swap(toS, pv, end);
				return end;
			}
		}
	}
}
