
package ThucDon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tdmodel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tdmodel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="giathanh" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="loai" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mamon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tenmon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tdmodel", propOrder = {
    "giathanh",
    "loai",
    "mamon",
    "tenmon"
})
public class Tdmodel {

    protected float giathanh;
    protected String loai;
    protected String mamon;
    protected String tenmon;

    /**
     * Gets the value of the giathanh property.
     * 
     */
    public float getGiathanh() {
        return giathanh;
    }

    /**
     * Sets the value of the giathanh property.
     * 
     */
    public void setGiathanh(float value) {
        this.giathanh = value;
    }

    /**
     * Gets the value of the loai property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoai() {
        return loai;
    }

    /**
     * Sets the value of the loai property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoai(String value) {
        this.loai = value;
    }

    /**
     * Gets the value of the mamon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMamon() {
        return mamon;
    }

    /**
     * Sets the value of the mamon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMamon(String value) {
        this.mamon = value;
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

}
