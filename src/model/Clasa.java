package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clasa {
    private String numeClasa;
    private List<Student> elevi;
    private Catalog catalog;

    public Clasa(String numeClasa) {
        this.numeClasa = numeClasa;
        this.elevi = new ArrayList<>();
        this.catalog = new Catalog();
    }

    public String getNumeClasa() {
        return numeClasa;
    }

    public void setNumeClasa(String numeClasa) {
        this.numeClasa = numeClasa;
    }

    public List<Student> getElevi() {
        return elevi;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void adaugaElev(Student student){
        elevi.add(student);
        student.setClasaStudent(this);
    }

    public void afiseazaElevi() {
        for(Student student:elevi){
            System.out.println(student);

        }
    }

    public List<Student> getClasament() {
        List<Student> clasament = new ArrayList<>(elevi); // fac copie la lista elevi
        clasament.sort(
                Comparator.comparingDouble( // comparator care sorteaza obiecte dupa un double
                        (Student student) -> catalog.calculeazaMediaStudent(student) // lambda - spune ce compara
                ).reversed()); // - reverse pune descrescator, by default e crescator
        return clasament;
    }

    public Student getLoculIntai(){
        List<Student> clasament = getClasament();
        if(clasament.isEmpty()){
            return null;
        }
        return clasament.get(0);
        }

    public Student getLoculDoi(){
        List<Student> clasament = getClasament();
            if(clasament.size()< 2){
                return null;
            }
        return clasament.get(1);
        }

    public Student getSefDePromotie() {
        Student sef = null;
        double mediaMax = 0;

        for(Student elev:elevi) {
            double media = catalog.calculeazaMediaStudent(elev);

            if(media >= 9.50 && media > mediaMax) {
                mediaMax = media;
                sef = elev;
            }
        }
        return sef;
    }

    public List<Student> getEleviCuMentiune(){
        List<Student> rezultat = new ArrayList<>();

        Student elevLoculDoi = getLoculDoi();
        if(elevLoculDoi == null) {
            return rezultat;
        }

        double mediaLoculDoi = catalog.calculeazaMediaStudent(elevLoculDoi);

        for(Student elev:elevi) {
            double mediaElev = catalog.calculeazaMediaStudent(elev);

            if(mediaElev >= 8.00 && mediaElev < mediaLoculDoi){
                rezultat.add(elev);
            }
        }
        return rezultat;
    }

    @Override
    public String toString() {
        return "Clasa{" +
                "numeClasa='" + numeClasa + '\'' +
                ", elevi=" + elevi +
                ", catalog=" + catalog +
                '}';
    }
}


