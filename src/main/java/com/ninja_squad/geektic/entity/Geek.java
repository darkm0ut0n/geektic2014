package com.ninja_squad.geektic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator (sequenceName = "geek_seq", name="geek_seq")
@Table(name="GEEK")
public class Geek {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geek_seq")
	@Column(name = "ID_GEEK")
	private Long id;
	
	@Column(name = "PSEUDO")
	private String pseudo;
	
	@Column(name = "SEX")
	private Integer sex;
	
	@Column(name = "GRAVATAR_URL")
	private String gravatar_url;
	
	@Column(name = "INTEREST")
	private String interest;

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getGravatar_url() {
		return gravatar_url;
	}

	public void setGravatar_url(String gravatar_url) {
		this.gravatar_url = gravatar_url;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public Long getId() {
		return id;
	}
	
	
}
