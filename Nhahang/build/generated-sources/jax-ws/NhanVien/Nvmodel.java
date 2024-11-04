
package NhanVien;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nvmodel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nvmodel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chucvu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gioitinh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hoten" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="manv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quequan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sdt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nvmodel", propOrder = {
    "chucvu",
    "gioitinh",
    "hoten",
    "manv",
    "quequan",
    "sdt"
})
public class Nvmodel {

    protected String chucvu;
    protected String gioitinh;
    protected String hoten;
    protected String manv;
    protected String quequan;
    protected String sdt;

    /**
     * Gets the value of the chucvu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChucvu() {
        return chucvu;
    }

    /**
     * Sets the value of the chucvu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChucvu(String value) {
        this.chucvu = value;
    }

    /**
     * Gets the value of the gioitinh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGioitinh() {
        return gioitinh;
    }

    /**
     * Sets the value of the gioitinh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGioitinh(String value) {
        this.gioitinh = value;
    }

    /**
     * Gets the value of the hoten property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoten() {
        return hoten;
    }

    /**
     * Sets the value of the hoten property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoten(String value) {
        this.hoten = value;
    }

    /**
     * Gets the value of the manv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManv() {
        return manv;
    }

    /**
     * Sets the value of the manv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManv(String value) {
        this.manv = value;
    }

    /**
     * Gets the value of the quequan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuequan() {
        return quequan;
    }

    /**
     * Sets the value of the quequan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuequan(String value) {
        this.quequan = value;
    }

    /**
     * Gets the value of the sdt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSdt() {
        return sdt;
    }

    /**
     * Sets the value of the sdt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSdt(String value) {
        this.sdt = value;
    }

}
