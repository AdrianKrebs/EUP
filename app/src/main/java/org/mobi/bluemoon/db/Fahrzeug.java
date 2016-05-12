package org.mobi.bluemoon.db;

import android.graphics.AvoidXfermode;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Client on 12.05.2016.
 */
@Table(name = "Fahrzeug")
public class Fahrzeug extends Model{
    @Column
    private Fahrer fahrer;
    @Column
    private String marke;
    @Column
    private String kennzeichen;
    @Column
    private String zulassungLand;
    @Column
    private Verischerungsunternehmen verischerungsunternehmen;
    @Column
    private String sichtbareschaden;
    @Column
    private String eigeneBemerkungen;

    public Fahrer getFahrer() {
        return fahrer;
    }

    public void setFahrer(Fahrer fahrer) {
        this.fahrer = fahrer;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public String getZulassungLand() {
        return zulassungLand;
    }

    public void setZulassungLand(String zulassungLand) {
        this.zulassungLand = zulassungLand;
    }

    public Verischerungsunternehmen getVerischerungsunternehmen() {
        return verischerungsunternehmen;
    }

    public void setVerischerungsunternehmen(Verischerungsunternehmen verischerungsunternehmen) {
        this.verischerungsunternehmen = verischerungsunternehmen;
    }

    public String getSichtbareschaden() {
        return sichtbareschaden;
    }

    public void setSichtbareschaden(String sichtbareschaden) {
        this.sichtbareschaden = sichtbareschaden;
    }

    public String getEigeneBemerkungen() {
        return eigeneBemerkungen;
    }

    public void setEigeneBemerkungen(String eigeneBemerkungen) {
        this.eigeneBemerkungen = eigeneBemerkungen;
    }
}
