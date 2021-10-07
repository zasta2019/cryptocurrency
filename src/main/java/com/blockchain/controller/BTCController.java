package com.blockchain.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.blockchain.service.BtcService;

@RestController
public class BTCController {

	@Autowired
	private BtcService btcService;

	//private final Bucket bucket;

	/*public BTCController() {
		//LIMIT TO 21 REQUEST PER MINUTE
		Bandwidth limit = Bandwidth.classic(2, Refill.greedy(2, Duration.ofMinutes(1)));
		this.bucket = Bucket4j.builder().addLimit(limit).build();
	}*/

	@GetMapping(value = "/v1/api/btc/txn/{txnId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> specifyTransaction(@PathVariable String txnId) throws Exception {
		//if (bucket.tryConsume(1)) {
			return new ResponseEntity<>(btcService.txnDetails(txnId), HttpStatus.CREATED);
		//}
		//return new ResponseEntity<>("Too many request. Please try in sometime!!", HttpStatus.TOO_MANY_REQUESTS);

	}
	
}
