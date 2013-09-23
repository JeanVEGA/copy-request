package eu.prvaci.copyrequest.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum HttpClientUtilImpl implements HttpClientUtil {

	INSTANCE;

	private static final Logger log = LoggerFactory.getLogger(HttpClientUtilImpl.class);

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
			log.info("Could not retrieve response for request={}, exception={}", get, String.valueOf(e));
		}
		return response;
	}
}
