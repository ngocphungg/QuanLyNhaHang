
package DoanhThu;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dtmodel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dtmodel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nam" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="thang" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tien" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtmodel", propOrder = {
    "nam",
    "thang",
    "tien"
})
public class Dtmodel {

    protected int nam;
    protected int thang;
    protected int tien;

    /**
     * Gets the value of the nam property.
     * 
     */
    public int getNam() {
        return nam;
    }

    /**
     * Sets the value of the nam property.
     * 
     */
    public void setNam(int value) {
        this.nam = value;
    }

    /**
     * Gets the value of the thang property.
     * 
     */
    public int getThang() {
        return thang;
    }

    /**
     * Sets the value of the thang property.
     * 
     */
    public void setThang(int value) {
        this.thang = value;
    }

    /**
     * Gets the value of the tien property.
     * 
     */
    public int getTien() {
        return tien;
    }

    /**
     * Sets the value of the tien property.
     * 
     */
    public void setTien(int value) {
        this.tien = value;
    }

}
