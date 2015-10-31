package br.ufc.mdcc.pargo.backend.connector;

public class TCPBinding {

	private TCPBidingClientLogic client_logic;
	private TCPBidingServerLogic server_logic;	
	
	public TCPBinding() {
		this.client_logic = new TCPBidingClientLogic();
		this.server_logic = new TCPBidingServerLogic();
	}
	
	public void client_connect(){
		this.client_logic.connect_to_server();
		 
	}

	public void set_client_to_server_port(Integer port){
		this.client_logic.setServer_port(port);
		this.client_logic.release();
		 
	}
		
	public boolean client_send_message(String msg){
		if(this.client_logic.connected)
			this.client_logic.send_message_to_server(msg);
		return this.client_logic.connected;
	}

	public void server_connect(){
		this.server_logic.connect();
	}
	
	public void set_server_port(Integer port){
		this.server_logic.setPort(port);
		this.server_logic.release();
		 
	}
	
	public void register_for_incoming_messages(ITCPBindingServerListener listener){
		this.server_logic.setServerListener(listener);
	}
	
	 
}
