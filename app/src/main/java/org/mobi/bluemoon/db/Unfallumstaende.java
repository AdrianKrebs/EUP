package org.mobi.bluemoon.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Client on 12.05.2016.
 */
@Table(name = "Unfallumstaende")
public class Unfallumstaende extends Model {
    @Column
    private Boolean parkte;
    @Column
    private Boolean veliessParkplatz_oeffnewagentuer;

    @Column
    private Boolean parkteEin;

    @Column
    private Boolean veliessParkplatzWeg;

    @Column
    private Boolean begannParkPlatz;

    @Column
    private Boolean fuhrKreisverkehrEin;

    @Column
    private Boolean fuhrKreisverkehr;

    @Column
    private Boolean heckPrall;

    @Column
    private Boolean fuhrAndereKolonne;

    @Column
    private Boolean wechselKolonne;

    @Column
    private Boolean ueberholte;

    @Column
    private Boolean bogRechts;

    @Column
    private Boolean bogLinks;

    @Column
    private Boolean setzteZurueck;

    @Column
    private Boolean wechselFahrspur;

    @Column
    private Boolean kamVonRechtsAufEineKreuzung;

    @Column
    private Boolean missAchtungVorfahrtzeichen;


    public Boolean getParkte() {
        return parkte;
    }

    public void setParkte(Boolean parkte) {
        this.parkte = parkte;
    }

    public Boolean getVeliessParkplatz_oeffnewagentuer() {
        return veliessParkplatz_oeffnewagentuer;
    }

    public void setVeliessParkplatz_oeffnewagentuer(Boolean veliessParkplatz_oeffnewagentuer) {
        this.veliessParkplatz_oeffnewagentuer = veliessParkplatz_oeffnewagentuer;
    }

    public Boolean getParkteEin() {
        return parkteEin;
    }

    public void setParkteEin(Boolean parkteEin) {
        this.parkteEin = parkteEin;
    }

    public Boolean getVeliessParkplatzWeg() {
        return veliessParkplatzWeg;
    }

    public void setVeliessParkplatzWeg(Boolean veliessParkplatzWeg) {
        this.veliessParkplatzWeg = veliessParkplatzWeg;
    }

    public Boolean getBegannParkPlatz() {
        return begannParkPlatz;
    }

    public void setBegannParkPlatz(Boolean begannParkPlatz) {
        this.begannParkPlatz = begannParkPlatz;
    }

    public Boolean getFuhrKreisverkehrEin() {
        return fuhrKreisverkehrEin;
    }

    public void setFuhrKreisverkehrEin(Boolean fuhrKreisverkehrEin) {
        this.fuhrKreisverkehrEin = fuhrKreisverkehrEin;
    }

    public Boolean getFuhrKreisverkehr() {
        return fuhrKreisverkehr;
    }

    public void setFuhrKreisverkehr(Boolean fuhrKreisverkehr) {
        this.fuhrKreisverkehr = fuhrKreisverkehr;
    }

    public Boolean getHeckPrall() {
        return heckPrall;
    }

    public void setHeckPrall(Boolean heckPrall) {
        this.heckPrall = heckPrall;
    }

    public Boolean getFuhrAndereKolonne() {
        return fuhrAndereKolonne;
    }

    public void setFuhrAndereKolonne(Boolean fuhrAndereKolonne) {
        this.fuhrAndereKolonne = fuhrAndereKolonne;
    }

    public Boolean getWechselKolonne() {
        return wechselKolonne;
    }

    public void setWechselKolonne(Boolean wechselKolonne) {
        this.wechselKolonne = wechselKolonne;
    }

    public Boolean getUeberholte() {
        return ueberholte;
    }

    public void setUeberholte(Boolean ueberholte) {
        this.ueberholte = ueberholte;
    }

    public Boolean getBogRechts() {
        return bogRechts;
    }

    public void setBogRechts(Boolean bogRechts) {
        this.bogRechts = bogRechts;
    }

    public Boolean getBogLinks() {
        return bogLinks;
    }

    public void setBogLinks(Boolean bogLinks) {
        this.bogLinks = bogLinks;
    }

    public Boolean getSetzteZurueck() {
        return setzteZurueck;
    }

    public void setSetzteZurueck(Boolean setzteZurueck) {
        this.setzteZurueck = setzteZurueck;
    }

    public Boolean getWechselFahrspur() {
        return wechselFahrspur;
    }

    public void setWechselFahrspur(Boolean wechselFahrspur) {
        this.wechselFahrspur = wechselFahrspur;
    }

    public Boolean getKamVonRechtsAufEineKreuzung() {
        return kamVonRechtsAufEineKreuzung;
    }

    public void setKamVonRechtsAufEineKreuzung(Boolean kamVonRechtsAufEineKreuzung) {
        this.kamVonRechtsAufEineKreuzung = kamVonRechtsAufEineKreuzung;
    }

    public Boolean getMissAchtungVorfahrtzeichen() {
        return missAchtungVorfahrtzeichen;
    }

    public void setMissAchtungVorfahrtzeichen(Boolean missAchtungVorfahrtzeichen) {
        this.missAchtungVorfahrtzeichen = missAchtungVorfahrtzeichen;
    }
}
