package com.name.no.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.name.no.enums.AdminLevel;

@Entity
@Table(name = "admin")
public class Admin extends User {

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private AdminLevel adminLevel;

	public AdminLevel getAdminLevel() {
		return adminLevel;
	}

	public void setAdminLevel(AdminLevel adminLevel) {
		this.adminLevel = adminLevel;
	}

}
