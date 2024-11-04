
package DoanhThuNgay;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the DoanhThuNgay package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _IsDateExistInDoanhThuNgayResponse_QNAME = new QName("http://ws/", "isDateExistInDoanhThuNgayResponse");
    private final static QName _IsDateExistInDoanhThuNgay_QNAME = new QName("http://ws/", "isDateExistInDoanhThuNgay");
    private final static QName _AddNewDoanhThuNgay_QNAME = new QName("http://ws/", "addNewDoanhThuNgay");
    private final static QName _GetDoanhThuNgay_QNAME = new QName("http://ws/", "getDoanhThuNgay");
    private final static QName _GetTongThuCuaNgayResponse_QNAME = new QName("http://ws/", "getTongThuCuaNgayResponse");
    private final static QName _GetTongThuCuaNgay_QNAME = new QName("http://ws/", "getTongThuCuaNgay");
    private final static QName _UpdateTongTienDoanhThuNgay_QNAME = new QName("http://ws/", "updateTongTienDoanhThuNgay");
    private final static QName _GetDoanhThuNgayResponse_QNAME = new QName("http://ws/", "getDoanhThuNgayResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: DoanhThuNgay
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IsDateExistInDoanhThuNgayResponse }
     * 
     */
    public IsDateExistInDoanhThuNgayResponse createIsDateExistInDoanhThuNgayResponse() {
        return new IsDateExistInDoanhThuNgayResponse();
    }

    /**
     * Create an instance of {@link IsDateExistInDoanhThuNgay }
     * 
     */
    public IsDateExistInDoanhThuNgay createIsDateExistInDoanhThuNgay() {
        return new IsDateExistInDoanhThuNgay();
    }

    /**
     * Create an instance of {@link AddNewDoanhThuNgay }
     * 
     */
    public AddNewDoanhThuNgay createAddNewDoanhThuNgay() {
        return new AddNewDoanhThuNgay();
    }

    /**
     * Create an instance of {@link GetDoanhThuNgay }
     * 
     */
    public GetDoanhThuNgay createGetDoanhThuNgay() {
        return new GetDoanhThuNgay();
    }

    /**
     * Create an instance of {@link GetTongThuCuaNgayResponse }
     * 
     */
    public GetTongThuCuaNgayResponse createGetTongThuCuaNgayResponse() {
        return new GetTongThuCuaNgayResponse();
    }

    /**
     * Create an instance of {@link GetTongThuCuaNgay }
     * 
     */
    public GetTongThuCuaNgay createGetTongThuCuaNgay() {
        return new GetTongThuCuaNgay();
    }

    /**
     * Create an instance of {@link UpdateTongTienDoanhThuNgay }
     * 
     */
    public UpdateTongTienDoanhThuNgay createUpdateTongTienDoanhThuNgay() {
        return new UpdateTongTienDoanhThuNgay();
    }

    /**
     * Create an instance of {@link GetDoanhThuNgayResponse }
     * 
     */
    public GetDoanhThuNgayResponse createGetDoanhThuNgayResponse() {
        return new GetDoanhThuNgayResponse();
    }

    /**
     * Create an instance of {@link Dtngaymodel }
     * 
     */
    public Dtngaymodel createDtngaymodel() {
        return new Dtngaymodel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsDateExistInDoanhThuNgayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "isDateExistInDoanhThuNgayResponse")
    public JAXBElement<IsDateExistInDoanhThuNgayResponse> createIsDateExistInDoanhThuNgayResponse(IsDateExistInDoanhThuNgayResponse value) {
        return new JAXBElement<IsDateExistInDoanhThuNgayResponse>(_IsDateExistInDoanhThuNgayResponse_QNAME, IsDateExistInDoanhThuNgayResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsDateExistInDoanhThuNgay }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "isDateExistInDoanhThuNgay")
    public JAXBElement<IsDateExistInDoanhThuNgay> createIsDateExistInDoanhThuNgay(IsDateExistInDoanhThuNgay value) {
        return new JAXBElement<IsDateExistInDoanhThuNgay>(_IsDateExistInDoanhThuNgay_QNAME, IsDateExistInDoanhThuNgay.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNewDoanhThuNgay }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "addNewDoanhThuNgay")
    public JAXBElement<AddNewDoanhThuNgay> createAddNewDoanhThuNgay(AddNewDoanhThuNgay value) {
        return new JAXBElement<AddNewDoanhThuNgay>(_AddNewDoanhThuNgay_QNAME, AddNewDoanhThuNgay.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDoanhThuNgay }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getDoanhThuNgay")
    public JAXBElement<GetDoanhThuNgay> createGetDoanhThuNgay(GetDoanhThuNgay value) {
        return new JAXBElement<GetDoanhThuNgay>(_GetDoanhThuNgay_QNAME, GetDoanhThuNgay.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTongThuCuaNgayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getTongThuCuaNgayResponse")
    public JAXBElement<GetTongThuCuaNgayResponse> createGetTongThuCuaNgayResponse(GetTongThuCuaNgayResponse value) {
        return new JAXBElement<GetTongThuCuaNgayResponse>(_GetTongThuCuaNgayResponse_QNAME, GetTongThuCuaNgayResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTongThuCuaNgay }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getTongThuCuaNgay")
    public JAXBElement<GetTongThuCuaNgay> createGetTongThuCuaNgay(GetTongThuCuaNgay value) {
        return new JAXBElement<GetTongThuCuaNgay>(_GetTongThuCuaNgay_QNAME, GetTongThuCuaNgay.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateTongTienDoanhThuNgay }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "updateTongTienDoanhThuNgay")
    public JAXBElement<UpdateTongTienDoanhThuNgay> createUpdateTongTienDoanhThuNgay(UpdateTongTienDoanhThuNgay value) {
        return new JAXBElement<UpdateTongTienDoanhThuNgay>(_UpdateTongTienDoanhThuNgay_QNAME, UpdateTongTienDoanhThuNgay.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDoanhThuNgayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getDoanhThuNgayResponse")
    public JAXBElement<GetDoanhThuNgayResponse> createGetDoanhThuNgayResponse(GetDoanhThuNgayResponse value) {
        return new JAXBElement<GetDoanhThuNgayResponse>(_GetDoanhThuNgayResponse_QNAME, GetDoanhThuNgayResponse.class, null, value);
    }

}
