
package HoaDon;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "hoadon_ws", targetNamespace = "http://ws/", wsdlLocation = "http://localhost:8080/hoadon_ws?WSDL")
public class HoadonWs_Service
    extends Service
{

    private final static URL HOADONWS_WSDL_LOCATION;
    private final static WebServiceException HOADONWS_EXCEPTION;
    private final static QName HOADONWS_QNAME = new QName("http://ws/", "hoadon_ws");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/hoadon_ws?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HOADONWS_WSDL_LOCATION = url;
        HOADONWS_EXCEPTION = e;
    }

    public HoadonWs_Service() {
        super(__getWsdlLocation(), HOADONWS_QNAME);
    }

    public HoadonWs_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), HOADONWS_QNAME, features);
    }

    public HoadonWs_Service(URL wsdlLocation) {
        super(wsdlLocation, HOADONWS_QNAME);
    }

    public HoadonWs_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HOADONWS_QNAME, features);
    }

    public HoadonWs_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HoadonWs_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HoadonWs
     */
    @WebEndpoint(name = "hoadon_wsPort")
    public HoadonWs getHoadonWsPort() {
        return super.getPort(new QName("http://ws/", "hoadon_wsPort"), HoadonWs.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HoadonWs
     */
    @WebEndpoint(name = "hoadon_wsPort")
    public HoadonWs getHoadonWsPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws/", "hoadon_wsPort"), HoadonWs.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HOADONWS_EXCEPTION!= null) {
            throw HOADONWS_EXCEPTION;
        }
        return HOADONWS_WSDL_LOCATION;
    }

}