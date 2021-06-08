package jp.co.aforce.beans;

import java.io.Serializable;

public class Customer implements Serializable {

	private String id;
	private String login;
	private String password;

	public String getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
