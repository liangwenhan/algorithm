package leetcode;

/**
 * Given n non-negative integers representing the histogram's 
 * bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * @author lwh
 *
 */
public class Largest_Rectangle_in_Histogram {

	public static void main(String[] args) {
		int arg[] = new int[]{1,1,1,1,1,1,1,1,1};
		//[1,1,1,1,1,1,1,1,1]2,1,5,6,2,3
		System.out.println(largestRectangleArea(arg));
	}

	
	public static int largestRectangleArea(int[] heights) {
		if (heights == null) {
			return 0;
		}
        int maxWeightArray[] = new int [heights.length];
        int before = -1;
        for (int i = 0; i < heights.length; i++) {
        	maxWeightArray[i] = 1;
        	if (i > 0 && heights[i] == heights[i-1]) {
        		maxWeightArray[i] = before;
        		continue;
        	}
        	for (int leftWard = i - 1; leftWard >= 0; leftWard--) {
        		if (heights[leftWard] >= heights[i]) {
        			maxWeightArray[i] = maxWeightArray[i] + 1;
        		} else {
        			break;
        		}
        	}
        	for (int rightWard = i + 1; rightWard < heights.length; rightWard++) {
        		if (heights[rightWard] >= heights[i]) {
        			maxWeightArray[i] = maxWeightArray[i] + 1;
        		} else {
        			break;
        		}
        	}
        	before = maxWeightArray[i];
        }
        
        
        for (int i = 0; i < heights.length; i++) {
        	maxWeightArray[i] = maxWeightArray[i] * heights[i];
        }
        int max = -1;
        for (int i = 0; i < maxWeightArray.length; i++) {
        	if (maxWeightArray[i] > max) {
        		max = maxWeightArray[i];
        	}
        }
        return max;
    }
}
