package sort;

public class InsertSort extends Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base b = new InsertSort();
		b.test(10);
		
	}
	
	@Override
	protected void sort(int[] toSort) {
		for (int i = 1; i < toSort.length; i++) {
			for (int j = i; j > 0 && toSort[j - 1] > toSort[j]; j--) {
				swap(toSort, j - 1, j);
			}
		}
	}
	
	
	protected void sort_(int[] toSort) {
		for (int i = 0; i < toSort.length; i++) {
			for (int j = i; j > 0; j--) {
				if (toSort[j - 1] > toSort[j]) {
					swap(toSort, j - 1, j);
				}
			}
		}
	}
}
