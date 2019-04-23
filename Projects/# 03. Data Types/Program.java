class Program {
	public static void main(String[] args) {
		int x = 17;
		int y = 5;
		int z = x / y; // z = 3
		double w = x / y; // w = 3.0
		System.out.println(z);
		System.out.println(w);
		w = (x * 1.0) / y;
		System.out.println(w);
	}
}