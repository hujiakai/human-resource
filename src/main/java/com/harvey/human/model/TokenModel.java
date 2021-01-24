package com.harvey.human.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenModel {

	private String token;
	
	private String refreshToken;
	
	private Date expireDate;
}
