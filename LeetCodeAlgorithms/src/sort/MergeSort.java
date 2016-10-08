package sort;

import java.util.Arrays;

public class MergeSort extends Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base b = new MergeSort();
		b.test(100);
		//b.debug(4);
		
	}
	
	//distance指已经排序好的最长的数据的元素的个数
	private int merge(int beg, int distance, int toSort[], int swp[], int writePoint) {
		int end, beg2, end2;
		beg2 = end = Math.min(beg + distance, toSort.length);
		end2 = Math.min(beg2 + distance, toSort.length);
		while (beg < end && beg2 < end2) {
			if (toSort[beg] > toSort[beg2]) {
				swp[writePoint++] = toSort[beg2++];
			} else {
				swp[writePoint++] = toSort[beg++];
			}
		}
		while (beg < end) {
			swp[writePoint++] = toSort[beg++];
		}
		while (beg2 < end2) {
			swp[writePoint++] = toSort[beg2++];
		}
		return writePoint;
	}
	
	@Override
	protected void sort(int[] toSort) {
		int swp[] = new int[toSort.length], beg, writePoint, distance = 1;
		boolean toSwp = true;
		
		while (distance <= toSort.length) {
			writePoint = beg = 0;
			while (beg < toSort.length) {
				if (toSwp) {
					writePoint = merge(beg, distance, toSort, swp, writePoint);
				} else {
					writePoint = merge(beg, distance, swp, toSort, writePoint);
				}
				beg = writePoint;
			}
			toSwp = !toSwp;
			distance *= 2;
		}
		
		if (!toSwp) {
			System.arraycopy(swp, 0, toSort, 0, toSort.length);
		}
	}
	
	
	
	
	
	protected void sort_(int[] toSort) {
		int distance = 1;
		int[] swp = new int[toSort.length];
		int beg, end, beg2, end2;
		int writePoint;
		boolean toSwp = true;
		while (distance <= toSort.length) {
			writePoint = beg = 0;
			
			while (beg < toSort.length) {
				//end = beg + distance;
				end = Math.min(beg + distance, toSort.length);
				beg2 = end;
				end2 = Math.min(beg2 + distance, toSort.length);
				int idx = beg;
				//do merge to swp
				if (toSwp) {
					while (idx < end && beg2 < end2) {
						if (toSort[idx] > toSort[beg2]) {
							swp[writePoint++] = toSort[beg2++];
						} else {
							swp[writePoint++] = toSort[idx++];
						}
					}
					while (idx < end) {
						swp[writePoint++] = toSort[idx++];
					}
					while (beg2 < end2) {
						swp[writePoint++] = toSort[beg2++];
					}
				} else {					
					while (idx < end && beg2 < end2) {
						if (swp[idx] > swp[beg2]) {
							toSort[writePoint++] = swp[beg2++];
						} else {
							toSort[writePoint++] = swp[idx++];
						}
					}
					while (idx < end) {
						toSort[writePoint++] = swp[idx++];
					}
					while (beg2 < end2) {
						toSort[writePoint++] = swp[beg2++];
					}
					
				}
				beg = end2;
			}
			toSwp = !toSwp;
			distance *= 2;
		}
		if (!toSwp) {
			System.arraycopy(swp, 0, toSort, 0, toSort.length);
		}
	}
}
