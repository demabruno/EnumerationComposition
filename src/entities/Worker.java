package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkLevel;

public class Worker {
	private String name;
	private WorkLevel level;
	private double baseSalary;
	private List<HourContract> contracts = new ArrayList();
	private Departament departament;
	
	public Worker(String name, WorkLevel level, double baseSalary, Departament departament) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkLevel getLevel() {
		return level;
	}

	public void setLevel(WorkLevel level) {
		this.level = level;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public List<HourContract> getContracts() {
		return this.contracts;
	}

	public void addContract(HourContract contract) {
		this.contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		this.contracts.remove(contract);
	}
	
	public Departament getDepartment() {
		return departament;
	}

	public void setDepartment(Departament department) {
		this.departament = departament;
	}

	public double income(int year, int month) {
		double totalValue = 0;
		Calendar calendar = Calendar.getInstance();
		for (HourContract contract : this.getContracts()) {
			calendar.setTime(contract.getDate());
			int yearContract = calendar.get(calendar.YEAR);
			int monthContract = 1+ calendar.get(calendar.MONTH);
			if (year == yearContract && month == monthContract) {
				totalValue += contract.totalValue();
			}
		}
		return totalValue + this.getBaseSalary();
	}
	
	@Override
	public String toString() {
		return "Worker [name=" + name + ", level=" + level + ", baseSalary=" + baseSalary + "]";
	}
}
