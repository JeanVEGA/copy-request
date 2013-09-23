package eu.prvaci.copyrequest.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

public interface HttpUtil {

	HttpResponse get(HttpGet get);

	HttpResponse post(HttpPost post);

	void copyResponse(HttpResponse response, HttpServletRequest req, HttpServletResponse resp);
}
