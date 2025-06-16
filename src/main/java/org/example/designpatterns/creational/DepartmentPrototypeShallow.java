package org.example.designpatterns.creational;

public class DepartmentPrototypeShallow {
    private String name;
    private int deptId;

    public DepartmentPrototypeShallow(String name, int deptId) {
        this.name = name;
        this.deptId = deptId;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getDeptId() { return deptId; }
    public void setDeptId(int deptId) { this.deptId = deptId; }

    @Override
    public String toString() {
        return "Department [name=" + name + ", deptId=" + deptId + "]";
    }
}
