class Program {
	public static void main(String[] args) {
		int start = 10;
		int finish = 1000;

		int lastDigit;
		int beforeLastDigit;
		int twoLastDigits;

		int current = start;

		while (current <= finish) {

			twoLastDigits = current % 100;
			lastDigit = twoLastDigits % 10;
			beforeLastDigit = twoLastDigits / 10; 

			if ((beforeLastDigit + lastDigit) % 2 == 0) {
				System.out.print(current + ",");
			}

			current = current + 1;

		}
	}
}