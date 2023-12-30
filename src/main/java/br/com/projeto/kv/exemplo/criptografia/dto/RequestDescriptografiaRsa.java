package br.com.projeto.kv.exemplo.criptografia.dto;

public class RequestDescriptografiaRsa {

	private String keyId;
	private byte[] dados;
	private String algoritmo;
	
	public RequestDescriptografiaRsa(String keyId, byte[] dados, String algoritmo) {
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

	public byte[] getDados() {
		return dados;
	}

	public void setDados(byte[] dados) {
		this.dados = dados;
	}

	public String getAlgoritmo() {
		return algoritmo;
	}

	public void setAlgoritmo(String algoritmo) {
		this.algoritmo = algoritmo;
	}

}
