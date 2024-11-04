
package SanPham;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the SanPham package. 
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
    private final static QName _FindspResponse_QNAME = new QName("http://ws/", "findspResponse");
    private final static QName _GetCheck_QNAME = new QName("http://ws/", "getCheck");
    private final static QName _GetUpdatesp_QNAME = new QName("http://ws/", "getUpdatesp");
    private final static QName _GetDeletesp_QNAME = new QName("http://ws/", "getDeletesp");
    private final static QName _GetSanpham_QNAME = new QName("http://ws/", "getSanpham");
    private final static QName _GetSanphamResponse_QNAME = new QName("http://ws/", "getSanphamResponse");
    private final static QName _GetThemsp_QNAME = new QName("http://ws/", "getThemsp");
    private final static QName _Findsp_QNAME = new QName("http://ws/", "findsp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: SanPham
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
     * Create an instance of {@link FindspResponse }
     * 
     */
    public FindspResponse createFindspResponse() {
        return new FindspResponse();
    }

    /**
     * Create an instance of {@link GetCheck }
     * 
     */
    public GetCheck createGetCheck() {
        return new GetCheck();
    }

    /**
     * Create an instance of {@link GetUpdatesp }
     * 
     */
    public GetUpdatesp createGetUpdatesp() {
        return new GetUpdatesp();
    }

    /**
     * Create an instance of {@link GetDeletesp }
     * 
     */
    public GetDeletesp createGetDeletesp() {
        return new GetDeletesp();
    }

    /**
     * Create an instance of {@link GetSanpham }
     * 
     */
    public GetSanpham createGetSanpham() {
        return new GetSanpham();
    }

    /**
     * Create an instance of {@link GetSanphamResponse }
     * 
     */
    public GetSanphamResponse createGetSanphamResponse() {
        return new GetSanphamResponse();
    }

    /**
     * Create an instance of {@link GetThemsp }
     * 
     */
    public GetThemsp createGetThemsp() {
        return new GetThemsp();
    }

    /**
     * Create an instance of {@link Findsp }
     * 
     */
    public Findsp createFindsp() {
        return new Findsp();
    }

    /**
     * Create an instance of {@link Spmodel }
     * 
     */
    public Spmodel createSpmodel() {
        return new Spmodel();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FindspResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findspResponse")
    public JAXBElement<FindspResponse> createFindspResponse(FindspResponse value) {
        return new JAXBElement<FindspResponse>(_FindspResponse_QNAME, FindspResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUpdatesp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getUpdatesp")
    public JAXBElement<GetUpdatesp> createGetUpdatesp(GetUpdatesp value) {
        return new JAXBElement<GetUpdatesp>(_GetUpdatesp_QNAME, GetUpdatesp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDeletesp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getDeletesp")
    public JAXBElement<GetDeletesp> createGetDeletesp(GetDeletesp value) {
        return new JAXBElement<GetDeletesp>(_GetDeletesp_QNAME, GetDeletesp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSanpham }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getSanpham")
    public JAXBElement<GetSanpham> createGetSanpham(GetSanpham value) {
        return new JAXBElement<GetSanpham>(_GetSanpham_QNAME, GetSanpham.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSanphamResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getSanphamResponse")
    public JAXBElement<GetSanphamResponse> createGetSanphamResponse(GetSanphamResponse value) {
        return new JAXBElement<GetSanphamResponse>(_GetSanphamResponse_QNAME, GetSanphamResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetThemsp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getThemsp")
    public JAXBElement<GetThemsp> createGetThemsp(GetThemsp value) {
        return new JAXBElement<GetThemsp>(_GetThemsp_QNAME, GetThemsp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Findsp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findsp")
    public JAXBElement<Findsp> createFindsp(Findsp value) {
        return new JAXBElement<Findsp>(_Findsp_QNAME, Findsp.class, null, value);
    }

}
