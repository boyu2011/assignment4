package stevens.cs.cs548.cliniclookup.web;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

@WebService(name="ClinicLookup",
			targetNamespace="http://www.example.org/cliniclookup/web")
@BindingType(value="http:/www.w3.rog/2003/05/soap/bindings/HTTP/")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT, use=SOAPBinding.Use.LITERAL)
public interface IClinicLookupWeb {
	
	@WebMethod
	public String GetClinicURL(String clinicName);

}
