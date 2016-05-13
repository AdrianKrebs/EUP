package org.mobi.bluemoon.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

/**
 * Created by Client on 12.05.2016.
 */
@Table(name = "Unfall")
public class Unfall extends Model{
    @Column
    private String datum;
    @Column
    private String zeit;
    @Column
    private String ort;
    @Column
    private String land;
    @Column
    private String ort_zusatz;
    @Column
    private Boolean verletzte;
    @Column
    private Boolean sachschaden_dritte_fahrzeug;
    @Column
    private Boolean gegenstaende;
    @Column
    private String zeugen;
    @Column
    private Fahrzeug fahrzeugA;
    @Column
    private Fahrzeug fahrzeugB;
    @Column
    private Unfallumstaende unfallumstaende;

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getZeit() {
        return zeit;
    }

    public void setZeit(String zeit) {
        this.zeit = zeit;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getOrt_zusatz() {
        return ort_zusatz;
    }

    public void setOrt_zusatz(String ort_zusatz) {
        this.ort_zusatz = ort_zusatz;
    }

    public Boolean getVerletzte() {
        return verletzte;
    }

    public void setVerletzte(Boolean verletzte) {
        this.verletzte = verletzte;
    }

    public Boolean getSachschaden_dritte_fahrzeug() {
        return sachschaden_dritte_fahrzeug;
    }

    public void setSachschaden_dritte_fahrzeug(Boolean sachschaden_dritte_fahrzeug) {
        this.sachschaden_dritte_fahrzeug = sachschaden_dritte_fahrzeug;
    }

    public Boolean getGegenstaende() {
        return gegenstaende;
    }

    public void setGegenstaende(Boolean gegenstaende) {
        this.gegenstaende = gegenstaende;
    }

    public String getZeugen() {
        return zeugen;
    }

    public void setZeugen(String zeugen) {
        this.zeugen = zeugen;
    }

    public Fahrzeug getFahrzeugA() {
        return fahrzeugA;
    }

    public void setFahrzeugA(Fahrzeug fahrzeugA) {
        this.fahrzeugA = fahrzeugA;
    }

    public Fahrzeug getFahrzeugB() {
        return fahrzeugB;
    }

    public void setFahrzeugB(Fahrzeug fahrzeugB) {
        this.fahrzeugB = fahrzeugB;
    }

    public Unfallumstaende getUnfallumstaende() {
        return unfallumstaende;
    }

    public void setUnfallumstaende(Unfallumstaende unfallumstaende) {
        this.unfallumstaende = unfallumstaende;
    }
}
