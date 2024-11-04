
package HoaDon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for doanhThuModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="doanhThuModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ngay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="soLuongHoaDon" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tongThu" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="trungBinhMoiBan" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doanhThuModel", propOrder = {
    "ngay",
    "soLuongHoaDon",
    "tongThu",
    "trungBinhMoiBan"
})
public class DoanhThuModel {

    protected String ngay;
    protected int soLuongHoaDon;
    protected float tongThu;
    protected float trungBinhMoiBan;

    /**
     * Gets the value of the ngay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNgay() {
        return ngay;
    }

    /**
     * Sets the value of the ngay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNgay(String value) {
        this.ngay = value;
    }

    /**
     * Gets the value of the soLuongHoaDon property.
     * 
     */
    public int getSoLuongHoaDon() {
        return soLuongHoaDon;
    }

    /**
     * Sets the value of the soLuongHoaDon property.
     * 
     */
    public void setSoLuongHoaDon(int value) {
        this.soLuongHoaDon = value;
    }

    /**
     * Gets the value of the tongThu property.
     * 
     */
    public float getTongThu() {
        return tongThu;
    }

    /**
     * Sets the value of the tongThu property.
     * 
     */
    public void setTongThu(float value) {
        this.tongThu = value;
    }

    /**
     * Gets the value of the trungBinhMoiBan property.
     * 
     */
    public float getTrungBinhMoiBan() {
        return trungBinhMoiBan;
    }

    /**
     * Sets the value of the trungBinhMoiBan property.
     * 
     */
    public void setTrungBinhMoiBan(float value) {
        this.trungBinhMoiBan = value;
    }

}
