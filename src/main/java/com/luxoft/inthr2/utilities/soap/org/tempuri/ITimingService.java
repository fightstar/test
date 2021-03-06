package com.luxoft.inthr2.utilities.soap.org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.4.6
 * 2014-02-17T12:56:44.150+03:00
 * Generated source version: 2.4.6
 * 
 */
@WebService(targetNamespace = "http://tempuri.org/", name = "ITimingService")
@XmlSeeAlso({ObjectFactory.class})
public interface ITimingService {

    @Action(input = "http://tempuri.org/ITimingService/RaiseProcessRequests", output = "http://tempuri.org/ITimingService/RaiseProcessRequestsResponse")
    @RequestWrapper(localName = "RaiseProcessRequests", targetNamespace = "http://tempuri.org/", className = "org.tempuri.RaiseProcessRequests")
    @WebMethod(operationName = "RaiseProcessRequests", action = "http://tempuri.org/ITimingService/RaiseProcessRequests")
    @ResponseWrapper(localName = "RaiseProcessRequestsResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.RaiseProcessRequestsResponse")
    public void raiseProcessRequests();

    @Action(input = "http://tempuri.org/ITimingService/Hourly", output = "http://tempuri.org/ITimingService/HourlyResponse")
    @RequestWrapper(localName = "Hourly", targetNamespace = "http://tempuri.org/", className = "org.tempuri.Hourly")
    @WebMethod(operationName = "Hourly", action = "http://tempuri.org/ITimingService/Hourly")
    @ResponseWrapper(localName = "HourlyResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.HourlyResponse")
    public void hourly();

    @Action(input = "http://tempuri.org/ITimingService/Daily", output = "http://tempuri.org/ITimingService/DailyResponse")
    @RequestWrapper(localName = "Daily", targetNamespace = "http://tempuri.org/", className = "org.tempuri.Daily")
    @WebMethod(operationName = "Daily", action = "http://tempuri.org/ITimingService/Daily")
    @ResponseWrapper(localName = "DailyResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.DailyResponse")
    public void daily();
}
