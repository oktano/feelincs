package com.reactiveiq.crowdfunding.security.impl;



import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.reactiveiq.crowdfunding.domain.Account;
import com.reactiveiq.crowdfunding.domain.UserRole;
import com.reactiveiq.crowdfunding.service.AccountService;
import com.reactiveiq.crowdfunding.util.CdiBeanUtil;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException{
			
			Account account = CdiBeanUtil.getBean(AccountService.class).getAccountByUserName(username);			
			if(account==null){
				throw new UsernameNotFoundException("Invalid Username /Password");

			}
			
			Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			
			//Add Roles
			for(UserRole userRole:CdiBeanUtil.getBean(AccountService.class).getUserRoles(account.getId())){
				grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole().getRoleName()));
			}
			
			
			User user = new User(account.getUserName(),account.getPassword(), account.getAccountStatus().isAccountEnabled(), 
								!account.getAccountStatus().isAccountExpired(),!account.getAccountStatus().isCredentialsExpired(), !account.getAccountStatus().isAccountLocked(), grantedAuthorities);
			
			return user;
					
	}

}