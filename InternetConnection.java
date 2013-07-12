import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;


public class InternetConnection {
	public boolean isInternetReachable() throws UnknownHostException
    {
        if("127.0.0.1".equals(InetAddress.getLocalHost().getHostAddress().toString())==true)
        {
        	return false;
        }
        else
        {
        	return true;
        }
    }

}
