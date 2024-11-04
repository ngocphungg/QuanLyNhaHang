
package ThucDon;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ThucDon package. 
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

    private final static QName _Findtd_QNAME = new QName("http://ws/", "findtd");
    private final static QName _GetUpdatetd_QNAME = new QName("http://ws/", "getUpdatetd");
    private final static QName _GetMenuItemsFromDatabase_QNAME = new QName("http://ws/", "getMenuItemsFromDatabase");
    private final static QName _GetDeletetd_QNAME = new QName("http://ws/", "getDeletetd");
    private final static QName _GiaMonResponse_QNAME = new QName("http://ws/", "giaMonResponse");
    private final static QName _GetTheloaiResponse_QNAME = new QName("http://ws/", "getTheloaiResponse");
    private final static QName _GetThucdonResponse_QNAME = new QName("http://ws/", "getThucdonResponse");
    private final static QName _FindtdResponse_QNAME = new QName("http://ws/", "findtdResponse");
    private final static QName _GetThemtd_QNAME = new QName("http://ws/", "getThemtd");
    private final static QName _GiaMon_QNAME = new QName("http://ws/", "giaMon");
    private final static QName _GetMenuItemsFromDatabaseResponse_QNAME = new QName("http://ws/", "getMenuItemsFromDatabaseResponse");
    private final static QName _GetTheloai_QNAME = new QName("http://ws/", "getTheloai");
    private final static QName _GetThucdon_QNAME = new QName("http://ws/", "getThucdon");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ThucDon
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Findtd }
     * 
     */
    public Findtd createFindtd() {
        return new Findtd();
    }

    /**
     * Create an instance of {@link GetUpdatetd }
     * 
     */
    public GetUpdatetd createGetUpdatetd() {
        return new GetUpdatetd();
    }

    /**
     * Create an instance of {@link GetMenuItemsFromDatabase }
     * 
     */
    public GetMenuItemsFromDatabase createGetMenuItemsFromDatabase() {
        return new GetMenuItemsFromDatabase();
    }

    /**
     * Create an instance of {@link GetDeletetd }
     * 
     */
    public GetDeletetd createGetDeletetd() {
        return new GetDeletetd();
    }

    /**
     * Create an instance of {@link GiaMonResponse }
     * 
     */
    public GiaMonResponse createGiaMonResponse() {
        return new GiaMonResponse();
    }

    /**
     * Create an instance of {@link GetTheloaiResponse }
     * 
     */
    public GetTheloaiResponse createGetTheloaiResponse() {
        return new GetTheloaiResponse();
    }

    /**
     * Create an instance of {@link GetThucdonResponse }
     * 
     */
    public GetThucdonResponse createGetThucdonResponse() {
        return new GetThucdonResponse();
    }

    /**
     * Create an instance of {@link FindtdResponse }
     * 
     */
    public FindtdResponse createFindtdResponse() {
        return new FindtdResponse();
    }

    /**
     * Create an instance of {@link GetThemtd }
     * 
     */
    public GetThemtd createGetThemtd() {
        return new GetThemtd();
    }

    /**
     * Create an instance of {@link GiaMon }
     * 
     */
    public GiaMon createGiaMon() {
        return new GiaMon();
    }

    /**
     * Create an instance of {@link GetMenuItemsFromDatabaseResponse }
     * 
     */
    public GetMenuItemsFromDatabaseResponse createGetMenuItemsFromDatabaseResponse() {
        return new GetMenuItemsFromDatabaseResponse();
    }

    /**
     * Create an instance of {@link GetTheloai }
     * 
     */
    public GetTheloai createGetTheloai() {
        return new GetTheloai();
    }

    /**
     * Create an instance of {@link GetThucdon }
     * 
     */
    public GetThucdon createGetThucdon() {
        return new GetThucdon();
    }

    /**
     * Create an instance of {@link Tdmodel }
     * 
     */
    public Tdmodel createTdmodel() {
        return new Tdmodel();
    }

    /**
     * Create an instance of {@link Theloaimodel }
     * 
     */
    public Theloaimodel createTheloaimodel() {
        return new Theloaimodel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Findtd }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findtd")
    public JAXBElement<Findtd> createFindtd(Findtd value) {
        return new JAXBElement<Findtd>(_Findtd_QNAME, Findtd.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUpdatetd }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getUpdatetd")
    public JAXBElement<GetUpdatetd> createGetUpdatetd(GetUpdatetd value) {
        return new JAXBElement<GetUpdatetd>(_GetUpdatetd_QNAME, GetUpdatetd.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMenuItemsFromDatabase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getMenuItemsFromDatabase")
    public JAXBElement<GetMenuItemsFromDatabase> createGetMenuItemsFromDatabase(GetMenuItemsFromDatabase value) {
        return new JAXBElement<GetMenuItemsFromDatabase>(_GetMenuItemsFromDatabase_QNAME, GetMenuItemsFromDatabase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDeletetd }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getDeletetd")
    public JAXBElement<GetDeletetd> createGetDeletetd(GetDeletetd value) {
        return new JAXBElement<GetDeletetd>(_GetDeletetd_QNAME, GetDeletetd.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GiaMonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "giaMonResponse")
    public JAXBElement<GiaMonResponse> createGiaMonResponse(GiaMonResponse value) {
        return new JAXBElement<GiaMonResponse>(_GiaMonResponse_QNAME, GiaMonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTheloaiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getTheloaiResponse")
    public JAXBElement<GetTheloaiResponse> createGetTheloaiResponse(GetTheloaiResponse value) {
        return new JAXBElement<GetTheloaiResponse>(_GetTheloaiResponse_QNAME, GetTheloaiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetThucdonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getThucdonResponse")
    public JAXBElement<GetThucdonResponse> createGetThucdonResponse(GetThucdonResponse value) {
        return new JAXBElement<GetThucdonResponse>(_GetThucdonResponse_QNAME, GetThucdonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindtdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "findtdResponse")
    public JAXBElement<FindtdResponse> createFindtdResponse(FindtdResponse value) {
        return new JAXBElement<FindtdResponse>(_FindtdResponse_QNAME, FindtdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetThemtd }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getThemtd")
    public JAXBElement<GetThemtd> createGetThemtd(GetThemtd value) {
        return new JAXBElement<GetThemtd>(_GetThemtd_QNAME, GetThemtd.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GiaMon }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "giaMon")
    public JAXBElement<GiaMon> createGiaMon(GiaMon value) {
        return new JAXBElement<GiaMon>(_GiaMon_QNAME, GiaMon.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMenuItemsFromDatabaseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getMenuItemsFromDatabaseResponse")
    public JAXBElement<GetMenuItemsFromDatabaseResponse> createGetMenuItemsFromDatabaseResponse(GetMenuItemsFromDatabaseResponse value) {
        return new JAXBElement<GetMenuItemsFromDatabaseResponse>(_GetMenuItemsFromDatabaseResponse_QNAME, GetMenuItemsFromDatabaseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTheloai }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getTheloai")
    public JAXBElement<GetTheloai> createGetTheloai(GetTheloai value) {
        return new JAXBElement<GetTheloai>(_GetTheloai_QNAME, GetTheloai.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetThucdon }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getThucdon")
    public JAXBElement<GetThucdon> createGetThucdon(GetThucdon value) {
        return new JAXBElement<GetThucdon>(_GetThucdon_QNAME, GetThucdon.class, null, value);
    }

}
