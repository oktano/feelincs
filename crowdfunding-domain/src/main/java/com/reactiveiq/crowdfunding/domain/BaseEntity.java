package com.reactiveiq.crowdfunding.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;

@MappedSuperclass()
public class BaseEntity {
	
	private Long id;
	
	private Long version;

	private boolean deleted=false;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@Version	
	@Column(name="VERSION")
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Column(name="IS_DELETED")
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Transient
	public boolean isActive() {
		return !deleted;
	}
	
}
