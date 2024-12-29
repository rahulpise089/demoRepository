package com.jnfy.java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jnfy.java8.employee.Employee;

public class TestFeatures {

	public static void main(String[] args) {

		List<Employee> employees = EmployeeDatabase.getAllEmployees();

		// 1.forEach()
		System.out.println("***************1.forEach*********************");
		// employees.forEach(System.out::println);
		employees.forEach(e -> System.out.println(e));
		employees.forEach(e -> System.out.println(e.getName() + ", " + e.getSalary()));
		System.out.println("***************2.Stream()*********************");

		// if we want to peform some data manipulation --> use stream()
		employees.stream().forEach(e -> System.out.println(e.getGender()));

		System.out.println("***************3.filter()*********************");

		List<Employee> employeeFtomHRDept = employees.stream().filter(e -> e.getDept().equalsIgnoreCase("HR"))
				.collect(Collectors.toList());
		System.out.println(employeeFtomHRDept);

		List<String> filterGenderHavingDevdept = employees.stream()
				.filter(e -> e.getDept().equalsIgnoreCase("development")).map(e -> e.getName() + ": " + e.getGender())
				.collect(Collectors.toList());
		System.out.println(filterGenderHavingDevdept);

		System.out.println(
				"If I dont want to print entire emp object which is filtered, I want to print only id and name pair\n use toMap() method: ****************");
		Map<Integer, String> filteredEmployeesIdAndNamePairFromDevdepts = employees.stream()
				.filter(e -> e.getDept().equalsIgnoreCase("Development") && e.getSalary() > 80000)
				.collect(Collectors.toMap(Employee::getId, Employee::getName));
		System.out.println(filteredEmployeesIdAndNamePairFromDevdepts);

		Map<String, Double> filteredEmployeesNameAndSalaryPairFromSalesdepts = employees.stream()
				.filter(e -> e.getDept().equalsIgnoreCase("Sales"))
				.collect(Collectors.toMap(Employee::getName, Employee::getSalary));

		System.out.println(filteredEmployeesNameAndSalaryPairFromSalesdepts);

		System.out.println("**************4.map()************************************");
		System.out.println(
				"if I want to fetch the all department from entire emp object\n Use Map() method:*********************");

		List<String> employeeDepts = employees.stream().map(Employee::getDept).collect(Collectors.toList());
		System.out.println(employeeDepts);
		// or
		Set<String> employeeDept = employees.stream().map(e -> e.getDept()).collect(Collectors.toSet());// avoid
																										// duplicate
																										// field -->use
																										// toSet()
		System.out.println("Unique Departments: " + employeeDept);

		System.out.println("if I want to fetch nested field class attribute \n use flamap() method: instread of map()");
		List<Stream<String>> projectNames = employees.stream().map(e -> e.getProjects().stream().map(p -> p.getName()))
				.collect(Collectors.toList());
		System.out.println("Project Names using map() method: " + projectNames); // not printing project names only
																					// printing address ref

		System.out.println("if I want to fetch nested field class attribute \n use flamap() method: instread of map()");
		System.out.println("**************Using Flatmap() method****************");

		List<String> projectNamesUsingFlatMap = employees.stream().flatMap(e -> e.getProjects().stream())
				.map(p -> p.getName()).collect(Collectors.toList());

		System.out.println(projectNamesUsingFlatMap);
		// or
		System.out.println("avoid duplicate name using distinct() method:******************");
		List<String> uniqueprojectNamesUsingFlatMap = employees.stream().flatMap(e -> e.getProjects().stream())
				.map(p -> p.getName()).distinct().collect(Collectors.toList());

		System.out.println(uniqueprojectNamesUsingFlatMap);
		
		
		System.out.println("**************************5.sorted()**************************************");
		//sort --> based on salary
		List<Employee>ascsorting=employees.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
		System.out.println(ascsorting);
		//to better display the the result of sortedlist use for forEach()
		ascsorting.forEach(System.out::println);
		System.out.println("descending sorting***********************");
		List<Employee> descSort = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
		System.out.println(descSort);
		descSort.forEach(System.out::println);
		
		//or --> descending sort using Collections.reverseOrder
		List<Employee> descSort1 = employees.stream().sorted(Collections.reverseOrder(Comparator.comparing(Employee::getSalary))).collect(Collectors.toList());
		System.out.println(descSort1);
		descSort1.forEach(System.out::println); 
		
		System.out.println("***********************6.min & max()**********************************");
		//max
		Optional<Employee> maxPaidEmployee = employees.stream().max(Comparator.comparing(Employee::getSalary));
		System.out.println(" maxPaidEmployee :"+maxPaidEmployee);
		
		//min
		Optional<Employee> minPaidEmployee = employees.stream().min(Comparator.comparing(Employee::getSalary));
		System.out.println(" minPaidEmployee :"+minPaidEmployee);
		
		System.out.println("********************7.groupingBy()****************************");
		System.out.println("I want to filter out how many male and female employee I have in emp list");
		Map<String, List<Employee>>employeeGrouping=employees.stream().collect(Collectors.groupingBy(Employee::getGender)); //based on what field you want to group
        System.out.println(employeeGrouping);
        
        //I dont want to print complete emp object I just want to print gender and name of the employee
        Map<String,List<String>> employeeGroupNames=employees.stream()
        		.collect(Collectors.groupingBy(Employee::getGender,
        				Collectors.mapping(Employee::getName, Collectors.toList() )));
        System.out.println(employeeGroupNames);
        
        System.out.println("I want to  evaluate the how many male and female count in grouping result ");
       
        Map<String, Long> employeeGroupCountMap = employees.stream()
        .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.println(employeeGroupCountMap); //{Female=5, Male=5}
        
        System.out.println("******************************8.findFirst()**********************************");
        Optional<Employee> firstElement = employees.stream().findFirst();
        System.out.println("firstElement :"+firstElement.get());//NPE  if record not found --> it will give NPE
       
        //how to avoid it
        if(firstElement.isPresent()) {
        	System.out.println("firstElement :"+firstElement.get());
        }
        
        //or
       Employee findFirstEmployee= employees.stream().findFirst().orElseThrow(() -> new IllegalArgumentException("Employee not found"));
       System.out.println(" avoid NPE: "+findFirstEmployee);
       
       //
//       System.out.println("getting Exception");
//       Employee orElseThrow = employees.stream().filter(e ->e.getDept().equals("abc")).findFirst().orElseThrow(() -> new IllegalArgumentException("Employee not found"));
//       System.out.println(orElseThrow);
        
        
        
        System.out.println("******************************9.findAny()**********************************");
        //if any record is found then process my flow like that
        Optional<Employee> anyElement = employees.stream().findAny();
        System.out.println("anyElement :"+anyElement.get());//NPE  if record not found --> it will give NPE
       
        //how to avoid it
        if(firstElement.isPresent()) {
        	System.out.println("anyElement :"+anyElement.get());
        }
        
        //or
       Employee findAnyEmployee= employees.stream().findFirst().orElseThrow(() -> new IllegalArgumentException("Employee not found"));
       System.out.println(" avoid NPE: "+findAnyEmployee);
       
       //
       System.out.println("getting Exception");
//       Employee orElseThrow1 = employees.stream().filter(e ->e.getDept().equals("Development")).findFirst().orElseThrow(() -> new IllegalArgumentException("Employee not found"));
//        System.out.println(orElseThrow1);
        
       
       System.out.println("*****************10.anyMatch(),allMatch(),noneMatch()**********************************");
       //it takes input as predicate argument and return result in  true or false
       
       boolean developmentEmpAnyMatch = employees.stream().anyMatch(e -> e.getDept().equals("Development"));
       System.out.println(developmentEmpAnyMatch); //true
       
       
       //ex2
       boolean developmentEmpAllMatch = employees.stream().allMatch(e -> e.getDept().equals("Development"));
       System.out.println(developmentEmpAllMatch); //false
       
     //or
       boolean devEmpAllMatch=employees.stream().allMatch(e -> e.getSalary() > 40000);
       System.out.println("devEmpAllMatch:"+devEmpAllMatch); //true
       
       //isnoneMatch()
       boolean noneMatch = employees.stream().noneMatch(e ->e.getDept().equals("abc"));
       System.out.println("devEmpAllMatch: "+devEmpAllMatch); //true
       
       
       System.out.println("***************11.limit()***************************");
       //if you are getting 10 emp object out of that you want to get only 3  then use--->limit()
     //top3 paid employee
        List<Employee> topPaidEmployee = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
        		.limit(3).collect(Collectors.toList()); 
       System.out.println("topPaidEmployees are: "+topPaidEmployee);
       topPaidEmployee.forEach(System.out::println); //or only print topPaidEmployees name
       System.out.println("get topPaidEmployee name only: ***********************");
       topPaidEmployee.forEach(e ->System.out.println(e.getName()));
       
       
       
       System.out.println("****************************12.skip()*********************************************");
       
       System.out.println("if you want to skip element out of the given");
       
       employees.stream().skip(5).forEach(System.out::println);
       List<Employee> skipEmployee = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(5)
    		   .collect(Collectors.toList()); //here first 5 top salary name will be skip and remaining will be display
       System.out.println("skipEmployee: \n"+skipEmployee);
       skipEmployee.forEach(System.out::println);
       
       
       
       
       
       
       
       
       
        
	}
}
