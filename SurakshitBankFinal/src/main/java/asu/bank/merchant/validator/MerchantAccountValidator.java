package asu.bank.merchant.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import asu.bank.customer.viewBeans.AccountViewBean;
import asu.bank.merchant.viewBeans.PayRequestViewBean;

@Component
public class MerchantAccountValidator implements Validator{
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		if(object instanceof AccountViewBean)
		{
			AccountViewBean accountViewBean = (AccountViewBean)object;
			
			//if(accountViewBean.getCurrency() != new BigDecimal(1.0))
				//errors.rejectValue("currency", "Currency.notNull");
		}
		
	}

}
