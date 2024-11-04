
package ChitietHD;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteChiTietHD complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteChiTietHD">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idhoadon" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "deleteChiTietHD", propOrder = {
    "idhoadon",
    "tenmon"
})
public class DeleteChiTietHD {

    protected int idhoadon;
    protected String tenmon;

    /**
     * Gets the value of the idhoadon property.
     * 
     */
    public int getIdhoadon() {
        return idhoadon;
    }

    /**
     * Sets the value of the idhoadon property.
     * 
     */
    public void setIdhoadon(int value) {
        this.idhoadon = value;
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
