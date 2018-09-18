package cn.zzdz.service.impl;

import org.springframework.security.core.GrantedAuthority;

public class AuthorityImpl implements GrantedAuthority {
	private String permission;

	/**
	 *
	 */
	public AuthorityImpl(String permission) {
		this.permission = permission;
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String getAuthority() {
		return permission;
	}

}
