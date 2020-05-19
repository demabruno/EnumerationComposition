import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkLevel;

public class Program {
	public static void main(String [] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Enter department's name:");
		String departamentName = sc.next();
		System.out.println("Enter worker data:");
		System.out.print("Name:");
		String name = sc.next();
		System.out.print("Level:");
		WorkLevel level = WorkLevel.valueOf(sc.next());
		System.out.print("Base salary:");
		double baseSalary = sc.nextDouble();
		System.out.print("How many contracts to this worker?");
		int numContracts = sc.nextInt();
		Worker worker = new Worker(name, level, baseSalary, new Departament(departamentName));
		HourContract hourContract;
		for (int i = 0; i < numContracts; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date dataContract = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours) ");
			int durationHours = sc.nextInt();
			hourContract = new HourContract(dataContract, valuePerHour, durationHours);
			worker.addContract(hourContract);
		}
		System.out.println();
		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		String dataIncome = sc.next();
		int month = Integer.parseInt(dataIncome.substring(0, 2));
		int year = Integer.parseInt(dataIncome.substring(3));
		System.out.println("Departament: " + worker.getDepartment().getName());
		System.out.println("Worker     : " + worker.getName());
		System.out.println("Income  in :" + dataIncome + " --> R$ " + String.format("%.2f", worker.income(year, month)));
		sc.close();
	}
}
