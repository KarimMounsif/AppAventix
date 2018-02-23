package com.qrcodeteam.beans;




public class Login {
	//@NotNull
    //@NotEmpty(message = "Please enter your username addresss.")
	private String login;
	
	//@NotNull
   // @Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
	private String mdp;
	
	// Constructeur(s)
	public Login(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
	}
	
	public Login() {
		
	}
	
	// Setters and getters
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
	
	
	

}
