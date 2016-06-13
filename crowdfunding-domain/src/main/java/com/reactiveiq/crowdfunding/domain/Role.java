package com.reactiveiq.crowdfunding.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name="ROLE")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Role {

	private Integer roleId;
	
	private String roleName;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ROLE_ID")
	public Integer getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	@Column(name="NAME")
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
