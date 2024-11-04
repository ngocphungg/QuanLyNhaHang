
package DangNhap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the DangNhap package. 
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

    private final static QName _LoginResponse_QNAME = new QName("http://ws/", "loginResponse");
    private final static QName _GetDangnhap_QNAME = new QName("http://ws/", "getDangnhap");
    private final static QName _GetDangnhapResponse_QNAME = new QName("http://ws/", "getDangnhapResponse");
    private final static QName _Login_QNAME = new QName("http://ws/", "login");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: DangNhap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link GetDangnhap }
     * 
     */
    public GetDangnhap createGetDangnhap() {
        return new GetDangnhap();
    }

    /**
     * Create an instance of {@link GetDangnhapResponse }
     * 
     */
    public GetDangnhapResponse createGetDangnhapResponse() {
        return new GetDangnhapResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link Loginmodel }
     * 
     */
    public Loginmodel createLoginmodel() {
        return new Loginmodel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDangnhap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getDangnhap")
    public JAXBElement<GetDangnhap> createGetDangnhap(GetDangnhap value) {
        return new JAXBElement<GetDangnhap>(_GetDangnhap_QNAME, GetDangnhap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDangnhapResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getDangnhapResponse")
    public JAXBElement<GetDangnhapResponse> createGetDangnhapResponse(GetDangnhapResponse value) {
        return new JAXBElement<GetDangnhapResponse>(_GetDangnhapResponse_QNAME, GetDangnhapResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

}
