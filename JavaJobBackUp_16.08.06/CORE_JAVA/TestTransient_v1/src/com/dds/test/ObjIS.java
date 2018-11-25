package com.dds.test;

import java.io.Serializable;

public class ObjIS implements Serializable 
{
	private transient String name;

	private transient String adrs;

	private String desgn;

	private String org;

	public String getAdrs() 
	{
		return adrs;
	}

	public void setAdrs(String adrs) 
	{
		this.adrs = adrs;
	}

	public String getDesgn() 
	{
		return desgn;
	}

	public void setDesgn(String desgn) 
	{
		this.desgn = desgn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

}
