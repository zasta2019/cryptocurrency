package com.blockchain.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BtcService {

	public String txnDetails(String txnId) throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		// headers.add("project_id", apiKey);
		String s = null;
		HttpEntity<String> httpEntity = new HttpEntity<String>(s, headers);
		// ResponseEntity<?> response = restTemplate.exchange(
		// "https://www.blockonomics.co/api/tx_detail?txid=" + txnId,
		// HttpMethod.GET, httpEntity, String.class);
		ResponseEntity<?> response = restTemplate.exchange("https://api.blockcypher.com/v1/btc/main/txs/" + txnId,
				HttpMethod.GET, httpEntity, String.class);

		// JSONObject jsonObject = new JSONObject(response.getBody());
		// System.out.println(jsonObject);

		return response.toString();
	}

}
