package model;

public class Nota {
    private Student student;
    private Curs curs;
    private double valoareNota;

    public Nota(Student student, Curs curs, double valoareNota) {
        this.student = student;
        this.curs = curs;
        this.valoareNota = valoareNota;
    }

    public Curs getCurs() {
        return curs;
    }

    public Student getStudent() {
        return student;
    }

    public double getValoareNota() {
        return valoareNota;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "student=" + student +
                ", curs=" + curs +
                ", valoareNota=" + valoareNota +
                '}';
    }
}
