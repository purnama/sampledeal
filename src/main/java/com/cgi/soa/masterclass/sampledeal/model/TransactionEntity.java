package com.cgi.soa.masterclass.sampledeal.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class TransactionEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	@Temporal(TemporalType.DATE)
	@NotNull
	Date date;
	
	@Column(scale=2)
	BigDecimal amount;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn
	UserEntity user;
	
	@Basic
	String purpose;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn
	UserEntity recipient;
	
	@OneToOne(mappedBy="transaction", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	FeeEntity fee;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public UserEntity getRecipient() {
		return recipient;
	}

	public void setRecipient(UserEntity recipient) {
		this.recipient = recipient;
	}

	public FeeEntity getFee() {
		return fee;
	}

	public void setFee(FeeEntity fee) {
		this.fee = fee;
	}
}
