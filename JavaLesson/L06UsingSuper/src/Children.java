public class Children extends Parents {

	String cName;
	char cSex;

	public Children(String pName, String cName, char cSex) {

		super(pName);
		this.cName = cName;
		this.cSex = cSex;
	}

	boolean isChildren(){
//		if (this instanceof Children) {
//			return true;
//		}else {
//			return false;
//		}
		if (this instanceof Children)
			return true;
		else
			return false;
	}

	public static void main(String args[]) {

		Children ch = new Children("张三爸","张三", 'M');
		System.out.println("this 是当前类的实例吗？");
		System.out.println(ch.isChildren());
	}

}
