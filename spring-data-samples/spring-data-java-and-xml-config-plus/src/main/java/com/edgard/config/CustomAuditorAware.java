package com.edgard.config;

import org.springframework.data.domain.AuditorAware;

public class CustomAuditorAware implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		return "Edgard Ndouna";
	}

}
