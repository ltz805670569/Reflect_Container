package cn.itxdl.bean;

public class Emp {
    private String eno;
    private String ename;
    private double esalary;

    public Emp() {
    }

    public Emp(String eno, String ename, double esalary) {
        this.eno = eno;
        this.ename = ename;
        this.esalary = esalary;
    }

    public String getEno() {
        return eno;
    }

    public void setEno(String eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getEsalary() {
        return esalary;
    }

    public void setEsalary(double esalary) {
        this.esalary = esalary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eno='" + eno + '\'' +
                ", ename='" + ename + '\'' +
                ", esalary=" + esalary +
                '}';
    }
}
