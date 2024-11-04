
package DoanhThuNgay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addNewDoanhThuNgay complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addNewDoanhThuNgay">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ngay" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="thang" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nam" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tongTien" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addNewDoanhThuNgay", propOrder = {
    "ngay",
    "thang",
    "nam",
    "tongTien"
})
public class AddNewDoanhThuNgay {

    protected int ngay;
    protected int thang;
    protected int nam;
    protected float tongTien;

    /**
     * Gets the value of the ngay property.
     * 
     */
    public int getNgay() {
        return ngay;
    }

    /**
     * Sets the value of the ngay property.
     * 
     */
    public void setNgay(int value) {
        this.ngay = value;
    }

    /**
     * Gets the value of the thang property.
     * 
     */
    public int getThang() {
        return thang;
    }

    /**
     * Sets the value of the thang property.
     * 
     */
    public void setThang(int value) {
        this.thang = value;
    }

    /**
     * Gets the value of the nam property.
     * 
     */
    public int getNam() {
        return nam;
    }

    /**
     * Sets the value of the nam property.
     * 
     */
    public void setNam(int value) {
        this.nam = value;
    }

    /**
     * Gets the value of the tongTien property.
     * 
     */
    public float getTongTien() {
        return tongTien;
    }

    /**
     * Sets the value of the tongTien property.
     * 
     */
    public void setTongTien(float value) {
        this.tongTien = value;
    }

}
