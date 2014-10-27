package asu.bank.security.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import asu.bank.hibernateFiles.User;
import asu.bank.security.viewBeans.UserDtls;
import asu.bank.utility.HibernateUtility;

@Repository
@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
public class AuthenticationDaoImpl implements AuthenticationDao {
	
	@Autowired
	HibernateUtility hibernateUtility;

	@Override
	public UserDtls getUserDtlsFromUserName(String emailId) throws BadCredentialsException, Exception {
		UserDtls userDtls = new UserDtls();
		List<SimpleGrantedAuthority> authorities;
		
		List<User> userList = (List<User>)hibernateUtility.getSession().createQuery("FROM User where emailId= :Email")
					.setParameter("Email", emailId).list();
		
		/*List<User> userList = (List<User>)hibernateUtility.getSession().createCriteria(User.class)
								.add(Restrictions.eq("name", userName))
								.list();*/
		
		if(userList.isEmpty())
			throw new BadCredentialsException("User Name or password not found");
		else
		{
			User user =userList.get(0); 
			authorities = new ArrayList<SimpleGrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(user.getRole()));
			
			userDtls.setUsername(user.getEmailId());
			
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(user.getPassword());
			
			//userDtls.setPassword(user.getPassword());
			userDtls.setPassword(hashedPassword);
			userDtls.setAuthorities(authorities);
			
			userDtls.setEnabled(true);
			userDtls.setAccountNonLocked(user.getIsAccountLocked().equals("0")?true:false);
			//userDtls.setEnabled();
		}
		
		return userDtls;
	}
	
	

}
