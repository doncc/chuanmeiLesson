public class Sum {
	
	private int par1 = 0;
	
	public Sum(){
//		System.out.println("构造方法");
		System.out.println("构造1");
	}
	
	public Sum(int a, int b){
		System.out.println("构造2");
	}

	static int add(int x, int y) {
		return x + y;
	}

	static int add(int... is) {
		System.out.println("add2");
		
		return 0;
	}
	
	static int add(int x, int y, int z) {
		System.out.println("add1");
		return x + y + z;
	}

	static float add(float x, float y) {
		return x + y;
	}

	

	public static void main(String args[]) {

		// System.out.println(Sum.add(1, 2));
		// System.out.println(Sum.add(1.2f, 3.4f));
//		System.out.println(Sum.add(1, 2, 3));
//		System.out.println(Sum.add(1, 2, 3,4));
		
		Sum sum = new Sum(1, 2);
		Sum sum1 = new Sum();
		
		Hello  hello = new Hello();
		
	}
}
