package org.mobi.bluemoon.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Client on 12.05.2016.
 */
@Table(name = "Versicherungsunternehmen")
public class Versicherungsunternehmen extends Model{

    @Column
    private int versicherungsunternehmenId;
    @Column
    private String name;
    @Column
    private String vertragsnummer;
    @Column
    private String NummerdergrueneKarte;
    @Column
    private String geschaeftsstelle;
    @Column
    private String anschrift;
    @Column
    private String telefon;
    @Column
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVertragsnummer() {
        return vertragsnummer;
    }

    public void setVertragsnummer(String vertragsnummer) {
        this.vertragsnummer = vertragsnummer;
    }

    public String getNummerdergrueneKarte() {
        return NummerdergrueneKarte;
    }

    public void setNummerdergrueneKarte(String nummerdergrueneKarte) {
        NummerdergrueneKarte = nummerdergrueneKarte;
    }

    public String getGeschaeftsstelle() {
        return geschaeftsstelle;
    }

    public void setGeschaeftsstelle(String geschaeftsstelle) {
        this.geschaeftsstelle = geschaeftsstelle;
    }

    public String getAnschrift() {
        return anschrift;
    }

    public void setAnschrift(String anschrift) {
        this.anschrift = anschrift;
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

    public int getVersicherungsunternehmenId() {
        return versicherungsunternehmenId;
    }

    public void setVersicherungsunternehmenId(int versicherungsunternehmenId) {
        this.versicherungsunternehmenId = versicherungsunternehmenId;
    }

}
