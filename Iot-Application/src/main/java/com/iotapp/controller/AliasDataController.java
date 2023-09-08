package com.iotapp.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iotapp.entity.Alias;
import com.iotapp.entity.AliasRequest;
import com.iotapp.entity.CustomDto;
import com.iotapp.entity.CustomDtoReq;
//import com.iotapp.entity.AliasIotData;
import com.iotapp.entity.IotData;
import com.iotapp.entity.Request;
import com.iotapp.entity.Response;
import com.iotapp.service.AliasDataService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class AliasDataController {
	
	@Autowired
	private AliasDataService aliasDataService;
	
	@PostMapping("/makeAlias")
	public ResponseEntity<List<Response>> calculateAliases(@RequestBody List<Request> request){
		List<Response> responses = aliasDataService.calculateAliases(request);
		return ResponseEntity.ok(responses);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Alias> registerAlias(@RequestBody AliasRequest aliasRequest){
		Alias createdAlias = aliasDataService.createAlias(aliasRequest);
		if(createdAlias != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdAlias);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/alias/{id}")
	public ResponseEntity<Alias> getAliasDetail(@PathVariable Long id){
		Alias alias = aliasDataService.getAliasById(id);
		if(alias != null) {
			return ResponseEntity.ok(alias);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Alias> modifyAlias(@PathVariable Long id ,@RequestBody AliasRequest aliasRequest){
		Alias modifyAlias = aliasDataService.modifyAlias(id, aliasRequest);
		if(modifyAlias != null) {
			return ResponseEntity.ok(modifyAlias);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAlias(@PathVariable Long id){
		String deleteResult = aliasDataService.deleteAlias(id);
		if("Alias delete Success!".equals(deleteResult)) {
			return ResponseEntity.ok(deleteResult);
	}else if("Alias not found!!".equals(deleteResult)) {
		return ResponseEntity.notFound().build();
	}else {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occured!");
	}
		
	}
	
	@PostMapping("/response")
	public ResponseEntity<List<CustomDto>> getTimestampAndValue(@RequestBody CustomDtoReq dto){
		List<CustomDto> values = aliasDataService.getTimestampAndValue(dto.getDevice(), dto.getAliasChannel());
		if(!values.isEmpty()) {
			return ResponseEntity.ok(values);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	
	
	
	
	
	
	
}




//--------------------------------------------------------------
	
	
//	@GetMapping("/aliases")
//	public ResponseEntity<String> copyData(){
//		aliasDataService.copyDataToAliases();
//		return ResponseEntity.ok("Aliases data created");
//	}
//	
//	@PostMapping("/addalias")
//	public ResponseEntity<Void>createAlias(@RequestBody AliasIotData aliasIotData){
//		 aliasDataService.createAliases(aliasIotData);
//		return ResponseEntity.status(HttpStatus.OK).build();
//	}
//	
//	@PostMapping("/newalias")
//	public ResponseEntity<?> CreateNewAlias(@RequestBody AliasResponse aliasResponse){
//		aliasDataService.createNewAlias(aliasResponse);
//		return ResponseEntity.status(HttpStatus.OK).build();
//	}
//	
//	
//	@GetMapping("/aliasData")
//	public ResponseEntity<List<AliasIotData>>getAllAliasData(){
//		List<AliasIotData> aliasData = aliasDataService.getAliasData();
//		if(aliasData.size()==0) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//		return ResponseEntity.of(Optional.of(aliasData));
//	}
//	
//	@PutMapping("alias/{id}")
//		private AliasIotData update(@RequestBody AliasIotData aliasIotData, @PathVariable long id) {
//			aliasIotData.setId(id);
//			aliasDataService.updateAlias(aliasIotData);
//			return aliasIotData;
//		}
//	
//	@DeleteMapping("deleteAlias/{id}")
//	private void deleteAliasData(@PathVariable("id") long id) {
//		aliasDataService.delete(id);
//	}
//	
//	@PostMapping("/aliasRequest")
//	public ResponseEntity<List<Object[]>> getAliasReq(@RequestBody Request request){
//		String device = request.getAliasDevice();
//		String channel= request.getAliasChannel();
//		List<Object[]> data = aliasDataService.getAliasReqData(device, channel);
//		return ResponseEntity.ok(data);
//	}
	
	
	
	
	


