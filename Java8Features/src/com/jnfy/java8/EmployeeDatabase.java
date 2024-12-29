package com.jnfy.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jnfy.java8.employee.Employee;

public class EmployeeDatabase {

	public static List<Employee> getAllEmployees(){
		
		Project p1 =new Project("P001", "Alpha", "ABC Corp", "Alice");
		Project p2 =new Project("P002", "Beta", "Infy Ltd", "Bob");
		Project p3 =new Project("P003", "Gamma", "Abc Corp", "Jimmy");
		Project p4 =new Project("P004", "Theta", "TechWorld", "Vue");
		Project p5 =new Project("P005", "Delta", "MoneyMatters", "Alix");
		Project p6 =new Project("P006", "Zeta", "SmartTech", "Eva");
		Project p7 =new Project("P007", "Eta", "BrandBoost", "Kevin");
		Project p8 =new Project("P008", "Iota", "InnoSoft", "Jack");
		Project p9 =new Project("P009", "Epsilon", "fastTrack", "George");
		Project p10 =new Project("P010", "Kappa", "DigitalWave", "Jessy");
		
		
		//employee instances
		Employee e1=new Employee(1, "John Doe", "Development", Arrays.asList(p1,p2), 80000, "Male");
		Employee e2=new Employee(2, "Jane Smith", "Hr", Arrays.asList(p3) , 70000, "Female");
		Employee e3=new Employee(3, "Robert Smith", "Development",  Arrays.asList(p4), 60000, "Male");
		Employee e4=new Employee(4, "Lisa White", "Sales",  Arrays.asList(p1), 55000, "Female");
		Employee e5=new Employee(5, "Michael Green", "HR",  Arrays.asList(p5), 90000, "Male");
		Employee e6=new Employee(6, "Sophia Brown", "Finance",  Arrays.asList(p6), 85000, "Female");
		Employee e7=new Employee(7, "James Wilson", "Marketing",  Arrays.asList(p7), 72000, "Male");
		Employee e8=new Employee(8, "Olivia Harris", "Development",  Arrays.asList(p8),88000, "Female");
		Employee e9=new Employee(9, "Emily Clark", "Sales",  Arrays.asList(p9),95000, "Female");
		Employee e10=new Employee(10, "William Lee", "Development",  Arrays.asList(p10),70000, "Male");
		
		List<Employee>list =new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		list.add(e8);
		list.add(e9);
		list.add(e10);
		
		return list;
	//	return Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10);
		
		
	}
}
