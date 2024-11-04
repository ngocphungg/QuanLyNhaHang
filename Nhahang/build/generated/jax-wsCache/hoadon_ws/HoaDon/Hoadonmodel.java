
package HoaDon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for hoadonmodel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="hoadonmodel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gioden" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="giove" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="khuvuc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mahd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tenban" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tongtien" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="trangthai" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hoadonmodel", propOrder = {
    "gioden",
    "giove",
    "khuvuc",
    "mahd",
    "tenban",
    "tongtien",
    "trangthai"
})
public class Hoadonmodel {

    protected String gioden;
    protected String giove;
    protected String khuvuc;
    protected String mahd;
    protected String tenban;
    protected float tongtien;
    protected String trangthai;

    /**
     * Gets the value of the gioden property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGioden() {
        return gioden;
    }

    /**
     * Sets the value of the gioden property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGioden(String value) {
        this.gioden = value;
    }

    /**
     * Gets the value of the giove property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGiove() {
        return giove;
    }

    /**
     * Sets the value of the giove property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGiove(String value) {
        this.giove = value;
    }

    /**
     * Gets the value of the khuvuc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKhuvuc() {
        return khuvuc;
    }

    /**
     * Sets the value of the khuvuc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKhuvuc(String value) {
        this.khuvuc = value;
    }

    /**
     * Gets the value of the mahd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMahd() {
        return mahd;
    }

    /**
     * Sets the value of the mahd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMahd(String value) {
        this.mahd = value;
    }

    /**
     * Gets the value of the tenban property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenban() {
        return tenban;
    }

    /**
     * Sets the value of the tenban property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenban(String value) {
        this.tenban = value;
    }

    /**
     * Gets the value of the tongtien property.
     * 
     */
    public float getTongtien() {
        return tongtien;
    }

    /**
     * Sets the value of the tongtien property.
     * 
     */
    public void setTongtien(float value) {
        this.tongtien = value;
    }

    /**
     * Gets the value of the trangthai property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrangthai() {
        return trangthai;
    }

    /**
     * Sets the value of the trangthai property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrangthai(String value) {
        this.trangthai = value;
    }

}
