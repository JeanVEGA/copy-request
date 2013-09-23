package eu.prvaci.copyrequest.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

public enum HttpMethodUtilImpl implements HttpMethodUtil {

	INSTANCE;

	public HttpPost createPost(HttpServletRequest req) {
		return null;
	}

	public HttpGet createGet(HttpServletRequest req) {
		return null;
	}
}
