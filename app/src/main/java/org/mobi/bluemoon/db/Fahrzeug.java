package org.mobi.bluemoon.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Client on 12.05.2016.
 */
@Table(name = "Fahrzeug",id = "_id")
public class Fahrzeug extends Model{

    @Column(name = "id")
    private Long id;
    @Column
    private Fahrer fahrer;
    @Column
    private String marke;
    @Column
    private String kennzeichen;
    @Column
    private String zulassungLand;
    @Column
    private Versicherungsunternehmen verischerungsunternehmen;
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

    public Versicherungsunternehmen getVerischerungsunternehmen() {
        return verischerungsunternehmen;
    }

    public void setVerischerungsunternehmen(Versicherungsunternehmen verischerungsunternehmen) {
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

    public void setId(Long id) {
        this.id = id;
    }
}
