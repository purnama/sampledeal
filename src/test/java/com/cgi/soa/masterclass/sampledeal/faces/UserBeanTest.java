package com.cgi.soa.masterclass.sampledeal.faces;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.cgi.soa.masterclass.sampledeal.model.UserEntity;
import com.cgi.soa.masterclass.sampledeal.service.Repository;

public class UserBeanTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetUserEntityIsNull() {
		UserBean bean = new UserBean();
		UserEntity testObj = bean.getUserEntity();
		assertEquals(null, testObj.getAccountFirstName());
	}
	
	@Test
	public void testGetUserEntityIsNotNull() {
		UserBean bean = new UserBean();
		UserEntity mockObj = new UserEntity();
		mockObj.setFirstName("Arthur");
		bean.setUserEntity(mockObj);
		UserEntity testObj = bean.getUserEntity();
		assertEquals("Arthur", testObj.getFirstName());
	}

	@Test
	public void testGetUsers() {
		Repository repositoryMock = mock(Repository.class);
		UserBean bean = new UserBean();
		bean.setRepository(repositoryMock);
		bean.getUsers();
		verify(repositoryMock).getAllUsers();
	}

	@Test
	public void testCreateUserAction() {
		UserEntity entityMock = mock(UserEntity.class);
		Repository repositoryMock = mock(Repository.class);
		UserBean bean = new UserBean();
		bean.setRepository(repositoryMock);
		bean.setUserEntity(entityMock);
		assertEquals("/users/index.xhtml?faces-redirect=true", bean.createUserAction());
		verify(repositoryMock).createUser(entityMock);
	}

}
