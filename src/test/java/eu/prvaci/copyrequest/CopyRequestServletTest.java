package eu.prvaci.copyrequest;

import static org.easymock.EasyMock.expect;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.junit.Test;

import eu.prvaci.copyrequest.util.HttpClientUtil;
import eu.prvaci.copyrequest.util.HttpMethodUtil;
import eu.prvaci.copyrequest.util.HttpUtil;
import eu.prvaci.util.test.annotation.Mock;
import eu.prvaci.util.test.mock.EasyMockTest;

public class CopyRequestServletTest extends EasyMockTest<CopyRequestServlet> {

	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;

	@Mock
	HttpResponse httpResponse;

	@Mock
	HttpUtil httpUtil;

	@Mock
	HttpClientUtil httpClientUtil;

	@Mock
	HttpMethodUtil httpMethodUtil;

	@Test
	public void testDoGet() throws Exception {
		HttpGet get = new HttpGet();
		expect(httpMethodUtil.createGet(request)).andReturn(get);
		expect(httpClientUtil.get(get)).andReturn(httpResponse);
		httpUtil.copyResponse(httpResponse, request, response);

		replayMocks();
		testedClass.doGet(request, response);
	}

	@Test
	public void testDoPost() throws Exception {
		HttpPost post = new HttpPost();
		expect(httpMethodUtil.createPost(request)).andReturn(post);
		expect(httpClientUtil.post(post)).andReturn(httpResponse);
		httpUtil.copyResponse(httpResponse, request, response);

		replayMocks();
		testedClass.doPost(request, response);
	}

	@Test
	public void testDoHead() throws Exception {
		replayMocks();
		try {
			testedClass.doHead(null, null);
		} catch (UnsupportedOperationException e) {
			verifyException(e, "HEAD");
		}
	}

	@Test
	public void testDoPut() throws Exception {
		replayMocks();
		try {
			testedClass.doPut(null, null);
		} catch (UnsupportedOperationException e) {
			verifyException(e, "PUT");
		}
	}

	@Test
	public void testDoDelete() throws Exception {
		replayMocks();
		try {
			testedClass.doDelete(null, null);
		} catch (UnsupportedOperationException e) {
			verifyException(e, "DELETE");
		}
	}

	@Test
	public void testDoOptions() throws Exception {
		replayMocks();
		try {
			testedClass.doOptions(null, null);
		} catch (UnsupportedOperationException e) {
			verifyException(e, "OPTIONS");
		}
	}

	@Test
	public void testDoTrace() throws Exception {
		replayMocks();
		try {
			testedClass.doTrace(null, null);
		} catch (UnsupportedOperationException e) {
			verifyException(e, "TRACE");
		}
	}

	private void verifyException(UnsupportedOperationException e, String message) {
		assertThat(e.getMessage(), containsString(message));
	}

}
