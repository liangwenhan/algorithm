package study;

public class ConstructOrder {

	public static void main(String[] args) {
		System.out.println(":");
		Test2 aa = null;
		aa = new Test2();

	}

}

class Test2 {
	
	
	
	static int b;
	
	
	
	static private int fa(int i) {
		System.out.println("init a");
		return i;
	}
	
	private int fc(int i) {
		System.out.println("init c");
		return i;
	}
	
	
	static {
		b = 22;
		System.out.println("init b");
	}
	static int a = fa(11);
	Test2(){
		System.out.println("construct");
	}
	int c = fc(33);
}