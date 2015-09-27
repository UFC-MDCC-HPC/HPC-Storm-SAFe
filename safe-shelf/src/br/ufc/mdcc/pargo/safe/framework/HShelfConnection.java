package br.ufc.mdcc.pargo.safe.framework;

import br.ufc.mdcc.pargo.safe.component.HShelfComponent;

public class HShelfConnection {

	private HShelfComponent providerComponent;
	private HShelfComponent userComponent;
	private String providerPortName;
	private String userPortName;
	
	
	public HShelfComponent getProviderComponent() {
		return providerComponent;
	}
	public void setProviderComponent(HShelfComponent providerComponent) {
		this.providerComponent = providerComponent;
	}
	public HShelfComponent getUserComponent() {
		return userComponent;
	}
	public void setUserComponent(HShelfComponent userComponent) {
		this.userComponent = userComponent;
	}
	public String getProviderPortName() {
		return providerPortName;
	}
	public void setProviderPortName(String providerPortName) {
		this.providerPortName = providerPortName;
	}
	public String getUserPortName() {
		return userPortName;
	}
	public void setUserPortName(String userPortName) {
		this.userPortName = userPortName;
	}
	
	
}
