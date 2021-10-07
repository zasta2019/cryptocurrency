package com.blockchain.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdaService {

	@Value("${blockfrost.apiKey}")
	private String apiKey;

	public String specificTxn(String txnId) throws Exception {

		// 1 ADA = 1,000,000 Lovelaces.

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("project_id", apiKey);
		String s = null;
		HttpEntity<String> httpEntity = new HttpEntity<String>(s, headers);
		ResponseEntity<?> response = restTemplate.exchange("https://cardano-mainnet.blockfrost.io/api/v0/txs/" + txnId,
				HttpMethod.GET, httpEntity, String.class);
		// JSONObject jsonObject = new JSONObject(response.getBody());
		// System.out.println(jsonObject);

		return response.toString();
	}

	public String txnUTXOS(String txnId) throws Exception {
		// Unspent Transaction outputs - amount of digital currency remaining after a
		// cryptocurrency txn is executed.

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("project_id", apiKey);
		String s = null;
		HttpEntity<String> httpEntity = new HttpEntity<String>(s, headers);
		ResponseEntity<?> response = restTemplate.exchange(
				"https://cardano-mainnet.blockfrost.io/api/v0/txs/" + txnId + "/utxos", HttpMethod.GET, httpEntity,
				String.class);
		return response.toString();
	}

	public String specificBlock(String blockId) throws Exception {
		// Return the content of a requested block.

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("project_id", apiKey);
		String s = null;
		HttpEntity<String> httpEntity = new HttpEntity<String>(s, headers);
		ResponseEntity<?> response = restTemplate.exchange(
				"https://cardano-mainnet.blockfrost.io/api/v0/blocks/" + blockId, HttpMethod.GET, httpEntity,
				String.class);
		return response.toString();
	}

}
