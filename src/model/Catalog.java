package model;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Nota> note;

    public Catalog() {
        this.note = new ArrayList<>();
    }

    public List<Nota> getNote() {
        return note;
    }

    public void adaugaNota(Student student,  Curs curs, double valoareNota) {
        Nota nota = new Nota(student, curs, valoareNota);
        note.add(nota);
    }

    public List<Nota> getNoteStudent(Student student) {
        List<Nota> rezultat = new ArrayList<>();
        for(Nota n:note){
            if(n.getStudent().equals(student)){
                rezultat.add(n);
            }
        }
        return rezultat;
    }

    public List<Nota> getNoteStudentLaCurs(Student student, Curs curs) {
        List<Nota> rezultat = new ArrayList<>();

        for(Nota n:note){
            if(n.getStudent().equals(student) && n.getCurs().equals(curs)){
                rezultat.add(n);
            }
        }
        return rezultat;
    }

    public double calculeazaMediaStudent(Student student){
        List<Nota> lista = getNoteStudent(student);

        if(lista.isEmpty()){
            return 0;
        }
        double suma = 0;

        for(Nota n:lista){
            suma+= n.getValoareNota();
        }
        return suma / lista.size();
    }

    public double calculeazaMediaStudentLaCurs(Student student, Curs curs){
        List<Nota> lista = getNoteStudentLaCurs(student, curs);

        if(lista.isEmpty()){
            return 0;
        }
        double suma = 0;

        for(Nota n:lista){
            suma+= n.getValoareNota();
        }
        return suma / lista.size();
    }

    public double calculeazaMediaClasei(List<Student> elevi) {
        if(elevi.isEmpty()){
            return 0;
        }
        double sumaMedie = 0;
        for(Student s:elevi){
            sumaMedie += calculeazaMediaStudent(s);
        }
        return sumaMedie / elevi.size();
    }

}
