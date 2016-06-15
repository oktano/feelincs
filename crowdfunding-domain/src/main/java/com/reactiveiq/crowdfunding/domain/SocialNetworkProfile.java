package com.reactiveiq.crowdfunding.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="SOCIAL_NETWORK_PROFILE")
public class SocialNetworkProfile extends BaseEntity{
	
	enum  SocialNetworkType{
		LINKEDIN,FACEBOOK,TWITTER,GOOGLEPLUS
	}

	private boolean enabled;
	
	private SocialNetworkType socialNetworkType;
	
	private String url;
		
	@Column(name="IS_ENABLED")
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Column(name="NETWORK_TYPE")
	@Enumerated(EnumType.STRING)
	public SocialNetworkType getSocialNetworkType() {
		return socialNetworkType;
	}

	public void setSocialNetworkType(SocialNetworkType socialNetworkType) {
		this.socialNetworkType = socialNetworkType;
	}
	
	@Column(name="URL")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
