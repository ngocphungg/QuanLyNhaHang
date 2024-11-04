
package NhanVien;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the NhanVien package. 
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

    private final static QName _FindnvResponse_QNAME = new QName("http://ws/", "findnvResponse");
    private final static QName _GetCheckResponse_QNAME = new QName("http://ws/", "getCheckResponse");
    private final static QName _GetCheck_QNAME = new QName("http://ws/", "getCheck");
    private final static QName _GetNhanvien_QNAME = new QName("http://ws/", "getNhanvien");
    private final static QName _Findnv_QNAME = new QName("http://ws/", "findnv");
    private final static QName _GetThemnv_QNAME = new QName("http://ws/", "getThemnv");
    private final static QName _GetUpdatenv_QNAME = new QName("http://ws/", "getUpdatenv");
    private final static QName _GetNhanvienResponse_QNAME = new QName("http://ws/", "getNhanvienResponse");
    private final static QName _GetDeletenv_QNAME = new QName("http://ws/", "getDeletenv");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: NhanVien
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindnvResponse }
     * 
     */
    public FindnvResponse createFindnvResponse() {
        return new FindnvResponse();
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
     * Create an instance of {@link GetNhanvien }
     * 
     */
    public GetNhanvien createGetNhanvien() {
        return new GetNhanvien();
    }

    /**
     * Create an instance of {@link Findnv }
     * 
     */
    public Findnv createFindnv() {
        return new Findnv();
    }

    /**
     * Create an instance of {@link GetThemnv }
     * 
     */
    public GetThemnv createGetThemnv() {
        return new GetThemnv();
    }

    /**
     * Create an instance of {@link GetUpdatenv }
     * 
     */
    public GetUpdatenv createGetUpdatenv() {
        return new GetUpdatenv();
    }

    /**
     * Create an instance of {@link GetNhanvienResponse }
     * 
     */
    public GetNhanvienResponse createGetNhanvienResponse() {
        return new GetNhanvienResponse();
    }

    /**
     * Create an instance of {@link GetDeletenv }
     * 
     */
    public GetDeletenv createGetDeletenv() {
        return new GetDeletenv();
    }

    /**
     * Create an instance of {@link Nvmodel }
     * 
     */
    public Nvmodel createNvmodel() {
        return new Nvmodel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindnvResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findnvResponse")
    public JAXBElement<FindnvResponse> createFindnvResponse(FindnvResponse value) {
        return new JAXBElement<FindnvResponse>(_FindnvResponse_QNAME, FindnvResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNhanvien }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getNhanvien")
    public JAXBElement<GetNhanvien> createGetNhanvien(GetNhanvien value) {
        return new JAXBElement<GetNhanvien>(_GetNhanvien_QNAME, GetNhanvien.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Findnv }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findnv")
    public JAXBElement<Findnv> createFindnv(Findnv value) {
        return new JAXBElement<Findnv>(_Findnv_QNAME, Findnv.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetThemnv }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getThemnv")
    public JAXBElement<GetThemnv> createGetThemnv(GetThemnv value) {
        return new JAXBElement<GetThemnv>(_GetThemnv_QNAME, GetThemnv.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUpdatenv }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getUpdatenv")
    public JAXBElement<GetUpdatenv> createGetUpdatenv(GetUpdatenv value) {
        return new JAXBElement<GetUpdatenv>(_GetUpdatenv_QNAME, GetUpdatenv.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNhanvienResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getNhanvienResponse")
    public JAXBElement<GetNhanvienResponse> createGetNhanvienResponse(GetNhanvienResponse value) {
        return new JAXBElement<GetNhanvienResponse>(_GetNhanvienResponse_QNAME, GetNhanvienResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDeletenv }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getDeletenv")
    public JAXBElement<GetDeletenv> createGetDeletenv(GetDeletenv value) {
        return new JAXBElement<GetDeletenv>(_GetDeletenv_QNAME, GetDeletenv.class, null, value);
    }

}
