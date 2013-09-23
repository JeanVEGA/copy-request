package eu.prvaci.copyrequest.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

public interface HttpMethodUtil {

	HttpPost createPost(HttpServletRequest req);

	HttpGet createGet(HttpServletRequest req);
}