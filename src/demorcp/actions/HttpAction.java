package demorcp.actions;

import static org.hamcrest.Matchers.nullValue;

import java.io.IOException;

import javax.imageio.IIOException;
import javax.naming.directory.InvalidAttributeIdentifierException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class HttpAction extends Action implements IWorkbenchAction {
	private IWorkbenchWindow workbenchWindow;
	
	private final String apiUrlString="https://tianqiapi.com/api?version=epidemic&appid=25522569&appsecret=0fk7W644";
	
	
	public HttpAction(IWorkbenchWindow workbenchWindow){
		if(workbenchWindow==null) {
			throw new IllegalArgumentException();
		}
		this.workbenchWindow=workbenchWindow;
	}
	
	
	@Override
	public void run() {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet httpGet=new HttpGet(apiUrlString);
		CloseableHttpResponse response=null;
		try {
			response=httpClient.execute(httpGet);
			HttpEntity responseEntity=response.getEntity();
			System.out.println("RstCode: "+response.getStatusLine());
			if(responseEntity!=null) {
				System.out.println("RstLength: "+responseEntity.getContentLength());
				
				System.out.println("Rst: ");
				System.out.println(EntityUtils.toString(responseEntity));
			}
			
			
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(httpClient!=null) {
					httpClient.close();
				}
				if(response!=null) {
					response.close();
				}
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	
	

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
