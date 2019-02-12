package cn.zzdz.service.impl;

import org.springframework.security.core.GrantedAuthority;

public class AuthorityImpl implements GrantedAuthority {
	private Object permission;

	/**
	 *
	 */
	public AuthorityImpl(Object permission) {
		this.permission = permission;
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String getAuthority() {
		return permission.toString();
	}

}
