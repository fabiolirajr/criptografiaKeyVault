package br.com.projeto.kv.exemplo.criptografia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.azure.security.keyvault.keys.cryptography.models.EncryptResult;

import br.com.projeto.kv.exemplo.criptografia.dto.RequestCriptografiaRsa;
import br.com.projeto.kv.exemplo.criptografia.dto.RequestDescriptografiaRsa;
import br.com.projeto.kv.exemplo.criptografia.service.CriptografiaDadosRsa;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/seguranca/cartoes")
public class GestorSegurancaController {

	@RequestMapping(value = "/criptografiaDados/rsa", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<EncryptResult> criptografaDadosRsa(@RequestBody @Valid RequestCriptografiaRsa requestCriptoRsa) {
		EncryptResult resultado = CriptografiaDadosRsa.criptografiaDadosRsa(requestCriptoRsa.getKeyId(), requestCriptoRsa.getDados(), requestCriptoRsa.getAlgoritmo());
		return ResponseEntity.ok(resultado);
	}
	
	@RequestMapping(value = "/descriptografiaDados/rsa", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> descriptografaDadosRsa(@RequestBody @Valid RequestDescriptografiaRsa requestDescriptografiaRsa) {
		String resultado = 	CriptografiaDadosRsa.descriptografiaDadosRsa(requestDescriptografiaRsa.getKeyId(), requestDescriptografiaRsa.getDados(), requestDescriptografiaRsa.getAlgoritmo());
		return ResponseEntity.ok(resultado);
	}
	
}
