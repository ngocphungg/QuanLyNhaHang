
package HoaDon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getIdhoadonsTheoNgayTang complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getIdhoadonsTheoNgayTang">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dayfrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="monthfrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="yearfrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dayto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="monthto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="yearto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getIdhoadonsTheoNgayTang", propOrder = {
    "dayfrom",
    "monthfrom",
    "yearfrom",
    "dayto",
    "monthto",
    "yearto"
})
public class GetIdhoadonsTheoNgayTang {

    protected String dayfrom;
    protected String monthfrom;
    protected String yearfrom;
    protected String dayto;
    protected String monthto;
    protected String yearto;

    /**
     * Gets the value of the dayfrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDayfrom() {
        return dayfrom;
    }

    /**
     * Sets the value of the dayfrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDayfrom(String value) {
        this.dayfrom = value;
    }

    /**
     * Gets the value of the monthfrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonthfrom() {
        return monthfrom;
    }

    /**
     * Sets the value of the monthfrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonthfrom(String value) {
        this.monthfrom = value;
    }

    /**
     * Gets the value of the yearfrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYearfrom() {
        return yearfrom;
    }

    /**
     * Sets the value of the yearfrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYearfrom(String value) {
        this.yearfrom = value;
    }

    /**
     * Gets the value of the dayto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDayto() {
        return dayto;
    }

    /**
     * Sets the value of the dayto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDayto(String value) {
        this.dayto = value;
    }

    /**
     * Gets the value of the monthto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonthto() {
        return monthto;
    }

    /**
     * Sets the value of the monthto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonthto(String value) {
        this.monthto = value;
    }

    /**
     * Gets the value of the yearto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYearto() {
        return yearto;
    }

    /**
     * Sets the value of the yearto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYearto(String value) {
        this.yearto = value;
    }

}
