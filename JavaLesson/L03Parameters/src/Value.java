public class Value {

	int real, virtual;

	public Value(int r, int v) {
		real = r;
		virtual = v;
	}

	void showValue() {
		System.out.println("¸´ÊýÖµÎª" + real + "." + virtual);
	}
	
	static Value addValues(Value v1, Value v2){
		Value v = new Value(0, 0);
		v.real = v1.real + v2.real;
		v.virtual = v1.virtual + v2.virtual;
		return v;
	}
}
