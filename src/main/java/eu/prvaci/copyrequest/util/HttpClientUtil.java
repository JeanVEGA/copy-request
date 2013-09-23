package eu.prvaci.copyrequest.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

public interface HttpClientUtil {

	HttpResponse get(HttpGet get);

	HttpResponse post(HttpPost post);
}