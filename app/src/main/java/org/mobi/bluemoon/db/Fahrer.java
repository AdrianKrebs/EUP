package org.mobi.bluemoon.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Client on 12.05.2016.
 */
@Table(name = "Fahrer")
public class Fahrer extends Model {
    @Column
    private String name;
    @Column
    private String vorname;
    @Column
    private String strasse;
    @Column
    private String geburtsdatum;
    @Column
    private String plz;
    @Column
    private String ort;
    @Column
    private String land;
    @Column
    private String telefon;
    @Column
    private String email;
    @Column
    private String unterschrift;
    @Column
    private String fuehrerscheinnummer;
    @Column
    private String klasse;
    @Column
    private String fuehrerscheingultigkeit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUnterschrift() {
        return unterschrift;
    }

    public void setUnterschrift(String unterschrift) {
        this.unterschrift = unterschrift;
    }

    public String getFuehrerscheinnummer() {
        return fuehrerscheinnummer;
    }

    public void setFuehrerscheinnummer(String fuehrerscheinnummer) {
        this.fuehrerscheinnummer = fuehrerscheinnummer;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

    public String getFuehrerscheingultigkeit() {
        return fuehrerscheingultigkeit;
    }

    public void setFuehrerscheingultigkeit(String fuehrerscheingultigkeit) {
        this.fuehrerscheingultigkeit = fuehrerscheingultigkeit;
    }
}
