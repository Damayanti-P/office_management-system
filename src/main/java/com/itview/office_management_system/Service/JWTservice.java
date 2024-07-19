package com.itview.office_management_system.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@Component
public class JWTservice
{
	public String generateToke(String username,int empId)
	{
		Map<String,Object> claims=	new HashMap<>();
		return createToken(claims,username,empId);
		
	}
	public String createToken(Map<String,Object> claims,String username,int empId)
	{
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(username)
				.setId(String.valueOf(empId))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
				.signWith(getSignature(),SignatureAlgorithm.HS256)
				.compact();
				
	}
	private Key getSignature() {
		String key="9a4f2c8d3b7a1e6f45c8a0b3f267d8b1d4e6f3c8a9d2b5f8e3a9c8b5f6v8a3d9";
		return Keys.hmacShaKeyFor(key.getBytes());
	}
}
