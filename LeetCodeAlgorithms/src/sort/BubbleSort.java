package sort;

public class BubbleSort extends Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base b = new BubbleSort();
		b.test(10);
		
	}
	
	
	
	
	@Override
	protected void sort(int[] toSort) {
		for (int i = 0; i < toSort.length; i++) {
			for (int j = 0; j < toSort.length - i - 1; j++) {
				if (toSort[j] > toSort[j + 1]) {
					swap(toSort, j + 1, j);
				}
			}
		}
	}
}
