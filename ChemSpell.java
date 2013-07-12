import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;


public class ChemSpell {
	
	        //Created by Joseph Kunnummyalil and API provided by nlm.nih.gov CHemSpell
	        
public String isMedicine(String name) throws RemoteException, MalformedURLException, ServiceException
{
 String nameSource = "All databases";
 String result=null;

Service service = new Service();
Call call = (Call)service.createCall();

String endpoint =
  "http://chemspell.nlm.nih.gov/axis/SpellAid.jws";

	call.setTargetEndpointAddress(new URL(endpoint));



call.setOperationName(new
  QName("http://chemspell.nlm.nih.gov", "getSugList"));
result = (String)call.invoke(new Object [] {new
  String(name), new String(nameSource)});
System.out.println("Got result for " +name+ ": " + result);

return result;

}
}
