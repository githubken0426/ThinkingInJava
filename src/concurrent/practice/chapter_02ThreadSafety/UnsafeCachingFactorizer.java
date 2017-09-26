package concurrent.practice.chapter_02ThreadSafety;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 尽管AtomicReference是线程安全的，
 * 但是UnsafeCachingFactorizer本身存在竞争条件
 * 导致产生错误的答案
 * 
 * @author ken
 * 2017-6-8 11:26:52
 */
public class UnsafeCachingFactorizer implements Servlet {
	private final AtomicReference<BigInteger> lastNumber = new AtomicReference<BigInteger>();
	private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<BigInteger[]>();
	
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		lastNumber.get();
		BigInteger[] newValue=new BigInteger[]{BigInteger.valueOf(10L)};
		lastFactors.set(newValue);
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}
	
	@Override
	public void destroy() {
		
	}

}
