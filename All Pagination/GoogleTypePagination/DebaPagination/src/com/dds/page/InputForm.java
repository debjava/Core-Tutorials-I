package com.dds.page;

import org.apache.struts.action.ActionForm;

public class InputForm extends ActionForm 
{
	private String inputText = null;

	public String getInputText() {
		return inputText;
	}

	public void setInputText(String inputText) {
		this.inputText = inputText;
	}
	

}
