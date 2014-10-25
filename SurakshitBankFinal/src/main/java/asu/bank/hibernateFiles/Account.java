package asu.bank.hibernateFiles;

// Generated Oct 24, 2014 1:23:56 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Account generated by hbm2java
 */
@Entity
@Table(name = "account", catalog = "surakshit_bank")
public class Account implements java.io.Serializable {

	private Integer accountId;
	private User user;
	private Double balance;

	public Account() {
	}

	public Account(User user) {
		this.user = user;
	}

	public Account(User user, Double balance) {
		this.user = user;
		this.balance = balance;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "AccountID", unique = true, nullable = false)
	public Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "Balance", precision = 14)
	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
