package tutorial.HibernateTutorial;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String name;
private double salary;
@ManyToOne
@JoinColumn(name = "department_id")
private Department department;


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public Department getDepartment() {
	return department;
}
public void setDepartment(Department department) {
	this.department = department;
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee( String name, double salary) {
	super();
	this.id = id;
	this.name = name;
	this.salary = salary;
	this.department = department;
}


}
