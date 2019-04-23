import java.util.Scanner;

class Program {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int finish = -1;
		int current = scanner.nextInt();

		int sum = 0;
		while (current != finish) {
			sum = sum + current;
			current = scanner.nextInt(); 
		}
		System.out.println(sum);
	}
}