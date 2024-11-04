
package ThucDon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for theloaimodel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="theloaimodel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
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
@XmlType(name = "theloaimodel", propOrder = {
    "theloai"
})
public class Theloaimodel {

    protected String theloai;

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
