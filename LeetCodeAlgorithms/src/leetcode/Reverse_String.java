package leetcode;

/*
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
	Given s = "hello", return "olleh".

 * 先试试一个简单的，单是在赢时胜笔试有做过
 */
public class Reverse_String {

	
	static public String reverseString(String s) {
		if (s == null) {
			return null;
		}
		char temChar;
		
		StringBuffer buff = new StringBuffer(s.length());
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			temChar = s.charAt(j);
			buff.setCharAt(j, s.charAt(i));//此处会抛异常
			buff.setCharAt(i, temChar);
		}
		return buff.toString();
	}
	
	static public String reverseString2(String s) {
		if (s == null) {
			return null;
		}
		char temChar;
		StringBuffer buff = new StringBuffer(s);
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			temChar = s.charAt(j);
			buff.setCharAt(j, s.charAt(i));
			buff.setCharAt(i, temChar);
		}
		return buff.toString();
	}
	
	public static void main(String args[]) {
		
		System.out.println(reverseString2("hello"));
	}
}

/*
 * 
 * 总结
 * 1，对stringbuffer不熟悉（打算遇到这种情况就做完这个题之后就看源码），导致调用setCharAt发生越界
 * 2，其实不用两个指针，一个头一个尾来处理，那样适合原地reverse，
 *    在这里的话直接一个从尾巴到头部的循环便可把原字符串反转
 * 3，记得想清楚再写
 */