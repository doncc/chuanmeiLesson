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

		Children ch = new Children("������","����", 'M');
		System.out.println("this �ǵ�ǰ���ʵ����");
		System.out.println(ch.isChildren());
	}

}
