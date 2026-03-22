package model;

public class Curs {
    private String numeCurs;
    private String numeProfesor;
    private int orePeSaptamana;

    public Curs(String numeCurs, String numeProfesor, int orePeSaptamana) {
        this.numeCurs = numeCurs;
        this.numeProfesor = numeProfesor;
        this.orePeSaptamana = orePeSaptamana;
    }

    public String getNumeCurs() {
        return numeCurs;
    }

    public void setNumeCurs(String numeCurs) {
        this.numeCurs = numeCurs;
    }

    public String getNumeProfesor() {
        return numeProfesor;
    }

    public void setNumeProfesor(String numeProfesor) {
        this.numeProfesor = numeProfesor;
    }

    public int getOrePeSaptamana() {
        return orePeSaptamana;
    }

    public void setOrePeSaptamana(int orePeSaptamana) {
        this.orePeSaptamana = orePeSaptamana;
    }

    @Override
    public String toString() {
        return "Curs{" +
                "numeCurs='" + numeCurs + '\'' +
                ", numeProfesor='" + numeProfesor + '\'' +
                ", orePeSaptamana=" + orePeSaptamana +
                '}';
    }
}
