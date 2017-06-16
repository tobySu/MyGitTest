
package com.yue.wsclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.yue.ws package. 
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

    private final static QName _TobytestResponse_QNAME = new QName("http://ws.yue.com/", "tobytestResponse");
    private final static QName _Tobytest_QNAME = new QName("http://ws.yue.com/", "tobytest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.yue.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Tobytest }
     * 
     */
    public Tobytest createTobytest() {
        return new Tobytest();
    }

    /**
     * Create an instance of {@link TobytestResponse }
     * 
     */
    public TobytestResponse createTobytestResponse() {
        return new TobytestResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TobytestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.yue.com/", name = "tobytestResponse")
    public JAXBElement<TobytestResponse> createTobytestResponse(TobytestResponse value) {
        return new JAXBElement<TobytestResponse>(_TobytestResponse_QNAME, TobytestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tobytest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.yue.com/", name = "tobytest")
    public JAXBElement<Tobytest> createTobytest(Tobytest value) {
        return new JAXBElement<Tobytest>(_Tobytest_QNAME, Tobytest.class, null, value);
    }

}
