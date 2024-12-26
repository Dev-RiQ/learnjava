package 메서드개념;

class Calculator{
	double result;
	void plus(double x, double y) {
		result(x,y,"+",x+y);
	}
	void minus(double x, double y) {
		result(x,y,"-",x-y);
	}
	void result(double x, double y, String op, double res) {
		System.out.printf(" %.1f %s %.1f = %.1f \n",x,op,y,res);
	}
}

public class _05메서드메모리그림2 {

	public static void main(String[] args) {

		Calculator cal = new Calculator();
		double x = 10;
		double y = 3;
		cal.plus(x, y);
		cal.minus(x, y);
	}

}
