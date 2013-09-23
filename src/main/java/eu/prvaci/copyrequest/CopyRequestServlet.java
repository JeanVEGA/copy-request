package eu.prvaci.copyrequest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import eu.prvaci.copyrequest.util.HttpClientUtil;
import eu.prvaci.copyrequest.util.HttpClientUtilImpl;
import eu.prvaci.copyrequest.util.HttpMethodUtil;
import eu.prvaci.copyrequest.util.HttpMethodUtilImpl;
import eu.prvaci.copyrequest.util.HttpUtil;
import eu.prvaci.copyrequest.util.HttpUtilImpl;

public class CopyRequestServlet extends HttpServlet {

	private static final long serialVersionUID = -3864541137722160887L;

	private HttpUtil httpUtil = HttpUtilImpl.INSTANCE;
	private HttpClientUtil httpClientUtil = HttpClientUtilImpl.INSTANCE;
	private HttpMethodUtil httpMethodUtil = HttpMethodUtilImpl.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpGet get = httpMethodUtil.createGet(req);
		HttpResponse response = httpClientUtil.get(get);
		httpUtil.copyResponse(response, req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpPost post = httpMethodUtil.createPost(req);
		HttpResponse response = httpClientUtil.post(post);
		httpUtil.copyResponse(response, req, resp);
	}

	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		throw getUnsupportedOperationException("HEAD");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		throw getUnsupportedOperationException("PUT");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		throw getUnsupportedOperationException("DELETE");
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		throw getUnsupportedOperationException("OPTIONS");
	}

	@Override
	protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		throw getUnsupportedOperationException("TRACE");
	}

	private UnsupportedOperationException getUnsupportedOperationException(String methodName) {
		return new UnsupportedOperationException(methodName + " is not implemented yet.");
	}

	public void setHttpUtil(HttpUtil httpUtil) {
		this.httpUtil = httpUtil;
	}

	public void setHttpClientUtil(HttpClientUtil httpClientUtil) {
		this.httpClientUtil = httpClientUtil;
	}

	public void setHttpMethodUtil(HttpMethodUtil httpMethodUtil) {
		this.httpMethodUtil = httpMethodUtil;
	}

}
