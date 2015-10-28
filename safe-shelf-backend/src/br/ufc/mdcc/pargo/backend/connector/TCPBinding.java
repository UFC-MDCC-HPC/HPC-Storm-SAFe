package br.ufc.mdcc.pargo.backend.connector;

public class TCPBinding {

	private TCPBidingClientSlice client_slice;
	private TCPBidingServerSlice server_slice;
	
 
	
	
	public TCPBinding() {
		this.client_slice = new TCPBidingClientSlice();
		this.server_slice = new TCPBidingServerSlice();
	}
	
	public void client_connect(){
		this.client_slice.connect_to_server();
		 
	}
	
	public void server_connect(){
		this.server_slice.connect();
	}
	
	public void set_client_to_server_port(Integer port){
		this.client_slice.setServer_port(port);
		this.client_slice.release();
		 
	}
	
	public void set_server_port(Integer port){
		this.server_slice.setPort(port);
		this.server_slice.release();
		 
	}
	
	
	public boolean client_send_message(String msg){
		if(this.client_slice.connected)
			this.client_slice.send_message_to_server(msg);
		return this.client_slice.connected;
	}
	
	public void register_for_incoming_messages(ITCPBindingServerListener listener){
		this.server_slice.setServerListener(listener);
	}
	
	 
}
