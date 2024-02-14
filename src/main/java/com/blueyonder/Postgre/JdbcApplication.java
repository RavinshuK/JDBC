package com.blueyonder.Postgre;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.blueyonder.Postgre.model.Department;
import com.blueyonder.Postgre.repo.DepartmentRepo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(JdbcApplication.class, args);
		
		Department dep1=ctx.getBean(Department.class);
		dep1.setDepid(4);
		dep1.setDeplocation("Patiala");
		dep1.setDepname("Logistics");
		
		DepartmentRepo repo=ctx.getBean(DepartmentRepo.class);
		repo.save(dep1);
		
		System.out.println(repo.findAll());
		
	}

}
