package org.example.designpatterns.creational;

public class EmployeePrototypeShallow implements Cloneable {
    private int id;
    private String name;
    private DepartmentPrototypeShallow department; // Reference type

    public EmployeePrototypeShallow(int id, String name, DepartmentPrototypeShallow department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public DepartmentPrototypeShallow getDepartment() { return department; }
    public void setDepartment(DepartmentPrototypeShallow department) { this.department = department; }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", department=" + department + "]";
    }

    /**
     * Performs a shallow copy.
     * Only primitive fields and references are copied.
     * The 'department' object itself is NOT cloned, only its reference is copied.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        // Call Object's clone() which performs a shallow copy by default
        return super.clone();
    }
}
