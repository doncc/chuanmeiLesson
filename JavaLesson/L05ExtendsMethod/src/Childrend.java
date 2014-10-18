public class Childrend extends Parent {

	int age;
	String name;

	public Childrend(String cName, int cAge) {

		this.name = cName;
		age = cAge;
	}
	
	@Override
	void showInfo() {
		System.out.println("孩子姓名：" + name);
	}

	public static void main(String args[]) {

		Childrend c = new Childrend("张三", 10);
		c.showInfo();
	}
	
	
}
