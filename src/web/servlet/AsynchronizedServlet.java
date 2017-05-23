package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet 3.0 支持异步
 * 
 * @author ken
 * 2017-5-5 下午01:50:22
 */
@WebServlet(asyncSupported = true, urlPatterns = "/asyncServlet")
public class AsynchronizedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Queue<AsyncContext> CONNECTIONS = new ConcurrentLinkedQueue<AsyncContext>();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doPost");
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = req.getParameter("method");
		if (method.equals("onOpen")) {
			AsyncContext context = req.startAsync();
			context.setTimeout(0);
			CONNECTIONS.offer(context);
		} else if (method.equals("onMessage")) {
			String msg = req.getParameter("msg");
			broadcast(msg);
		}
	}

	private synchronized void broadcast(String msg) {
		for (AsyncContext context : CONNECTIONS) {
			HttpServletResponse response = (HttpServletResponse) context
					.getResponse();
			try {
				PrintWriter out = response.getWriter();
				out.print(msg);
				out.flush();
				out.close();
				context.complete();
				CONNECTIONS.remove(context);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
