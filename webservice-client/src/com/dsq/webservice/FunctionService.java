
package com.dsq.webservice;

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
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "FunctionService", targetNamespace = "http://webservice.dsq.com/", wsdlLocation = "http://localhost:9001/Service/Function?wsdl")
public class FunctionService
    extends Service
{

    private final static URL FUNCTIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException FUNCTIONSERVICE_EXCEPTION;
    private final static QName FUNCTIONSERVICE_QNAME = new QName("http://webservice.dsq.com/", "FunctionService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9001/Service/Function?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FUNCTIONSERVICE_WSDL_LOCATION = url;
        FUNCTIONSERVICE_EXCEPTION = e;
    }

    public FunctionService() {
        super(__getWsdlLocation(), FUNCTIONSERVICE_QNAME);
    }

    public FunctionService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FUNCTIONSERVICE_QNAME, features);
    }

    public FunctionService(URL wsdlLocation) {
        super(wsdlLocation, FUNCTIONSERVICE_QNAME);
    }

    public FunctionService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FUNCTIONSERVICE_QNAME, features);
    }

    public FunctionService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FunctionService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Function
     */
    @WebEndpoint(name = "FunctionPort")
    public Function getFunctionPort() {
        return super.getPort(new QName("http://webservice.dsq.com/", "FunctionPort"), Function.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Function
     */
    @WebEndpoint(name = "FunctionPort")
    public Function getFunctionPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservice.dsq.com/", "FunctionPort"), Function.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FUNCTIONSERVICE_EXCEPTION!= null) {
            throw FUNCTIONSERVICE_EXCEPTION;
        }
        return FUNCTIONSERVICE_WSDL_LOCATION;
    }

}