public class ObjectParaDemo {

	public static void main(String args[]) {

		Value v,v1, v2;
		v1 = new Value(2, 3);
		v2 = new Value(3, 4);
		v = Value.addValues(v1, v2);
		v.showValue();
	}

}
