package com.cgi.soa.masterclass.sampledeal.service;

import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

import com.cgi.soa.masterclass.sampledeal.samplebank.ws.BankWeb;
import com.cgi.soa.masterclass.sampledeal.samplebank.ws.BankWebService;

@Stateless
public class BankWS {

	@WebServiceRef
	BankWebService service;
	
	public BankWeb getWebService(){
		return service.getBankWebPort();
	}
}
