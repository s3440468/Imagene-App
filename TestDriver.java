
public class TestDriver {
	public static void main(String[] args) {
		String testString1 = "plus x y minus x y";
		String testString2 = "times x y plus x y minus x y times x y";
		IArithmetic[] testArray1;
		
		System.out.println("TEST POINT 1");
		
		int x = 10, y = 3;
		int total = 0;
		
		ParserInterface PS = new ParserInterface();
		
		testArray1 = PS.getArithmetic(testString2);
		
		System.out.println("TEST POINT 2");
		System.out.println(testArray1.length);
		
		for (int a = 0; a < testArray1.length; a++) {
			if (testArray1[a] == null) {
				System.out.println("ITS NULL");
			}
			total += testArray1[a].operation(x, y);
			System.out.println("TEST POINT 2." + a);
			System.out.println(total);
		}
		
		System.out.println("The end result is " + total);
	}
	
}
