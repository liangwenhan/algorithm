package study;

public class Unicode {

public static void main2 (String args[]) {
		
		//System.out.println(java.nio.charset.Charset.defaultCharset());
		
		String str = "os"+(char)57343+"china";
		str.charAt(0);
		System.out.println(str.length());
		System.out.println(str.codePointCount(0, str.length()));
	}
	
	
	public static void main4(String[] args) {
        String a = "a黏 b";
        System.out.println(a.charAt(0));
        System.out.println((int)a.charAt(1));
        System.out.println((int)a.charAt(2));
        System.out.println(a.charAt(3));
        System.out.println(a.length());
        System.out.println(a.codePointCount(0, a.length()));
        System.out.println(a);
        System.out.println(Character.isHighSurrogate(a.charAt(2)));
        System.out.println(Character.isLowSurrogate(a.charAt(3)));
        System.out.println(Character.isHighSurrogate((char)(55378)));
    }
	
	
	public static void main(String[] args) {
		char[] chs = Character.toChars(0x10400);
        System.out.printf("U+10400 高代理字符: %04x%n", (int)chs[0]);
        System.out.printf("U+10400 低代理字符: %04x%n", (int)chs[1]);        
        String str = new String(chs);
        System.out.println("代码单元长度: " + str.length());
        System.out.println("代码点数量: " + str.codePointCount(0, str.length()));
        
        
        System.out.println(str.codePointAt(0));
        System.out.println(str.codePointAt(1));
        
        System.out.println(str.charAt(0));
        System.out.println(str.charAt(1));
        //System.out.println(str.codePointCount(0, str.length()));
	}
	
	
	public static void main0(String[] args) {       
        String str = "𤭢";
        System.out.println("代码单元长度: " + str.length());
        System.out.println("代码点数量: " + str.codePointCount(0, str.length()));
        
        
        System.out.println(str.codePointAt(0));
        System.out.println(str.codePointAt(1));
        
        System.out.println((int)Character.highSurrogate(150370));
        System.out.println((int)Character.lowSurrogate(150370));
	}
		
}
