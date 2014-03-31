package com.cgi.soa.masterclass.sampledeal.faces;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cgi.soa.masterclass.sampledeal.model.UserEntity;
import com.cgi.soa.masterclass.sampledeal.service.Repository;

@Named
@RequestScoped
public class UserBean {

	@Inject
	Repository repository;

	UserEntity userEntity;

	public UserEntity getUserEntity() {
		if (userEntity == null) {
			userEntity = new UserEntity();
		}
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public List<UserEntity> getUsers() {
		return repository.getAllUsers();
	}

	public String createUserAction(){
		repository.createUser(userEntity);
		return "/users/index.xhtml?faces-redirect=true";
	}
	
	public void setRepository(Repository repository){
		this.repository = repository;
	}
}
