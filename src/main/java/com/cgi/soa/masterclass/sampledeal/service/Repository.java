package com.cgi.soa.masterclass.sampledeal.service;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cgi.soa.masterclass.sampledeal.model.FeeEntity;
import com.cgi.soa.masterclass.sampledeal.model.TransactionEntity;
import com.cgi.soa.masterclass.sampledeal.model.UserEntity;

@Stateless
public class Repository {

	@PersistenceContext
	EntityManager entityManager;

	public List<UserEntity> getAllUsers() {
		return entityManager.createQuery(
				"SELECT user FROM " + UserEntity.class.getName() + " user ",
				UserEntity.class).getResultList();
	}

	public List<TransactionEntity> getAllTransactionFromUser(Integer userId) {
		return entityManager
				.createQuery(
						"SELECT transaction FROM "
								+ TransactionEntity.class.getName()
								+ " transaction WHERE transaction.user.id = :userId ",
						TransactionEntity.class).setParameter("userId", userId)
				.getResultList();
	}

	public List<FeeEntity> getAllFees() {
		return entityManager.createQuery(
				"SELECT fee FROM " + FeeEntity.class.getName() + " fee ",
				FeeEntity.class).getResultList();
	}

	public void createUser(UserEntity user) {
		user.setBalance(BigDecimal.ZERO);
		entityManager.persist(user);
		entityManager.flush();
	}
}
