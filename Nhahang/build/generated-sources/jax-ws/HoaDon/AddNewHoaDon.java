
package HoaDon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addNewHoaDon complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addNewHoaDon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tenban" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gioden" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="khuvuc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tongtien" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addNewHoaDon", propOrder = {
    "tenban",
    "gioden",
    "khuvuc",
    "tongtien"
})
public class AddNewHoaDon {

    protected String tenban;
    protected String gioden;
    protected String khuvuc;
    protected float tongtien;

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

}
