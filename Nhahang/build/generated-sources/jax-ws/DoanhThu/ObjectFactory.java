
package DoanhThu;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the DoanhThu package. 
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

    private final static QName _FetchDataResponse_QNAME = new QName("http://ws/", "fetchDataResponse");
    private final static QName _InsertDoanhthu_QNAME = new QName("http://ws/", "insertDoanhthu");
    private final static QName _FetchData_QNAME = new QName("http://ws/", "fetchData");
    private final static QName _CheckDoanhThuExistResponse_QNAME = new QName("http://ws/", "checkDoanhThuExistResponse");
    private final static QName _UpdateComboBoxResponse_QNAME = new QName("http://ws/", "updateComboBoxResponse");
    private final static QName _UpdateDoanhthu_QNAME = new QName("http://ws/", "updateDoanhthu");
    private final static QName _UpdateComboBox_QNAME = new QName("http://ws/", "updateComboBox");
    private final static QName _Getdoanhthu_QNAME = new QName("http://ws/", "getdoanhthu");
    private final static QName _CheckDoanhThuExist_QNAME = new QName("http://ws/", "checkDoanhThuExist");
    private final static QName _GetdoanhthuResponse_QNAME = new QName("http://ws/", "getdoanhthuResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: DoanhThu
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FetchDataResponse }
     * 
     */
    public FetchDataResponse createFetchDataResponse() {
        return new FetchDataResponse();
    }

    /**
     * Create an instance of {@link InsertDoanhthu }
     * 
     */
    public InsertDoanhthu createInsertDoanhthu() {
        return new InsertDoanhthu();
    }

    /**
     * Create an instance of {@link FetchData }
     * 
     */
    public FetchData createFetchData() {
        return new FetchData();
    }

    /**
     * Create an instance of {@link CheckDoanhThuExistResponse }
     * 
     */
    public CheckDoanhThuExistResponse createCheckDoanhThuExistResponse() {
        return new CheckDoanhThuExistResponse();
    }

    /**
     * Create an instance of {@link UpdateComboBoxResponse }
     * 
     */
    public UpdateComboBoxResponse createUpdateComboBoxResponse() {
        return new UpdateComboBoxResponse();
    }

    /**
     * Create an instance of {@link UpdateDoanhthu }
     * 
     */
    public UpdateDoanhthu createUpdateDoanhthu() {
        return new UpdateDoanhthu();
    }

    /**
     * Create an instance of {@link UpdateComboBox }
     * 
     */
    public UpdateComboBox createUpdateComboBox() {
        return new UpdateComboBox();
    }

    /**
     * Create an instance of {@link Getdoanhthu }
     * 
     */
    public Getdoanhthu createGetdoanhthu() {
        return new Getdoanhthu();
    }

    /**
     * Create an instance of {@link CheckDoanhThuExist }
     * 
     */
    public CheckDoanhThuExist createCheckDoanhThuExist() {
        return new CheckDoanhThuExist();
    }

    /**
     * Create an instance of {@link GetdoanhthuResponse }
     * 
     */
    public GetdoanhthuResponse createGetdoanhthuResponse() {
        return new GetdoanhthuResponse();
    }

    /**
     * Create an instance of {@link Dtmodel }
     * 
     */
    public Dtmodel createDtmodel() {
        return new Dtmodel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "fetchDataResponse")
    public JAXBElement<FetchDataResponse> createFetchDataResponse(FetchDataResponse value) {
        return new JAXBElement<FetchDataResponse>(_FetchDataResponse_QNAME, FetchDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertDoanhthu }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "insertDoanhthu")
    public JAXBElement<InsertDoanhthu> createInsertDoanhthu(InsertDoanhthu value) {
        return new JAXBElement<InsertDoanhthu>(_InsertDoanhthu_QNAME, InsertDoanhthu.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "fetchData")
    public JAXBElement<FetchData> createFetchData(FetchData value) {
        return new JAXBElement<FetchData>(_FetchData_QNAME, FetchData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckDoanhThuExistResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "checkDoanhThuExistResponse")
    public JAXBElement<CheckDoanhThuExistResponse> createCheckDoanhThuExistResponse(CheckDoanhThuExistResponse value) {
        return new JAXBElement<CheckDoanhThuExistResponse>(_CheckDoanhThuExistResponse_QNAME, CheckDoanhThuExistResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateComboBoxResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "updateComboBoxResponse")
    public JAXBElement<UpdateComboBoxResponse> createUpdateComboBoxResponse(UpdateComboBoxResponse value) {
        return new JAXBElement<UpdateComboBoxResponse>(_UpdateComboBoxResponse_QNAME, UpdateComboBoxResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateDoanhthu }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "updateDoanhthu")
    public JAXBElement<UpdateDoanhthu> createUpdateDoanhthu(UpdateDoanhthu value) {
        return new JAXBElement<UpdateDoanhthu>(_UpdateDoanhthu_QNAME, UpdateDoanhthu.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateComboBox }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "updateComboBox")
    public JAXBElement<UpdateComboBox> createUpdateComboBox(UpdateComboBox value) {
        return new JAXBElement<UpdateComboBox>(_UpdateComboBox_QNAME, UpdateComboBox.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Getdoanhthu }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getdoanhthu")
    public JAXBElement<Getdoanhthu> createGetdoanhthu(Getdoanhthu value) {
        return new JAXBElement<Getdoanhthu>(_Getdoanhthu_QNAME, Getdoanhthu.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckDoanhThuExist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "checkDoanhThuExist")
    public JAXBElement<CheckDoanhThuExist> createCheckDoanhThuExist(CheckDoanhThuExist value) {
        return new JAXBElement<CheckDoanhThuExist>(_CheckDoanhThuExist_QNAME, CheckDoanhThuExist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetdoanhthuResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getdoanhthuResponse")
    public JAXBElement<GetdoanhthuResponse> createGetdoanhthuResponse(GetdoanhthuResponse value) {
        return new JAXBElement<GetdoanhthuResponse>(_GetdoanhthuResponse_QNAME, GetdoanhthuResponse.class, null, value);
    }

}
