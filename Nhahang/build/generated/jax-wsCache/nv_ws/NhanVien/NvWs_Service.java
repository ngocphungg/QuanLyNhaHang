
package NhanVien;

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
@WebServiceClient(name = "nv_ws", targetNamespace = "http://ws/", wsdlLocation = "http://localhost:8080/nv_ws?WSDL")
public class NvWs_Service
    extends Service
{

    private final static URL NVWS_WSDL_LOCATION;
    private final static WebServiceException NVWS_EXCEPTION;
    private final static QName NVWS_QNAME = new QName("http://ws/", "nv_ws");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/nv_ws?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NVWS_WSDL_LOCATION = url;
        NVWS_EXCEPTION = e;
    }

    public NvWs_Service() {
        super(__getWsdlLocation(), NVWS_QNAME);
    }

    public NvWs_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), NVWS_QNAME, features);
    }

    public NvWs_Service(URL wsdlLocation) {
        super(wsdlLocation, NVWS_QNAME);
    }

    public NvWs_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NVWS_QNAME, features);
    }

    public NvWs_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NvWs_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns NvWs
     */
    @WebEndpoint(name = "nv_wsPort")
    public NvWs getNvWsPort() {
        return super.getPort(new QName("http://ws/", "nv_wsPort"), NvWs.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns NvWs
     */
    @WebEndpoint(name = "nv_wsPort")
    public NvWs getNvWsPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws/", "nv_wsPort"), NvWs.class, features);
    }

    private static URL __getWsdlLocation() {
        if (NVWS_EXCEPTION!= null) {
            throw NVWS_EXCEPTION;
        }
        return NVWS_WSDL_LOCATION;
    }

}
