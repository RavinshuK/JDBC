package com.blueyonder.Postgre.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Table;

@Component
@Scope("prototype")

public class Department {
	
	private int depid;
	private String depname;
	private String deplocation;
	public int getDepid() {
		return depid;
	}
	public void setDepid(int depid) {
		this.depid = depid;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	public String getDeplocation() {
		return deplocation;
	}
	public void setDeplocation(String deplocation) {
		this.deplocation = deplocation;
	}
	@Override
	public String toString() {
		return "Department [depid=" + depid + ", depname=" + depname + ", deplocation=" + deplocation + "]";
	}
	

}
