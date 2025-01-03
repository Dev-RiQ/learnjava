package 예외처리;

public class _03예외처리3 {

	public static void main(String[] args) {

		int[] arr = new int[3];
		try {
			arr[4] = 10;
//			arr = null;
//			System.out.println(arr[0]);
		} catch (NullPointerException e) {
			System.out.println("null임");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("범위아님");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally { // 무조건 실행 (예외든 아니든) (보통 sc.close(); 같은거 넣어줌)
			System.out.println("프로그램 종료");
		}
	}

}
