class Program {
	public static void main(String[] args) {
		int x0, x1, x2, x3, x4, x5, x6, x7;
		int number = 135;
		// x0 -> 135 % 2 = 1
		x0 = number % 2;
		// number -> 67
		number = number / 2; // number /= 2;
		// x1 -> 67 % 2
		x1 = number % 2;
		number = number / 2;
		x2 = number % 2;
		number = number / 2;
		x3 = number % 2;
		number = number / 2;
		x4 = number % 2;
		number = number / 2;
		x5 = number % 2;
		number = number / 2;
		x6 = number % 2;
		number = number / 2;
		x7 = number % 2;

		System.out.println(x7 + "" + 
			x6 + "" + 
			x5 + "" + 
			x4 + "" + 
			x3 + "" + 
			x2 + "" + 
			x1 + "" 
			+ x0);
	}
}