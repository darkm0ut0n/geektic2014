package com.ninja_squad.geektic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(sequenceName = "geek_seq", name = "geek_seq")
@Table(name = "GEEK")
public class Geek {

	public enum Interest {
		Java, C, TDD, JUnit, PHP
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geek_seq")
	@Column(name = "ID_GEEK")
	private Long id;

	@Column(name = "PSEUDO")
	private String pseudo;

	@Column(name = "SEX")
	private Integer sex;

	@Column(name = "GRAVATAR_URL")
	private String gravatarUrl;

	@Column(name = "INTEREST")
	@Enumerated(EnumType.STRING)
	private Interest interest;

	@Column(name = "CONSULTED")
	private int consulted;

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

	public String getGravatarUrl() {
		return gravatarUrl;
	}

	public void setGravatar_url(String gravatar_url) {
		this.gravatarUrl = gravatar_url;
	}

	public Interest getInterest() {
		return interest;
	}

	public void setInterest(Interest interest) {
		this.interest = interest;
	}

	public Long getId() {
		return id;
	}

	public int getConsulted() {
		return consulted;
	}

	public void setConsulted(int consulted) {
		this.consulted = consulted;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Geek) {
			Geek geek = (Geek) obj;
			return (this.pseudo.equals(geek.getPseudo())
					&& this.sex.equals(geek.getSex())
					&& this.gravatarUrl.equals(geek.getGravatarUrl()) && this.interest
						.equals(geek.getInterest()));
		}
		return false;
	}

}
