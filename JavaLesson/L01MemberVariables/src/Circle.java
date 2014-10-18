
public class Circle {

	private float fRadius;
	final float PI = 3.14f;
	
	void setRadius(float fr){
		fRadius = fr;
	}
	
	void showArea(){
		System.out.println("圆的面积是:"+ fRadius * fRadius * PI);
	}
	
	public static void main(String args[]){
		Circle _cir = new Circle();
		_cir.setRadius(5);
		_cir.showArea();
		
	}
}
