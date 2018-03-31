package com.name.no.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.name.no.enums.Privilege;

@Entity
@Table(name = "teacher_creator")
public class TeacherCreator extends Teacher {

	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private List<Privilege> privileges = new ArrayList<Privilege>();

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void addPrivilege(Privilege privilege) {
		this.privileges.add(privilege);
	}

}
