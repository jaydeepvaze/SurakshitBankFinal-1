package asu.bank.utility;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import asu.bank.hibernateFiles.User;

@Repository
public class UserDataUtility {
	
	@Autowired
	HibernateUtility hibernateUtility;
	
	public User getUserDtlsFromEmailId(String emailId) throws SurakshitException, Exception
	{
		User user = (User)hibernateUtility.getSession().createCriteria(User.class).add(Restrictions.eq("emailId", emailId)).uniqueResult();
		
		if(user!=null)
			return user ;
		else
			throw new SurakshitException("User not found.");
	}

}