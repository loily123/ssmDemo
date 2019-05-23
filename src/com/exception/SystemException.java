package com.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebEndpoint;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class SystemException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) {
		// TODO Auto-generated method stub
		ModelAndView modelAndView = new ModelAndView();
		if (exception instanceof MyWebException) {
			modelAndView.addObject("errorCode", ((MyWebException) exception).getErrorCode());
			modelAndView.addObject("errorMsg", ((MyWebException) exception).getMsg());
		} else {
			modelAndView.addObject("errorCode", "9999");
			modelAndView.addObject("errorMsg", "ϵͳ�쳣");
		}
		modelAndView.setViewName("/jsp/error.jsp");
		return modelAndView;
	}
}
