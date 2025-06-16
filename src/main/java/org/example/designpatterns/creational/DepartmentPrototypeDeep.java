package org.example.designpatterns.creational;

public class DepartmentPrototypeDeep implements Cloneable {
    private String name;
    private int deptId;

    public DepartmentPrototypeDeep(String name, int deptId) {
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

    /**
     * Performs a shallow copy of the Department itself.
     * Since Department only has primitive and String (immutable) fields,
     * this effectively acts as a deep copy for Department's internal state.
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
