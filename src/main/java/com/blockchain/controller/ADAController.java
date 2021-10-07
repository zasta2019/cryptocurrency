package com.blockchain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blockchain.service.AdaService;

@RestController
public class ADAController {

	@Autowired
	private AdaService adaService;

	@GetMapping(value = "/v1/api/specify/txn/{txnId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> specifyTransaction(@PathVariable String txnId) throws Exception {

		return new ResponseEntity<>(adaService.specificTxn(txnId), HttpStatus.CREATED);
	}

	@GetMapping(value = "/v1/api/utxos/txn/{txnId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> txnUTXOS(@PathVariable String txnId) throws Exception {

		return new ResponseEntity<>(adaService.txnUTXOS(txnId), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/v1/api/blocks/{blockId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> specificBlock(@PathVariable String blockId) throws Exception {

		return new ResponseEntity<>(adaService.specificBlock(blockId), HttpStatus.CREATED);
	}
	
	
}
