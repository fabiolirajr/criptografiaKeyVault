package br.com.projeto.kv.exemplo.criptografia.dto;

public class RequestCriptografiaRsa {

	private String keyId;
	private String dados;
	private String algoritmo;

	
	public RequestCriptografiaRsa(String keyId, String dados, String algoritmo) {
		this.keyId = keyId;
		this.dados = dados;
		this.algoritmo = algoritmo;
	}


	public String getKeyId() {
		return keyId;
	}


	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}


	public String getDados() {
		return dados;
	}


	public void setDados(String dados) {
		this.dados = dados;
	}


	public String getAlgoritmo() {
		return algoritmo;
	}


	public void setAlgoritmo(String algoritmo) {
		this.algoritmo = algoritmo;
	}

}
