public class Circle {

	private float fRandius;
	private final float PI = 3.14f;

	void setFrandius(float fr){
		fRandius = fr;
	}
	
	float geteArea() {
		return fRandius * fRandius * PI;
	}

	void showArea() {
		System.out.println("Բ�����:" + geteArea());
	}

	public static void main(String args[]) {

		Circle circle = new Circle();
		circle.setFrandius(3);
		circle.showArea();
	}

}
