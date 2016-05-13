package org.mobi.bluemoon.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Client on 12.05.2016.
 */
@Table(name = "Fahrzeug")
public class Fahrzeug extends Model{
    @Column
    private int fahrzeugId;
    @Column
    private String marke;
    @Column
    private String kennzeichen;
    @Column
    private String zulassungLand;
    @Column
    private String sichtbareschaden;
    @Column
    private String eigeneBemerkungen;

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

    public int getFahrzeugId() {
        return fahrzeugId;
    }

    public void setFahrzeugId(int fahrzeugId) {
        this.fahrzeugId = fahrzeugId;
    }
}
