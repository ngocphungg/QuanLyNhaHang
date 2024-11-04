
package ChitietHD;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ChitietHD package. 
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

    private final static QName _AddChitiethdAndUpdateTongtien_QNAME = new QName("http://ws/", "addChitiethdAndUpdateTongtien");
    private final static QName _CalculateTotalAmount_QNAME = new QName("http://ws/", "calculateTotalAmount");
    private final static QName _CheckIfItemExistsInOrderResponse_QNAME = new QName("http://ws/", "checkIfItemExistsInOrderResponse");
    private final static QName _CountOrderDetailsResponse_QNAME = new QName("http://ws/", "countOrderDetailsResponse");
    private final static QName _GetCTResponse_QNAME = new QName("http://ws/", "getCTResponse");
    private final static QName _UpdateExistingItemInOrder_QNAME = new QName("http://ws/", "updateExistingItemInOrder");
    private final static QName _GetTableDetailsFromChitiethdResponse_QNAME = new QName("http://ws/", "getTableDetailsFromChitiethdResponse");
    private final static QName _DeleteChiTietHD_QNAME = new QName("http://ws/", "deleteChiTietHD");
    private final static QName _CalculateTotalAmountResponse_QNAME = new QName("http://ws/", "calculateTotalAmountResponse");
    private final static QName _CheckIfItemExistsInOrder_QNAME = new QName("http://ws/", "checkIfItemExistsInOrder");
    private final static QName _CountOrderDetails_QNAME = new QName("http://ws/", "countOrderDetails");
    private final static QName _GetCT_QNAME = new QName("http://ws/", "getCT");
    private final static QName _GetTableDetailsFromChitiethd_QNAME = new QName("http://ws/", "getTableDetailsFromChitiethd");
    private final static QName _DeleteCTHD_QNAME = new QName("http://ws/", "deleteCTHD");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ChitietHD
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddChitiethdAndUpdateTongtien }
     * 
     */
    public AddChitiethdAndUpdateTongtien createAddChitiethdAndUpdateTongtien() {
        return new AddChitiethdAndUpdateTongtien();
    }

    /**
     * Create an instance of {@link CalculateTotalAmount }
     * 
     */
    public CalculateTotalAmount createCalculateTotalAmount() {
        return new CalculateTotalAmount();
    }

    /**
     * Create an instance of {@link CheckIfItemExistsInOrderResponse }
     * 
     */
    public CheckIfItemExistsInOrderResponse createCheckIfItemExistsInOrderResponse() {
        return new CheckIfItemExistsInOrderResponse();
    }

    /**
     * Create an instance of {@link CountOrderDetailsResponse }
     * 
     */
    public CountOrderDetailsResponse createCountOrderDetailsResponse() {
        return new CountOrderDetailsResponse();
    }

    /**
     * Create an instance of {@link GetCTResponse }
     * 
     */
    public GetCTResponse createGetCTResponse() {
        return new GetCTResponse();
    }

    /**
     * Create an instance of {@link UpdateExistingItemInOrder }
     * 
     */
    public UpdateExistingItemInOrder createUpdateExistingItemInOrder() {
        return new UpdateExistingItemInOrder();
    }

    /**
     * Create an instance of {@link GetTableDetailsFromChitiethdResponse }
     * 
     */
    public GetTableDetailsFromChitiethdResponse createGetTableDetailsFromChitiethdResponse() {
        return new GetTableDetailsFromChitiethdResponse();
    }

    /**
     * Create an instance of {@link DeleteChiTietHD }
     * 
     */
    public DeleteChiTietHD createDeleteChiTietHD() {
        return new DeleteChiTietHD();
    }

    /**
     * Create an instance of {@link CalculateTotalAmountResponse }
     * 
     */
    public CalculateTotalAmountResponse createCalculateTotalAmountResponse() {
        return new CalculateTotalAmountResponse();
    }

    /**
     * Create an instance of {@link CheckIfItemExistsInOrder }
     * 
     */
    public CheckIfItemExistsInOrder createCheckIfItemExistsInOrder() {
        return new CheckIfItemExistsInOrder();
    }

    /**
     * Create an instance of {@link CountOrderDetails }
     * 
     */
    public CountOrderDetails createCountOrderDetails() {
        return new CountOrderDetails();
    }

    /**
     * Create an instance of {@link GetCT }
     * 
     */
    public GetCT createGetCT() {
        return new GetCT();
    }

    /**
     * Create an instance of {@link GetTableDetailsFromChitiethd }
     * 
     */
    public GetTableDetailsFromChitiethd createGetTableDetailsFromChitiethd() {
        return new GetTableDetailsFromChitiethd();
    }

    /**
     * Create an instance of {@link DeleteCTHD }
     * 
     */
    public DeleteCTHD createDeleteCTHD() {
        return new DeleteCTHD();
    }

    /**
     * Create an instance of {@link Chitiethdmodel }
     * 
     */
    public Chitiethdmodel createChitiethdmodel() {
        return new Chitiethdmodel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddChitiethdAndUpdateTongtien }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "addChitiethdAndUpdateTongtien")
    public JAXBElement<AddChitiethdAndUpdateTongtien> createAddChitiethdAndUpdateTongtien(AddChitiethdAndUpdateTongtien value) {
        return new JAXBElement<AddChitiethdAndUpdateTongtien>(_AddChitiethdAndUpdateTongtien_QNAME, AddChitiethdAndUpdateTongtien.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateTotalAmount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "calculateTotalAmount")
    public JAXBElement<CalculateTotalAmount> createCalculateTotalAmount(CalculateTotalAmount value) {
        return new JAXBElement<CalculateTotalAmount>(_CalculateTotalAmount_QNAME, CalculateTotalAmount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckIfItemExistsInOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "checkIfItemExistsInOrderResponse")
    public JAXBElement<CheckIfItemExistsInOrderResponse> createCheckIfItemExistsInOrderResponse(CheckIfItemExistsInOrderResponse value) {
        return new JAXBElement<CheckIfItemExistsInOrderResponse>(_CheckIfItemExistsInOrderResponse_QNAME, CheckIfItemExistsInOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountOrderDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "countOrderDetailsResponse")
    public JAXBElement<CountOrderDetailsResponse> createCountOrderDetailsResponse(CountOrderDetailsResponse value) {
        return new JAXBElement<CountOrderDetailsResponse>(_CountOrderDetailsResponse_QNAME, CountOrderDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCTResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getCTResponse")
    public JAXBElement<GetCTResponse> createGetCTResponse(GetCTResponse value) {
        return new JAXBElement<GetCTResponse>(_GetCTResponse_QNAME, GetCTResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateExistingItemInOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "updateExistingItemInOrder")
    public JAXBElement<UpdateExistingItemInOrder> createUpdateExistingItemInOrder(UpdateExistingItemInOrder value) {
        return new JAXBElement<UpdateExistingItemInOrder>(_UpdateExistingItemInOrder_QNAME, UpdateExistingItemInOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTableDetailsFromChitiethdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getTableDetailsFromChitiethdResponse")
    public JAXBElement<GetTableDetailsFromChitiethdResponse> createGetTableDetailsFromChitiethdResponse(GetTableDetailsFromChitiethdResponse value) {
        return new JAXBElement<GetTableDetailsFromChitiethdResponse>(_GetTableDetailsFromChitiethdResponse_QNAME, GetTableDetailsFromChitiethdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteChiTietHD }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "deleteChiTietHD")
    public JAXBElement<DeleteChiTietHD> createDeleteChiTietHD(DeleteChiTietHD value) {
        return new JAXBElement<DeleteChiTietHD>(_DeleteChiTietHD_QNAME, DeleteChiTietHD.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateTotalAmountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "calculateTotalAmountResponse")
    public JAXBElement<CalculateTotalAmountResponse> createCalculateTotalAmountResponse(CalculateTotalAmountResponse value) {
        return new JAXBElement<CalculateTotalAmountResponse>(_CalculateTotalAmountResponse_QNAME, CalculateTotalAmountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckIfItemExistsInOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "checkIfItemExistsInOrder")
    public JAXBElement<CheckIfItemExistsInOrder> createCheckIfItemExistsInOrder(CheckIfItemExistsInOrder value) {
        return new JAXBElement<CheckIfItemExistsInOrder>(_CheckIfItemExistsInOrder_QNAME, CheckIfItemExistsInOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountOrderDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "countOrderDetails")
    public JAXBElement<CountOrderDetails> createCountOrderDetails(CountOrderDetails value) {
        return new JAXBElement<CountOrderDetails>(_CountOrderDetails_QNAME, CountOrderDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getCT")
    public JAXBElement<GetCT> createGetCT(GetCT value) {
        return new JAXBElement<GetCT>(_GetCT_QNAME, GetCT.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTableDetailsFromChitiethd }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getTableDetailsFromChitiethd")
    public JAXBElement<GetTableDetailsFromChitiethd> createGetTableDetailsFromChitiethd(GetTableDetailsFromChitiethd value) {
        return new JAXBElement<GetTableDetailsFromChitiethd>(_GetTableDetailsFromChitiethd_QNAME, GetTableDetailsFromChitiethd.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCTHD }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "deleteCTHD")
    public JAXBElement<DeleteCTHD> createDeleteCTHD(DeleteCTHD value) {
        return new JAXBElement<DeleteCTHD>(_DeleteCTHD_QNAME, DeleteCTHD.class, null, value);
    }

}
