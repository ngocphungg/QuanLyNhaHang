
package ThucDon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for giaMon complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="giaMon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
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
@XmlType(name = "giaMon", propOrder = {
    "tenmon"
})
public class GiaMon {

    protected String tenmon;

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
