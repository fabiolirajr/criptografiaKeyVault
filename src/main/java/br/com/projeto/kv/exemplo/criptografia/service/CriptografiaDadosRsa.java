package br.com.projeto.kv.exemplo.criptografia.service;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.keys.cryptography.CryptographyClient;
import com.azure.security.keyvault.keys.cryptography.CryptographyClientBuilder;
import com.azure.security.keyvault.keys.cryptography.models.DecryptResult;
import com.azure.security.keyvault.keys.cryptography.models.EncryptResult;
import com.azure.security.keyvault.keys.cryptography.models.EncryptionAlgorithm;

public class CriptografiaDadosRsa {
	
	public static EncryptResult criptografiaDadosRsa (String keyId, String dados, String algoritmo) {
		
		String algoritmoCripto = algoritmo;
		
		switch (algoritmoCripto) {
			case "rsaoaep256":
				CryptographyClient cryptoClientRsaOaep256 = new CryptographyClientBuilder()
			    .credential(new DefaultAzureCredentialBuilder().build())
			    .keyIdentifier(keyId)
			    .buildClient();
				
				//Transformando o json em bytes
			    byte[] byteDadosRsaOaep256 = dados.getBytes();
			        
			    //Criptografia com client Azure KeyVault
			    EncryptResult encryptResultRsaOaep256 = cryptoClientRsaOaep256.encrypt(EncryptionAlgorithm.RSA_OAEP_256, byteDadosRsaOaep256);
				
				return encryptResultRsaOaep256;
				
			case "rsaoaep":
				CryptographyClient cryptoClientRsaOaep = new CryptographyClientBuilder()
	            .credential(new DefaultAzureCredentialBuilder().build())
	            .keyIdentifier(keyId)
	            .buildClient();
		
				byte[] byteDadosRsaOaep = dados.getBytes();
	        
				//Criptografia com client Azure KeyVault
				EncryptResult encryptResultRsaOaep = cryptoClientRsaOaep.encrypt(EncryptionAlgorithm.RSA_OAEP, byteDadosRsaOaep);
		
				return encryptResultRsaOaep;
				
			case "rsa1":
				CryptographyClient cryptoClientRsa1 = new CryptographyClientBuilder()
	            .credential(new DefaultAzureCredentialBuilder().build())
	            .keyIdentifier(keyId)
	            .buildClient();
		
				byte[] byteDadosRsa1 = dados.getBytes();
	        
				//Criptografia com client Azure KeyVault
				EncryptResult encryptResultRsa1 = cryptoClientRsa1.encrypt(EncryptionAlgorithm.RSA1_5, byteDadosRsa1);
		
				return encryptResultRsa1;
			}
		return null;
	}
	
	public static String descriptografiaDadosRsa (String keyId, byte[] dados, String algoritmo) {
		
		String algoritmoDecrypt= algoritmo;
		
		switch (algoritmoDecrypt) {
			case "rsaoaep256":	
				CryptographyClient cryptoClientRsaOaep256 = new CryptographyClientBuilder()
			            .credential(new DefaultAzureCredentialBuilder().build())
			            .keyIdentifier(keyId)
			            .buildClient();
		
			    DecryptResult decryptResultRsaOaep256 = cryptoClientRsaOaep256.decrypt(EncryptionAlgorithm.RSA_OAEP_256, dados);
			        
			    String resultadoRsaOaep256 = new String(decryptResultRsaOaep256.getPlainText());
			    //JSONObject resultadoRsa1 = new JSONObject(decryptResultRsa1.getPlainText());
				
				return resultadoRsaOaep256;
				
			case "rsaoaep":
				CryptographyClient cryptoClientRsaOaep = new CryptographyClientBuilder()
	            .credential(new DefaultAzureCredentialBuilder().build())
	            .keyIdentifier(keyId)
	            .buildClient();
				
				DecryptResult decryptResultRsaOaep = cryptoClientRsaOaep.decrypt(EncryptionAlgorithm.RSA_OAEP, dados);
		        
				String resultadoRsaOaep = new String(decryptResultRsaOaep.getPlainText());
			    //JSONObject resultadoRsaOaep = new JSONObject(decryptResultRsaOaep.getPlainText());
			    
				return resultadoRsaOaep;
				
			case "rsa1":
				CryptographyClient cryptoClientRsa1 = new CryptographyClientBuilder()
	            .credential(new DefaultAzureCredentialBuilder().build())
	            .keyIdentifier(keyId)
	            .buildClient();
				
				DecryptResult decryptResultRsa1 = cryptoClientRsa1.decrypt(EncryptionAlgorithm.RSA1_5, dados);
		        
				String resultadoRsa1 = new String(decryptResultRsa1.getPlainText());
			    //JSONObject resultadoRsa1 = new JSONObject(decryptResultRsa1.getPlainText());
			    
				return resultadoRsa1;
		}
		return null;

	}
}
