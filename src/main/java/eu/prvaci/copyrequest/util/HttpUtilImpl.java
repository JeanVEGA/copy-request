package eu.prvaci.copyrequest.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public enum HttpUtilImpl implements HttpUtil {

	INSTANCE;

	@Override
	public HttpResponse get(HttpGet get) {
		HttpClient client = createHttpClient();
		return doExecuteQuietly(get, client);
	}

	@Override
	public HttpResponse post(HttpPost post) {
		HttpClient client = createHttpClient();
		return doExecuteQuietly(post, client);
	}

	private HttpClient createHttpClient() {
		return new DefaultHttpClient();
	}

	private HttpResponse doExecuteQuietly(HttpUriRequest get, HttpClient client) {
		HttpResponse response = null;
		try {
			response = client.execute(get);
		} catch (Exception e) {
		}
		return response;
	}

	@Override
	public void copyResponse(HttpResponse response, HttpServletRequest req, HttpServletResponse resp) {

	}
}
