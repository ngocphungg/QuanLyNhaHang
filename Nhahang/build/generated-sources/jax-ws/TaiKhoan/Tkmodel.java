
package TaiKhoan;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tkmodel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tkmodel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="matk" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quyen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tentk" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tkmodel", propOrder = {
    "matk",
    "pass",
    "quyen",
    "tentk"
})
public class Tkmodel {

    protected String matk;
    protected String pass;
    protected String quyen;
    protected String tentk;

    /**
     * Gets the value of the matk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatk() {
        return matk;
    }

    /**
     * Sets the value of the matk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatk(String value) {
        this.matk = value;
    }

    /**
     * Gets the value of the pass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPass() {
        return pass;
    }

    /**
     * Sets the value of the pass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPass(String value) {
        this.pass = value;
    }

    /**
     * Gets the value of the quyen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuyen() {
        return quyen;
    }

    /**
     * Sets the value of the quyen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuyen(String value) {
        this.quyen = value;
    }

    /**
     * Gets the value of the tentk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTentk() {
        return tentk;
    }

    /**
     * Sets the value of the tentk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTentk(String value) {
        this.tentk = value;
    }

}
