/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.user;

import java.util.List;

import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.server.lifecycle.ILifecycleComponent;
import com.sitewhere.spi.user.request.IGrantedAuthorityCreateRequest;
import com.sitewhere.spi.user.request.IUserCreateRequest;

/**
 * Interface for user management operations.
 * 
 * @author Derek
 */
public interface IUserManagement extends ILifecycleComponent {

	/**
	 * Create a new user based on the given input.
	 * 
	 * @param request
	 * @return
	 * @throws SiteWhereException
	 */
	public IUser createUser(IUserCreateRequest request) throws SiteWhereException;

	/**
	 * Imports a user (including encrypted password) from an external system.
	 * 
	 * @param user
	 * @param overwrite
	 * @return
	 * @throws SiteWhereException
	 */
	public IUser importUser(IUser user, boolean overwrite) throws SiteWhereException;

	/**
	 * Authenticate the given username and password.
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws SiteWhereException
	 */
	public IUser authenticate(String username, String password) throws SiteWhereException;

	/**
	 * Update details for a user.
	 * 
	 * @param username
	 * @param request
	 * @return
	 * @throws SiteWhereException
	 */
	public IUser updateUser(String username, IUserCreateRequest request) throws SiteWhereException;

	/**
	 * Get a user given unique username.
	 * 
	 * @param username
	 * @return
	 * @throws SiteWhereException
	 */
	public IUser getUserByUsername(String username) throws SiteWhereException;

	/**
	 * Get the granted authorities for a specific user. Does not include any authorities
	 * inherited from groups.
	 * 
	 * @param username
	 * @return
	 * @throws SiteWhereException
	 */
	public List<IGrantedAuthority> getGrantedAuthorities(String username) throws SiteWhereException;

	/**
	 * Add user authorities. Duplicates are ignored.
	 * 
	 * @param username
	 * @param authorities
	 * @return
	 * @throws SiteWhereException
	 */
	public List<IGrantedAuthority> addGrantedAuthorities(String username, List<String> authorities)
			throws SiteWhereException;

	/**
	 * Remove user authorities. Ignore if not previously granted.
	 * 
	 * @param username
	 * @param authorities
	 * @return
	 * @throws SiteWhereException
	 */
	public List<IGrantedAuthority> removeGrantedAuthorities(String username, List<String> authorities)
			throws SiteWhereException;

	/**
	 * Get the list of all users that meet the given criteria.
	 * 
	 * @param criteria
	 * @return
	 * @throws SiteWhereException
	 */
	public List<IUser> listUsers(IUserSearchCriteria criteria) throws SiteWhereException;

	/**
	 * Delete the user with the given username.
	 * 
	 * @param username
	 * @param force
	 * @return
	 * @throws SiteWhereException
	 */
	public IUser deleteUser(String username, boolean force) throws SiteWhereException;

	/**
	 * Create a new granted authority.
	 * 
	 * @param request
	 * @throws SiteWhereException
	 */
	public IGrantedAuthority createGrantedAuthority(IGrantedAuthorityCreateRequest request)
			throws SiteWhereException;

	/**
	 * Get a granted authority by name.
	 * 
	 * @param name
	 * @return
	 * @throws SiteWhereException
	 */
	public IGrantedAuthority getGrantedAuthorityByName(String name) throws SiteWhereException;

	/**
	 * Update a granted authority.
	 * 
	 * @param name
	 * @param request
	 * @return
	 * @throws SiteWhereException
	 */
	public IGrantedAuthority updateGrantedAuthority(String name, IGrantedAuthorityCreateRequest request)
			throws SiteWhereException;

	/**
	 * List granted authorities that match the given criteria.
	 * 
	 * @param criteria
	 * @return
	 * @throws SiteWhereException
	 */
	public List<IGrantedAuthority> listGrantedAuthorities(IGrantedAuthoritySearchCriteria criteria)
			throws SiteWhereException;

	/**
	 * Delete a granted authority.
	 * 
	 * @param authority
	 * @throws SiteWhereException
	 */
	public void deleteGrantedAuthority(String authority) throws SiteWhereException;
}