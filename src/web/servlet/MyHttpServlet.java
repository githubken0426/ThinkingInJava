package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;

public class MyHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private long count = 0;
	public long getCount() {
		return count;
	}

	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		++count;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doHead(req, resp);
	}

	@Override
	protected void doOptions(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		super.doOptions(arg0, arg1);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPut(req, resp);
	}

	@Override
	protected void doTrace(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		super.doTrace(arg0, arg1);
	}

	@Override
	protected long getLastModified(HttpServletRequest req) {
		return super.getLastModified(req);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		super.service(arg0, arg1);
	}

	// @Override
	// public void service(ServletRequest arg0, ServletResponse arg1)
	// throws ServletException, IOException {
	// super.service(arg0, arg1);
	// }
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doDelete(req, resp);
	}

}
