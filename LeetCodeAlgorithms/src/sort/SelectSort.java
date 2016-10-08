package sort;

public class SelectSort extends Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base b = new SelectSort();
		b.test(10);
		
	}
	
	@Override
	protected void sort(int[] toSort) {
		for (int i = 0; i < toSort.length; i++) {
			int minIdx = i;
			for (int j = i + 1; j < toSort.length; j++) {
				if (toSort[j] < toSort[minIdx]) {
					minIdx = j;
				}
			}
			swap(toSort, i, minIdx);
		}
	}
}
