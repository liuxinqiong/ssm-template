package cn.com.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuthenticator extends Authenticator{
	private String username;
	private String password;
	
	/**
	 * ��ʼ�����������
	 */
	
	public MailAuthenticator(String username, String password){
		this.username = username;
	    this.password = password;
	}
	
	public MailAuthenticator(){}
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		// TODO Auto-generated method stub
		return new PasswordAuthentication(username, password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
