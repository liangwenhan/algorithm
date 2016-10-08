package leetcode;

public class Sum_of_Two_Integers {

	/**
	 * 两数相加，不能用+-
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(getSum(-19, -1));
		System.out.println(Integer.MAX_VALUE + 1);
	}

	public static int getSum(int a, int b) {
		int aa = a, bb = b;
		while ((aa & bb) != 0) {
			int tem = (aa & bb) << 1;
			bb = aa ^ bb;
			aa = tem;
		}
		return aa | bb;
    }
	
	
	public int getSum_better(int a, int b) {
        int aa = a, bb = b;
		while (aa != 0) {
			int tem = (aa & bb) << 1;
			bb = aa ^ bb;
			aa = tem;
		}
		return bb;
    }
}
