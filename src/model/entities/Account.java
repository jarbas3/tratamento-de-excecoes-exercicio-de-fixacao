package model.entities;

import model.exceptions.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance = 0.0;
	private Double withdrawLimit;

	public Account(Integer number, String holder, Double initialBalance, Double withdrawLimit) throws DomainException {
		this.number = number;
		this.holder = holder;
		deposit(initialBalance);
		this.withdrawLimit = withdrawLimit;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Integer getNumber() {
		return number;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void deposit(double amount) throws DomainException {
		if (amount <= 0.0) {
			throw new DomainException("O depósito deve ser igual ou superior a R$ 0,01");
		}
		balance += amount;
	}
	
	public void withdraw(double amount) throws DomainException {
		if (amount > balance) {
			throw new DomainException("Saldo insuficiente");
		}
		if (amount > withdrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		balance -= amount;
	}
}
