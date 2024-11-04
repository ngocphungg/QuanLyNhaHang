
package HoaDon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCurrentHoadonID complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCurrentHoadonID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tenban" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="khuVuc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "getCurrentHoadonID", propOrder = {
    "tenban",
    "khuVuc",
    "trangthai"
})
public class GetCurrentHoadonID {

    protected String tenban;
    protected String khuVuc;
    protected String trangthai;

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
     * Gets the value of the khuVuc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKhuVuc() {
        return khuVuc;
    }

    /**
     * Sets the value of the khuVuc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKhuVuc(String value) {
        this.khuVuc = value;
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
