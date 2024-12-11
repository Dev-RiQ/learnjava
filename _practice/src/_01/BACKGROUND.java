package _01;

public class  BACKGROUND {
	
	public static final String RESET() {
		return "\u001B[0m";    
	}
	public static final String BLACK (String a) { 
		return "\u001B[40m" + a;     
	}
	public static final String RED (String a) {
		return "\u001B[41m" + a;     
	}
	public static final String GREEN (String a) {
		return "\u001B[42m" + a;    
	}
	public static final String YELLOW (String a) {
		return "\u001B[43m" + a;     
	}
	public static final String BLUE (String a) {
		return "\u001B[44m" + a;    
	}
	public static final String PURPLE (String a) {
		return "\u001B[45m" + a;     
	}
	public static final String CYAN (String a) { 
		return "\u001B[46m" + a;     
	}
	public static final String WHITE (String a) { 
		return "\u001B[47m" + a;
	}
	public static final String BLACK_BRIHT (String a) { 
		return "\033[0;100m" + a;     
	}
	public static final String RED_BRIHT (String a) {
		return "\033[0;101m" + a;     
	}
	public static final String GREEN_BRIHT (String a) {
		return "\033[0;102m" + a;    
	}
	public static final String YELLOW_BRIHT (String a) {
		return "\033[0;103m" + a;     
	}
	public static final String BLUE_BRIHT (String a) {
		return "\033[0;104m" + a;    
	}
	public static final String PURPLE_BRIHT (String a) {
		return "\033[0;105m" + a;     
	}
	public static final String CYAN_BRIHT (String a) { 
		return "\033[0;106m" + a;     
	}
	public static final String WHITE_BRIHT (String a) { 
		return "\033[0;107m" + a;
	}
	
}
