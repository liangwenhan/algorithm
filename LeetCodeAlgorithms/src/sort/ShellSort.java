package sort;

public class ShellSort extends Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base b = new ShellSort();
		b.test(10);
		
	}
	
	
	
	@Override
	protected void sort(int[] toSort) {
		
		int step = 1;
		while ((step * 3 + 1) < toSort.length) {
			step = step * 3 + 1;
		}
		while (step >= 1) {
			for (int i = step; i < toSort.length; i++) {
				for (int j = i; j > 0 && toSort[j - 1] > toSort[j]; j -= step) {
					swap(toSort, j - 1, j);
				}
			}
			step /= 3;
		}		
	}
}
