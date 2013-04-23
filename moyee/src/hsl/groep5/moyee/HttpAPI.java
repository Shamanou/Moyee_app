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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import android.os.AsyncTask;

/**
 * @title HttpAPI
 * @author Maikel de Jong
 * @param s1041697
 * @since 04-04-2013
 * @version 1.0
 */

public class HttpAPI extends AsyncTask<String, Integer, String> {
	HttpAPIResult resultObject; // Calling object
	List<NameValuePair> params = new ArrayList<NameValuePair>(); // Parameters
	int id = 0; // Request id

	public HttpAPI(HttpAPIResult resultObject) {
		this.resultObject = resultObject;
	}

	public HttpAPI(HttpAPIResult resultObject, int id) {
		this.resultObject = resultObject;
		this.id = id;
	}

	public HttpAPI setParams(NameValuePair param) {
		// Add parameter
		params.add(param);
		// Return this object
		return this;
	}

	@Override
	protected String doInBackground(String... params) {
		// Get url from params
		String url = params[0];

		// Create http client
		HttpClient httpClient = new DefaultHttpClient();

		// Create http post object
		HttpPost httpPost = new HttpPost(url);
		try {
			// Set post parameters
			httpPost.setEntity(new UrlEncodedFormEntity(this.params));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String result = "";

		try {
			// Execute the http request; returns response;
			HttpResponse response = httpClient.execute(httpPost);
			// Parse http response to String
			result = EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		// Execute method on calling object
		this.resultObject.onHttpResult(result, this.id);
	}

}
