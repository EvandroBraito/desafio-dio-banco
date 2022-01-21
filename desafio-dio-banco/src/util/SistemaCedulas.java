package util;

public class SistemaCedulas {

	public static double total;
	public static double ced = 50;
	public static int totced;

	public static void separaCedulas(double valor) {
		total = valor;
		while (true) {
			if (total >= ced) {
				total -= ced;
				totced += 1;
			} else {
				if (totced > 0)
					System.out.println("Total de " + totced + " cedulas de R$" + ced);
				if (ced == 50)
					ced = 20;
				else if (ced == 20)
					ced = 10;
				else if (ced == 10)
					ced = 1;
				totced = 0;
				if (total == 0)
					break;
			}
		}
	}
}
