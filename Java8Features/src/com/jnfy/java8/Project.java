package com.jnfy.java8;

public class Project {

	private String projectCode;
	private String name;
	private String client;
	private String leadName;
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getLeadName() {
		return leadName;
	}
	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}
	public Project(String projectCode, String name, String client, String leadName) {
		super();
		this.projectCode = projectCode;
		this.name = name;
		this.client = client;
		this.leadName = leadName;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Project [projectCode=" + projectCode + ", name=" + name + ", client=" + client + ", leadName="
				+ leadName + "]";
	}
	
	
}
