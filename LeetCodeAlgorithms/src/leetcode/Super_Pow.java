package leetcode;

import java.math.BigDecimal;


/*
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
 */
public class Super_Pow {

	public static void main(String[] args) {
		System.out.println(superPow(2147483647, new int[]{2,0,0}));
	}
	
	public static int superPow(int a, int[] b) {
        long bb = 0, wei = 1, sum = 1;
        BigDecimal bd = new BigDecimal(a);
        for (int i = b.length - 1; i >=0; i--) {
        	bb = bb + wei * b[i];
        	wei *= 10;
        }
       // bd.pow((int) bb).;
        for (int i = 0; i < bb; i++) {
        	//
        }
        System.out.println(sum);
        return (int) (sum % 1337);
    }
}