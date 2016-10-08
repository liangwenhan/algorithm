package study;
import java.util.Random;


public class LCS {

	//
	public static void main(String[] args) {
		//System.out.println(genChars());
		//foo();
		foo2();
	}
	
	static char[] genChars() {
		Random r = new Random();

		int length1 = Math.abs(r.nextInt()) % 12 + 1;
		char [] ret = new char[length1];
		for (int i = 0; i < length1; i++) {
			ret[i] = (char) ('a' + Math.abs(r.nextInt()) % 5);
		}
		return ret;
	}
	
	static int getArr(int i, int j, int[][] arr) {
		if (i >= 0 && j >= 0) {
			return arr[i][j];
		} else {
			return 0;
		}
	}
	
	static void foo() {
		//char [] str1 = genChars();
		//char [] str2 = genChars();
		char [] str1 = "belong".toCharArray();
		char [] str2 = "myblog".toCharArray();
		int [][] intArr = new int[str1.length][];
		for (int i = 0; i < str1.length; i++) {
			intArr[i] = new int[str2.length];
			for (int j = 0; j < str2.length; j++) {
				if (str1[i] == str2[j]) {
					intArr[i][j] = getArr(i - 1, j - 1, intArr) + 1;
				} else {
					intArr[i][j] =  Math.max(getArr(i - 1, j, intArr), getArr(i, j - 1, intArr));
				}
				
			}
		}
		System.out.println(str1);
		System.out.println(str2);
		System.out.println();
		System.out.print(" ");
		System.out.println(str2);
		for (int i = 0; i < str1.length; i++) {
			System.out.print(str1[i]);
			for (int j = 0; j < str2.length; j++) {
				System.out.print(intArr[i][j]);
			}
			System.out.println();
		}
		
		StringBuffer buff = new StringBuffer();
		
		int j = str2.length - 1;
		int i = str1.length - 1;
		for (;;) {
			if (i < 0 || j < 0) {
				break;
			}
			if (str1[i] == str2[j]) {
				buff.append(str1[i]);
			}
			int a1 = getArr(i - 1, j - 1, intArr);
			int a2 = getArr(i, j - 1, intArr);
			int a3 = getArr(i - 1, j, intArr);
			int max = Math.max(Math.max(a1, a2), a3);
			if (max == a1) {
				i--;
				j--;
			} else if (max == a2) {
				j--;
			} else {
				i--;
			}
		}
		System.out.println();
		System.out.println(buff.reverse());
	}
	
	
	
	static int getArr(int i, int[] arr) {
		if (i >= 0) {
			return arr[i];
		} else {
			return 0;
		}
	}
	
	static void foo2() {
		char [] str1 = genChars();
		char [] str2 = genChars();
		//char [] str1 = "abcd".toCharArray();
		//char [] str2 = "abcabcd".toCharArray();
		System.out.println(str1);
		System.out.println(str2);
		if (str1.length < str2.length) {
			char [] tem = str1;
			str1 = str2;
			str2 = tem;
		}
		
		
		int [] workArr = new int[str2.length];
		
		int maxValue = -1, maxI = -1, maxJ = -1, preX = 0;
		for (int i = 0; i < str1.length; i++) {
			for (int j = 0; j < str2.length; j++) {
				int tem = workArr[j];
				if (str1[i] == str2[j]) {
					workArr[j] = preX + 1;
					if (maxValue < workArr[j]) {
						maxValue = workArr[j];
						maxI = i;
						maxJ = j;
					}
				} else {
					workArr[j] = 0;
				}
				preX = tem;
			}
//			for (int k = 0; k < workArr.length; k++) {
//				System.out.print(workArr[k]);
//			}
//			System.out.println();
			preX = 0;
		}
		if (maxValue != -1) {
			int beg = maxI - maxValue + 1;
			for (int i = 0; i < maxValue; i++) {
				System.out.print(str1[beg + i]);
			}
//			System.out.println(maxValue);
//			System.out.println(maxI);
//			System.out.println(maxJ);
		} else {
			System.out.println(":null");
		}
		
	}
}
