package hsl.groep5.moyee;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.util.Log;

/**
* @title HTTP Api Moyee Applicatie
* @author Projectgroep 5
* @param S1063848
* @since 04-04-2013
* @version 1.0
*/

public class HttpAPI extends AsyncTask<String, Integer, String> {
	HttpAPIResult resultObject;
	List<NameValuePair> params = new ArrayList<NameValuePair>();
	int id = 0;
	
	public HttpAPI (HttpAPIResult resultObject) {
		this.resultObject = resultObject;
	}
	
	public HttpAPI (HttpAPIResult resultObject, int id) {
		this.resultObject = resultObject;
		this.id = id;
	}
	
	public HttpAPI setParams(NameValuePair param) {
		params.add(param);
		return this;
	}
	
	@Override
	protected String doInBackground(String... params) {
		String url = params[0];
		
		// Creating HTTP client
		HttpClient httpClient = new DefaultHttpClient();
		 
		// Creating HTTP Post
		HttpPost httpPost = new HttpPost(url);
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(this.params));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String result = "";
		// Making HTTP Request
		try {
		    HttpResponse response = httpClient.execute(httpPost);
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
		this.resultObject.onHttpResult(result, this.id);
	}
    
}
