
package ChitietHD;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for chitiethdmodel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="chitiethdmodel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idhd" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="soluong" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tenmon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="thanhtien" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="theloai" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chitiethdmodel", propOrder = {
    "idhd",
    "soluong",
    "tenmon",
    "thanhtien",
    "theloai"
})
public class Chitiethdmodel {

    protected int idhd;
    protected int soluong;
    protected String tenmon;
    protected float thanhtien;
    protected String theloai;

    /**
     * Gets the value of the idhd property.
     * 
     */
    public int getIdhd() {
        return idhd;
    }

    /**
     * Sets the value of the idhd property.
     * 
     */
    public void setIdhd(int value) {
        this.idhd = value;
    }

    /**
     * Gets the value of the soluong property.
     * 
     */
    public int getSoluong() {
        return soluong;
    }

    /**
     * Sets the value of the soluong property.
     * 
     */
    public void setSoluong(int value) {
        this.soluong = value;
    }

    /**
     * Gets the value of the tenmon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenmon() {
        return tenmon;
    }

    /**
     * Sets the value of the tenmon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenmon(String value) {
        this.tenmon = value;
    }

    /**
     * Gets the value of the thanhtien property.
     * 
     */
    public float getThanhtien() {
        return thanhtien;
    }

    /**
     * Sets the value of the thanhtien property.
     * 
     */
    public void setThanhtien(float value) {
        this.thanhtien = value;
    }

    /**
     * Gets the value of the theloai property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTheloai() {
        return theloai;
    }

    /**
     * Sets the value of the theloai property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTheloai(String value) {
        this.theloai = value;
    }

}
