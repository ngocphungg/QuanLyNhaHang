
package SanPham;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for spmodel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="spmodel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chiphi" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="donvi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="masp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ngaynhap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="soluong" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tensp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tongchiphi" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "spmodel", propOrder = {
    "chiphi",
    "donvi",
    "masp",
    "ngaynhap",
    "soluong",
    "tensp",
    "tongchiphi"
})
public class Spmodel {

    protected float chiphi;
    protected String donvi;
    protected String masp;
    protected String ngaynhap;
    protected int soluong;
    protected String tensp;
    protected float tongchiphi;

    /**
     * Gets the value of the chiphi property.
     * 
     */
    public float getChiphi() {
        return chiphi;
    }

    /**
     * Sets the value of the chiphi property.
     * 
     */
    public void setChiphi(float value) {
        this.chiphi = value;
    }

    /**
     * Gets the value of the donvi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDonvi() {
        return donvi;
    }

    /**
     * Sets the value of the donvi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDonvi(String value) {
        this.donvi = value;
    }

    /**
     * Gets the value of the masp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasp() {
        return masp;
    }

    /**
     * Sets the value of the masp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasp(String value) {
        this.masp = value;
    }

    /**
     * Gets the value of the ngaynhap property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNgaynhap() {
        return ngaynhap;
    }

    /**
     * Sets the value of the ngaynhap property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNgaynhap(String value) {
        this.ngaynhap = value;
    }

    /**
     * Gets the value of the soluong property.
     * 
     */
    public int getSoluong() {
        return soluong;
    }

    /**
     * Sets the value of the soluong property.
     * 
     */
    public void setSoluong(int value) {
        this.soluong = value;
    }

    /**
     * Gets the value of the tensp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTensp() {
        return tensp;
    }

    /**
     * Sets the value of the tensp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTensp(String value) {
        this.tensp = value;
    }

    /**
     * Gets the value of the tongchiphi property.
     * 
     */
    public float getTongchiphi() {
        return tongchiphi;
    }

    /**
     * Sets the value of the tongchiphi property.
     * 
     */
    public void setTongchiphi(float value) {
        this.tongchiphi = value;
    }

}
