package model;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String numeStudent;
    private String prenumeStudent;
    private int varsta;
    private Clasa clasaStudent;
    private List<Curs> cursuri;

    public Student(String numeStudent, String prenumeStudent, int varsta, Clasa clasaStudent) {
        this.numeStudent = numeStudent;
        this.prenumeStudent = prenumeStudent;
        this.varsta = varsta;
        this.clasaStudent = clasaStudent;
        cursuri = new ArrayList<>();

    }

    public String getNumeStudent() {
        return numeStudent;
    }

    public void setNumeStudent(String numeStudent) {
        this.numeStudent = numeStudent;
    }

    public String getPrenumeStudent() {
        return prenumeStudent;
    }

    public void setPrenumeStudent(String prenumeStudent) {
        this.prenumeStudent = prenumeStudent;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public Clasa getClasaStudent() {
        return clasaStudent;
    }

    public void setClasaStudent(Clasa clasaStudent) {
        this.clasaStudent = clasaStudent;
    }

    public List<Curs> getCurs() {
        return cursuri;
    }
    public void adaugaCurs(Curs curs) {
        cursuri.add(curs);
    }

    @Override
    public String toString() {
        return "Student -> " +
                "nume: " + numeStudent  +
                ", prenume: " + prenumeStudent +
                ", varsta: " + varsta
                ;
    }
}
