package hsl.groep5.moyee;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.util.Log;

public class HttpAPI extends AsyncTask<String, Integer, String> {
	HttpAPIResult resultObject;
	
	public HttpAPI (HttpAPIResult resultObject) {
		this.resultObject = resultObject;
	}
	
	@Override
	protected String doInBackground(String... params) {
		String url = params[0];
		
		// Creating HTTP client
		HttpClient httpClient = new DefaultHttpClient();
		 
		// Creating HTTP Post
		HttpGet httpGet = new HttpGet(url);
		
		String result = "";
		// Making HTTP Request
		try {
		    HttpResponse response = httpClient.execute(httpGet);
		    result = EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
		    // writing exception to log
		    e.printStackTrace();
		 
		} catch (IOException e) {
		    // writing exception to log
		    e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		// writing response to log
		this.resultObject.onHttpResult(result);
	}
    
}