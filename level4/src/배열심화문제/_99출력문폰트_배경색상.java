package 배열심화문제;

public class _99출력문폰트_배경색상 {

	public static final String RESET = "\u001B[0m";    
	public static final String FONT_BLACK = "\u001B[30m";    
	public static final String FONT_RED = "\u001B[31m";     
	public static final String FONT_GREEN = "\u001B[32m";    
	public static final String FONT_YELLOW = "\u001B[33m";     
	public static final String FONT_BLUE = "\u001B[34m";   
	public static final String FONT_PURPLE = "\u001B[35m";     
	public static final String FONT_CYAN = "\u001B[36m";    
	public static final String FONT_WHITE = "\u001B[37m";     
	public static final String BACKGROUND_BLACK = "\u001B[40m";     
	public static final String BACKGROUND_RED = "\u001B[41m";     
	public static final String BACKGROUND_GREEN = "\u001B[42m";    
	public static final String BACKGROUND_YELLOW = "\u001B[43m";     
	public static final String BACKGROUND_BLUE = "\u001B[44m";    
	public static final String BACKGROUND_PURPLE = "\u001B[45m";     
	public static final String BACKGROUND_CYAN = "\u001B[46m";     
	public static final String BACKGROUND_WHITE = "\u001B[47m";
	// Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
	
	public static void main(String[] args) {
		System.out.println(BLACK_BACKGROUND_BRIGHT+"     test      "+RESET);
		System.out.println(BLACK_BACKGROUND+"     test      "+RESET);
		System.out.println(BLACK_BOLD+"     test      "+RESET);
		System.out.println(BLACK_BOLD_BRIGHT+"     test      "+RESET);
		System.out.println(BLACK_BRIGHT+"     test      "+RESET);
		System.out.println(BLACK_UNDERLINED+"     test      "+RESET);
		System.out.println("NON");
		System.out.print(FONT_BLACK+"색 변경하기 "+RESET);
		System.out.print(FONT_RED+"색 변경하기 "+RESET);
		System.out.print(FONT_GREEN+"색 변경하기 "+RESET);
		System.out.println(FONT_YELLOW+"색 변경하기 "+RESET);
		System.out.print(FONT_BLUE+"색 변경하기 "+RESET);
		System.out.print(FONT_PURPLE+"색 변경하기 "+RESET);
		System.out.print(FONT_CYAN+"색 변경하기 "+RESET);
		System.out.println(FONT_WHITE+"색 변경하기 "+RESET);
		System.out.println("BLACK");
		System.out.print(BACKGROUND_BLACK);
		System.out.print(FONT_BLACK+"색 변경하기 ");
		System.out.print(FONT_RED+"색 변경하기 ");
		System.out.print(FONT_GREEN+"색 변경하기 ");
		System.out.println(FONT_YELLOW+"색 변경하기 ");
		System.out.print(FONT_BLUE+"색 변경하기 ");
		System.out.print(FONT_PURPLE+"색 변경하기 ");
		System.out.print(FONT_CYAN+"색 변경하기 ");
		System.out.println(FONT_WHITE+"색 변경하기 "+RESET);
		System.out.println("RED");
		System.out.print(BACKGROUND_RED);
		System.out.print(FONT_BLACK+"색 변경하기 ");
		System.out.print(FONT_RED+"색 변경하기 ");
		System.out.print(FONT_GREEN+"색 변경하기 ");
		System.out.println(FONT_YELLOW+"색 변경하기 ");
		System.out.print(FONT_BLUE+"색 변경하기 ");
		System.out.print(FONT_PURPLE+"색 변경하기 ");
		System.out.print(FONT_CYAN+"색 변경하기 ");
		System.out.println(FONT_WHITE+"색 변경하기 "+RESET);
		System.out.println("GREEN");
		System.out.print(BACKGROUND_GREEN);
		System.out.print(FONT_BLACK+"색 변경하기 ");
		System.out.print(FONT_RED+"색 변경하기 ");
		System.out.print(FONT_GREEN+"색 변경하기 ");
		System.out.println(FONT_YELLOW+"색 변경하기 ");
		System.out.print(FONT_BLUE+"색 변경하기 ");
		System.out.print(FONT_PURPLE+"색 변경하기 ");
		System.out.print(FONT_CYAN+"색 변경하기 ");
		System.out.println(FONT_WHITE+"색 변경하기 "+RESET);
		System.out.println("YELLOW");
		System.out.print(BACKGROUND_YELLOW);
		System.out.print(FONT_BLACK+"색 변경하기 ");
		System.out.print(FONT_RED+"색 변경하기 ");
		System.out.print(FONT_GREEN+"색 변경하기 ");
		System.out.println(FONT_YELLOW+"색 변경하기 ");
		System.out.print(FONT_BLUE+"색 변경하기 ");
		System.out.print(FONT_PURPLE+"색 변경하기 ");
		System.out.print(FONT_CYAN+"색 변경하기 ");
		System.out.println(FONT_WHITE+"색 변경하기 "+RESET);
		System.out.println("BLUE");
		System.out.print(BACKGROUND_BLUE);
		System.out.print(FONT_BLACK+"색 변경하기 ");
		System.out.print(FONT_RED+"색 변경하기 ");
		System.out.print(FONT_GREEN+"색 변경하기 ");
		System.out.println(FONT_YELLOW+"색 변경하기 ");
		System.out.print(FONT_BLUE+"색 변경하기 ");
		System.out.print(FONT_PURPLE+"색 변경하기 ");
		System.out.print(FONT_CYAN+"색 변경하기 ");
		System.out.println(FONT_WHITE+"색 변경하기 "+RESET);
		System.out.println("PURPLE");
		System.out.print(BACKGROUND_PURPLE);
		System.out.print(FONT_BLACK+"색 변경하기 ");
		System.out.print(FONT_RED+"색 변경하기 ");
		System.out.print(FONT_GREEN+"색 변경하기 ");
		System.out.println(FONT_YELLOW+"색 변경하기 ");
		System.out.print(FONT_BLUE+"색 변경하기 ");
		System.out.print(FONT_PURPLE+"색 변경하기 ");
		System.out.print(FONT_CYAN+"색 변경하기 ");
		System.out.println(FONT_WHITE+"색 변경하기 "+RESET);
		System.out.println("CYAN");
		System.out.print(BACKGROUND_CYAN);
		System.out.print(FONT_BLACK+"색 변경하기 ");
		System.out.print(FONT_RED+"색 변경하기 ");
		System.out.print(FONT_GREEN+"색 변경하기 ");
		System.out.println(FONT_YELLOW+"색 변경하기 ");
		System.out.print(FONT_BLUE+"색 변경하기 ");
		System.out.print(FONT_PURPLE+"색 변경하기 ");
		System.out.print(FONT_CYAN+"색 변경하기 ");
		System.out.println(FONT_WHITE+"색 변경하기 "+RESET);
		System.out.println("WHITE");
		System.out.print(BACKGROUND_WHITE);
		System.out.print(FONT_BLACK+"색 변경하기 ");
		System.out.print(FONT_RED+"색 변경하기 ");
		System.out.print(FONT_GREEN+"색 변경하기 ");
		System.out.println(FONT_YELLOW+"색 변경하기 ");
		System.out.print(FONT_BLUE+"색 변경하기 ");
		System.out.print(FONT_PURPLE+"색 변경하기 ");
		System.out.print(FONT_CYAN+"색 변경하기 ");
		System.out.println(FONT_WHITE+"색 변경하기 "+RESET);
		
	}

}
