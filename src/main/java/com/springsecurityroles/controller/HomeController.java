package com.springsecurityroles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurityroles.models.dto.LoginDTO;
import com.springsecurityroles.service.MyUserDetailsService;


@RestController
public class HomeController {

	
	
	@Autowired 
	private AuthenticationManager authenticationManager;
	
	@Autowired

    private MyUserDetailsService userDetailsService;


	
	@GetMapping
	public String Home()
	{
		return ("<h1>Welcome Home</h1>");
	}
	
	@GetMapping("/admin")
	public String Admin()
	{
		return ("<h1>Welcome Admin Page</h1>");
	}
	
	@GetMapping("/user")
	public String User()
	{
		return ("<h1>Welcome User Page</h1>");
	}
	
	@PostMapping(value="/login")
	public ResponseEntity<Void> LogIn(@RequestBody LoginDTO login) throws Exception
	{
		
		try 
		{
			
	      
	        
	        
	        final Authentication authentication = 	authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							login.getUsername(),login.getPassword()));
			

	       SecurityContextHolder.getContext().setAuthentication(authentication); //to authenticate using the default filter.
	       
	        
	        
		}
		catch (BadCredentialsException e)
		{
			throw new Exception("Incorrect username or password", e);
		}
		

		
		
		return ResponseEntity.ok().build();
		
	}

}
