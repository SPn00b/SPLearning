package org.example.designpatterns.creational;

public class EmployeePrototypeDeep implements Cloneable {
    private int id;
    private String name;
    private DepartmentPrototypeDeep department; // Reference type

    public EmployeePrototypeDeep(int id, String name, DepartmentPrototypeDeep department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getters and Setters (same as before)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public DepartmentPrototypeDeep getDepartment() { return department; }
    public void setDepartment(DepartmentPrototypeDeep department) { this.department = department; }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", department=" + department + "]";
    }

    /**
     * Performs a deep copy.
     * First, it does a shallow copy of Employee itself.
     * Then, it explicitly clones the 'department' object to create a new, independent instance.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        EmployeePrototypeDeep clonedEmployee = (EmployeePrototypeDeep) super.clone(); // Step 1: Shallow copy of Employee

        // Step 2: Deep copy for mutable reference type 'department'
        // This creates a NEW Department object for the cloned Employee
        clonedEmployee.department = (DepartmentPrototypeDeep) department.clone();

        return clonedEmployee;
    }
}
