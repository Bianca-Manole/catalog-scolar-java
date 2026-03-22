package app;

import model.Catalog;
import model.Clasa;
import model.Curs;
import model.Nota;
import model.Student;

import java.util.List;


public class CatalogService {
    public static void main(String[] args) {
        Clasa clasaOptaA = new Clasa("a VIII-a A");

        Curs matemtica = new Curs("Matematica", "Bianca", 8);
        Curs romana = new Curs("Romana", "Bianca", 8);
        Curs engleza = new Curs("Engleza", "Bianca", 8);

        Student sUnu = new Student("Manole", "Andreea", 14, null);
        Student sDoi = new Student("Radulescu", "Adriana", 15, null);
        Student sTrei = new Student("Ivan", "Ciprian", 13, null);
        Student sPatru = new Student("Radulescu", "Bogdan", 13, null);

        clasaOptaA.adaugaElev(sUnu);
        clasaOptaA.adaugaElev(sDoi);
        clasaOptaA.adaugaElev(sTrei);
        clasaOptaA.adaugaElev(sPatru);

        sUnu.adaugaCurs(matemtica);
        sUnu.adaugaCurs(romana);
        sUnu.adaugaCurs(engleza);

        sDoi.adaugaCurs(matemtica);
        sDoi.adaugaCurs(romana);
        sDoi.adaugaCurs(engleza);

        sTrei.adaugaCurs(matemtica);
        sTrei.adaugaCurs(romana);
        sTrei.adaugaCurs(engleza);

        sPatru.adaugaCurs(matemtica);
        sPatru.adaugaCurs(romana);
        sPatru.adaugaCurs(engleza);

        Catalog catalog = clasaOptaA.getCatalog();

        catalog.adaugaNota(sUnu, matemtica, 9);
        catalog.adaugaNota(sUnu, matemtica, 10);
        catalog.adaugaNota(sUnu, romana, 10);
        catalog.adaugaNota(sUnu, engleza, 9);

        catalog.adaugaNota(sDoi, matemtica, 8);
        catalog.adaugaNota(sDoi, romana, 8);
        catalog.adaugaNota(sDoi, romana, 8);
        catalog.adaugaNota(sDoi, engleza, 8);

        catalog.adaugaNota(sTrei, matemtica, 10);
        catalog.adaugaNota(sTrei, romana, 5);
        catalog.adaugaNota(sTrei, engleza, 10);
        catalog.adaugaNota(sTrei, engleza, 10);

        catalog.adaugaNota(sPatru, matemtica, 7);
        catalog.adaugaNota(sPatru, romana, 9);
        catalog.adaugaNota(sPatru, engleza, 8);
        catalog.adaugaNota(sPatru, engleza, 10);

        System.out.println("Elevii din clasa " + clasaOptaA.getNumeClasa());
        clasaOptaA.afiseazaElevi();
        System.out.println();


        System.out.println();
        System.out.println("Notele elevilor");
        for (Student student : clasaOptaA.getElevi()) {
            System.out.println(student.getNumeStudent() + " " + student.getPrenumeStudent());

            List<Nota> noteStudent = catalog.getNoteStudent(student);

            if (noteStudent.isEmpty()) {
                System.out.println("Nu are note");
            } else {
                for (Nota nota : noteStudent) {
                    System.out.println(" " + nota.getCurs().getNumeCurs() + " -> " + nota.getValoareNota());
                }
            }

        }

        System.out.println();
        System.out.println("Mediile elevilor la cursuri");
        for (Student student : clasaOptaA.getElevi()) {
            System.out.println(student.getNumeStudent() + " " + student.getPrenumeStudent());

            for (Curs curs : student.getCurs()) {
                double media = clasaOptaA.getCatalog().calculeazaMediaStudentLaCurs(student, curs);

                System.out.println(" " + curs.getNumeCurs() + " -> " + media);
            }
        }

        System.out.println();
        System.out.println("Media Generala a Elevilor");
        for (Student student : clasaOptaA.getElevi()) {
            double media = catalog.calculeazaMediaStudent(student);
            System.out.println(student.getNumeStudent() + " " + student.getPrenumeStudent() + " -> media generala: " + media);
        }

        System.out.println();
        System.out.println("Media clasei " + clasaOptaA.getNumeClasa());
        System.out.println(catalog.calculeazaMediaClasei(clasaOptaA.getElevi()));

        System.out.println();
        System.out.println("Clasamentul clasei " + clasaOptaA.getNumeClasa());
        List<Student> clasament = clasaOptaA.getClasament();

        for (int i = 0; i < clasament.size(); i++) {
            Student student = clasament.get(i);
            double media = catalog.calculeazaMediaStudent(student);
            System.out.println((i + 1) + ". " + student.getNumeStudent() + " " + student.getPrenumeStudent() + " -> " + media);
            // (i+1) - ca sa arate Locul 1, Locul 2, si nu Locul 0 - i fiind indexul
        }

        System.out.println();
        System.out.println("Locul 1");
        Student loculUnu = clasaOptaA.getLoculIntai();
        if (loculUnu != null) {
            double media = catalog.calculeazaMediaStudent(loculUnu);
            System.out.println(loculUnu.getNumeStudent() + " " + loculUnu.getPrenumeStudent() + " avand media generala de: " + media);
        }

        System.out.println();
        System.out.println("Locul 2");
        Student loculDoi = clasaOptaA.getLoculDoi();
        if (loculDoi != null) {
            double media = catalog.calculeazaMediaStudent(loculDoi);
            System.out.println(loculDoi.getNumeStudent() + " " + loculDoi.getPrenumeStudent() + " avand media generala de: " + media);
        }

        System.out.println();
        System.out.println("Sef de Promotie");
        Student sefDePromotie = clasaOptaA.getSefDePromotie();
        if (sefDePromotie != null) {
            double media = catalog.calculeazaMediaStudent(sefDePromotie);
            System.out.println(sefDePromotie.getNumeStudent() + " " + sefDePromotie.getPrenumeStudent() + " avand media generala de: " + media);
        } else {
            System.out.println("Nu exista Sef de Promotie");
        }

        System.out.println();
        System.out.println("Elevi cu Mentiune");
        List<Student> mentiuni = clasaOptaA.getEleviCuMentiune();
        if (mentiuni.isEmpty()) {
            System.out.println("Nu exista elevi cu mentiune");
        } else {
            for (Student student : mentiuni) {
                double media = catalog.calculeazaMediaStudent(student);
                System.out.println(student.getNumeStudent() + " " + student.getPrenumeStudent() + " -> " + media);
            }
        }
    }
}
