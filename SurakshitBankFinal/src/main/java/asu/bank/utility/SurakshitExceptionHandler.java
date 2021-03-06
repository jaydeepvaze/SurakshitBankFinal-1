package asu.bank.utility;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SurakshitExceptionHandler {
	
	private static final Logger logger = Logger.getLogger(SurakshitExceptionHandler.class);
	
	@ExceptionHandler(SurakshitException.class)
	public ModelAndView handleSurakshitException(SurakshitException suExp)
	{
		ModelAndView model =  new ModelAndView("Homepage/exception");
		
		model.addObject("errMsg", suExp.getErrorCode());
		
		return model;
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ModelAndView handleAccessDeniedException(AccessDeniedException exp)
	{
		ModelAndView model =  new ModelAndView("login/accessDenied");
		
		return model;
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ModelAndView handleRequestMethodNotSupportedExceptions(HttpRequestMethodNotSupportedException exp)
	{
		ModelAndView model =  new ModelAndView("login/accessDenied");
		logger.error(exp.getMessage());
		exp.printStackTrace();
		
		return model;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleOtherExceptions(Exception exp)
	{
		ModelAndView model =  new ModelAndView("Homepage/exception");
		logger.error(exp.getMessage());
		exp.printStackTrace();
		
		model.addObject("errMsg", "Some problem occured. Please try again");
		
		return model;
	}
	
	private boolean isUserSessionExists()
	{
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser"))
			return false;
		else
			return true;
	}
	
	
}
