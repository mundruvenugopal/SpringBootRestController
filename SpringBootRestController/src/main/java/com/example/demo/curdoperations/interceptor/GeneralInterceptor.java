package com.example.demo.curdoperations.interceptor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class GeneralInterceptor implements HandlerInterceptor{
	private Logger logger = Logger.getLogger(GeneralInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("prehandle invoked..."+request.getRequestURI()+request.getMethod());
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		logger.info("posthandle invoked..."+request.getRequestURI()+request.getMethod());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		if(ex!=null)
		{
			logger.error("exception inside aftercompletion"+ex.getMessage());
		}
		logger.info("aftercompletion invoked..."+request.getRequestURI()+request.getMethod());
	}

	
	

}
