
package HoaDon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateTotalAmount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateTotalAmount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idhoadon" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateTotalAmount", propOrder = {
    "idhoadon",
    "totalAmount"
})
public class UpdateTotalAmount {

    protected int idhoadon;
    protected float totalAmount;

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
     * Gets the value of the totalAmount property.
     * 
     */
    public float getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the value of the totalAmount property.
     * 
     */
    public void setTotalAmount(float value) {
        this.totalAmount = value;
    }

}
