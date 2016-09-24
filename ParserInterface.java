public class ParserInterface {
	
	private IArithmetic addition = (int first, int second) -> first + second;
	private IArithmetic subtraction = (int first, int second) -> first - second;
	private IArithmetic multiplication = (int first, int second) -> first * second;
	private IArithmetic division = (int first, int second) -> first / second;
	
	public ParserInterface() {
		
	}
	
	public IArithmetic[] getArithmetic(String initialString) {
		initialString = initialString.toLowerCase();
		
		String[] tokenizedStringArray = initialString.split(" ");
		
		IArithmetic[] finalArithmetic = checkStringArray(tokenizedStringArray);
		
		return finalArithmetic;		
	}
	
	private IArithmetic[] checkStringArray(String[] stringArray) {
		int arrayLength = stringArray.length;
		IArithmetic[] newFunctionArray;
		int numberOfFunctions;
		int currFuncArrayPos = 0, currStrArrayPos = 0;
		
		if (arrayLength % 3 != 0) {
			// TO DO - Replace with custom exception
			System.out.println("This string is of invalid length");
			return null;
		}
		
		numberOfFunctions = arrayLength / 3;
		newFunctionArray = new IArithmetic[numberOfFunctions];
		
		System.out.println(numberOfFunctions);
		
		for (int a = 0; a < numberOfFunctions; a++) {
			String funcType = stringArray[currStrArrayPos];
			String firstValue = stringArray[currStrArrayPos + 1];
			String secondValue = stringArray[currStrArrayPos + 2];
			
			System.out.println(funcType + " " + firstValue + " " + secondValue);
			
			newFunctionArray[currFuncArrayPos] = 
					returnValidFunction(funcType);
			
			currStrArrayPos += 3;
			currFuncArrayPos++;
		}
		
		return newFunctionArray;
	}
	
	private IArithmetic returnValidFunction(String funcType) {
		switch (funcType) {
		case "plus" : return this.addition;
		case "minus" : return this.subtraction;
		case "times" : return this.multiplication;
		case "division" : return this.division;
		// TO DO - Replace with custom exception
		default : System.out.println("Invalid string"); return null;		
		}
	}
}
