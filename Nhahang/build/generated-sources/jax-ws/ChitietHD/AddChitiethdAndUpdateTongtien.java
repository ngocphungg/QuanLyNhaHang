
package ChitietHD;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addChitiethdAndUpdateTongtien complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addChitiethdAndUpdateTongtien">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idhoadon" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tenmon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="soluong" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="thanhtien" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="loaiMon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addChitiethdAndUpdateTongtien", propOrder = {
    "idhoadon",
    "tenmon",
    "soluong",
    "thanhtien",
    "loaiMon"
})
public class AddChitiethdAndUpdateTongtien {

    protected int idhoadon;
    protected String tenmon;
    protected int soluong;
    protected float thanhtien;
    protected String loaiMon;

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
     * Gets the value of the thanhtien property.
     * 
     */
    public float getThanhtien() {
        return thanhtien;
    }

    /**
     * Sets the value of the thanhtien property.
     * 
     */
    public void setThanhtien(float value) {
        this.thanhtien = value;
    }

    /**
     * Gets the value of the loaiMon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoaiMon() {
        return loaiMon;
    }

    /**
     * Sets the value of the loaiMon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoaiMon(String value) {
        this.loaiMon = value;
    }

}
