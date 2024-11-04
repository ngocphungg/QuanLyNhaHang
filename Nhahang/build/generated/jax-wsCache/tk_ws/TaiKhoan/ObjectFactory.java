
package TaiKhoan;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the TaiKhoan package. 
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

    private final static QName _GetCheckResponse_QNAME = new QName("http://ws/", "getCheckResponse");
    private final static QName _GetCheck_QNAME = new QName("http://ws/", "getCheck");
    private final static QName _Findtk_QNAME = new QName("http://ws/", "findtk");
    private final static QName _GetTaikhoan_QNAME = new QName("http://ws/", "getTaikhoan");
    private final static QName _GetUpdatetk_QNAME = new QName("http://ws/", "getUpdatetk");
    private final static QName _FindtkResponse_QNAME = new QName("http://ws/", "findtkResponse");
    private final static QName _GetTaikhoanResponse_QNAME = new QName("http://ws/", "getTaikhoanResponse");
    private final static QName _GetThemtk_QNAME = new QName("http://ws/", "getThemtk");
    private final static QName _GetDeletetk_QNAME = new QName("http://ws/", "getDeletetk");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: TaiKhoan
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCheckResponse }
     * 
     */
    public GetCheckResponse createGetCheckResponse() {
        return new GetCheckResponse();
    }

    /**
     * Create an instance of {@link GetCheck }
     * 
     */
    public GetCheck createGetCheck() {
        return new GetCheck();
    }

    /**
     * Create an instance of {@link Findtk }
     * 
     */
    public Findtk createFindtk() {
        return new Findtk();
    }

    /**
     * Create an instance of {@link GetTaikhoan }
     * 
     */
    public GetTaikhoan createGetTaikhoan() {
        return new GetTaikhoan();
    }

    /**
     * Create an instance of {@link GetUpdatetk }
     * 
     */
    public GetUpdatetk createGetUpdatetk() {
        return new GetUpdatetk();
    }

    /**
     * Create an instance of {@link FindtkResponse }
     * 
     */
    public FindtkResponse createFindtkResponse() {
        return new FindtkResponse();
    }

    /**
     * Create an instance of {@link GetTaikhoanResponse }
     * 
     */
    public GetTaikhoanResponse createGetTaikhoanResponse() {
        return new GetTaikhoanResponse();
    }

    /**
     * Create an instance of {@link GetThemtk }
     * 
     */
    public GetThemtk createGetThemtk() {
        return new GetThemtk();
    }

    /**
     * Create an instance of {@link GetDeletetk }
     * 
     */
    public GetDeletetk createGetDeletetk() {
        return new GetDeletetk();
    }

    /**
     * Create an instance of {@link Tkmodel }
     * 
     */
    public Tkmodel createTkmodel() {
        return new Tkmodel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCheckResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getCheckResponse")
    public JAXBElement<GetCheckResponse> createGetCheckResponse(GetCheckResponse value) {
        return new JAXBElement<GetCheckResponse>(_GetCheckResponse_QNAME, GetCheckResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCheck }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getCheck")
    public JAXBElement<GetCheck> createGetCheck(GetCheck value) {
        return new JAXBElement<GetCheck>(_GetCheck_QNAME, GetCheck.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Findtk }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findtk")
    public JAXBElement<Findtk> createFindtk(Findtk value) {
        return new JAXBElement<Findtk>(_Findtk_QNAME, Findtk.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTaikhoan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getTaikhoan")
    public JAXBElement<GetTaikhoan> createGetTaikhoan(GetTaikhoan value) {
        return new JAXBElement<GetTaikhoan>(_GetTaikhoan_QNAME, GetTaikhoan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUpdatetk }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getUpdatetk")
    public JAXBElement<GetUpdatetk> createGetUpdatetk(GetUpdatetk value) {
        return new JAXBElement<GetUpdatetk>(_GetUpdatetk_QNAME, GetUpdatetk.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindtkResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findtkResponse")
    public JAXBElement<FindtkResponse> createFindtkResponse(FindtkResponse value) {
        return new JAXBElement<FindtkResponse>(_FindtkResponse_QNAME, FindtkResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTaikhoanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getTaikhoanResponse")
    public JAXBElement<GetTaikhoanResponse> createGetTaikhoanResponse(GetTaikhoanResponse value) {
        return new JAXBElement<GetTaikhoanResponse>(_GetTaikhoanResponse_QNAME, GetTaikhoanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetThemtk }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getThemtk")
    public JAXBElement<GetThemtk> createGetThemtk(GetThemtk value) {
        return new JAXBElement<GetThemtk>(_GetThemtk_QNAME, GetThemtk.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDeletetk }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getDeletetk")
    public JAXBElement<GetDeletetk> createGetDeletetk(GetDeletetk value) {
        return new JAXBElement<GetDeletetk>(_GetDeletetk_QNAME, GetDeletetk.class, null, value);
    }

}
