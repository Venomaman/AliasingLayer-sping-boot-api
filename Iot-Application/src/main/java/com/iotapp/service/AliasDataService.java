package com.iotapp.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.iotapp.entity.Alias;
import com.iotapp.entity.AliasRequest;
import com.iotapp.entity.CustomDto;
import com.iotapp.entity.IotData;
import com.iotapp.entity.Request;
import com.iotapp.entity.Response;
import com.iotapp.repository.AliasRepository;
import com.iotapp.repository.IotDataRepo;

@Service
public class AliasDataService {
	
	@Autowired
	private AliasRepository aliasRepository;
	
	@Autowired
	private IotDataRepo iotDataRepo;
	
	public List<Response>calculateAliases(List<Request> aliasrequest){
		
		List<Response> response = new ArrayList<>();
		for(Request request: aliasrequest) {
			String aliasChannel = request.getAliasChannel();
			String originalChannel = request.getOriginalChannel();
			
			List<IotData> iotDataList = iotDataRepo.findByDeviceAndChannel(request.getDevice(), originalChannel);
			
			for(IotData iotdata: iotDataList) {
				Double calculateValue = calculateValue(aliasChannel, iotdata);
				LocalDateTime timestamp= iotdata.getTimestamp();
				Response resp = new Response(aliasChannel, calculateValue, timestamp);
				response.add(resp);
			}
		}
		return response;
		
		
	}
	
	public Alias createAlias(AliasRequest aliasRequest) {
		String aliasChannel = aliasRequest.getAliasChannel();
		
		Double calculatedValue = calculateVal(aliasChannel, aliasRequest);
		
		Alias alias = new Alias();
		alias.setDevice(aliasRequest.getDevice());
		alias.setOriginalChannel(aliasRequest.getOriginalChannel());
		alias.setAliasChannel(aliasChannel);
		alias.setValue(calculatedValue);
		
		return aliasRepository.save(alias);
	}
	
	private Double calculateValue(String aliasChannel, IotData iotData) {
		
		if("direction".equalsIgnoreCase(aliasChannel)) {
			double y = iotData.getValue();
			double x = iotData.getValue();
			return Math.toDegrees(Math.atan2(y, x));
		}else if("IsVisible".equalsIgnoreCase(aliasChannel)) {
			return iotData.getValue()>3 ? 1.0 : 0.0;
		}else if("SquareRoot".equalsIgnoreCase(aliasChannel)) {
			double a = iotData.getValue();
			return Math.sqrt(a);
		}
		
		return null;
	}
	
	//--------fetch alias detail-------
	
	public Alias getAliasById(Long id) {
		return aliasRepository.findById(id).orElse(null);
	}
	
	//----update/modify alias--------
	
	public Alias modifyAlias(Long id, AliasRequest aliasRequest) {
		Optional<Alias> optionalAlias = aliasRepository.findById(id);
		String aliasChannel = aliasRequest.getAliasChannel();
		Double calculatedValue = calculateVal(aliasChannel, aliasRequest);
		
		if(optionalAlias.isPresent()) {
			Alias alias = optionalAlias.get();
			alias.setDevice(aliasRequest.getDevice());
			alias.setOriginalChannel(aliasRequest.getOriginalChannel());
			alias.setAliasChannel(aliasRequest.getAliasChannel());
			alias.setValue(calculatedValue);
			
			return aliasRepository.save(alias);
		}else {
			return null;
		}
	}
	
	//--------delete existing alias-------------
	public String deleteAlias(Long id) {
		if(aliasRepository.existsById(id)) {
			aliasRepository.deleteById(id);
			return "Alias delete Success!";
		}else {
			return "Alias not found!!";
		}
	}
	
	//----------req and response api-------
	
	public List<CustomDto> getTimestampAndValue(String device, String aliasChannel){
		return aliasRepository.findTimestampAndValue(device, aliasChannel);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
private Double calculateVal(String aliasChannel, AliasRequest aliasRequest) {
		
		if("direction".equalsIgnoreCase(aliasChannel)) {
			double y = aliasRequest.getNewValue();
			double x = aliasRequest.getNewValue();
			return Math.toDegrees(Math.atan2(y, x));
		}else if("IsVisible".equalsIgnoreCase(aliasChannel)) {
			return aliasRequest.getNewValue()>3 ? 1.0 : 0.0;
		}else if("SquareRoot".equalsIgnoreCase(aliasChannel)) {
			double a = aliasRequest.getNewValue();
			return Math.sqrt(a);
		}
		
		return null;
	}

	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void copyDataToAliases() {
//		
//		List<IotData> iotData = iotDataRepo.findAll();
//		
//		List<AliasIotData> aliasiotData = new ArrayList<>();
//	
//		
//		for(IotData iotData1: iotData) {
//			AliasIotData aliasIotData = new AliasIotData();
//			aliasIotData.setAliasDevice(iotData1.getDevice());
//			aliasIotData.setAliasChannel(iotData1.newString(null));
//			aliasIotData.setAliasTimestamp(iotData1.getTimestamp());
//			aliasIotData.setAliasValue(iotData1.newValue(null));
//			aliasIotData.setCalValue(iotData1.calValue(null));
//			aliasIotData.setOriginalChannel(iotData1.getChannel());
//			aliasiotData.add(aliasIotData);
//		}
//		aliasIotDataRepo.saveAll(aliasiotData);
//		
//	}
//
//	
//	
//	
//	
//     public void createAliases(AliasIotData aliasIotData) {
////    	 AliasIotData aliasData = new AliasIotData();
////    	 aliasData.setAliasDevice(aliasDevice);
////    	 aliasData.setAliasChannel(aliasChannel);
////    	 aliasData.setAliasValue(aliasValue);
//   // 	 aliasData.setAliasTimestamp(aliasTimestamp);
//    	 
//    	 aliasIotDataRepo.save(aliasIotData);
//     }
//     
//     //create new Aliases....
//	
//     public void createNewAlias(AliasResponse aliasResponse) {
//    	 AliasIotData aliasData = new AliasIotData();
//   	     aliasData.setOriginalChannel(aliasResponse.getOriginalChannel());
//    	 aliasData.setAliasDevice(aliasResponse.getAliasDevice());
//    	 aliasData.setAliasChannel(aliasResponse.newAliasString(null));
//    	 aliasData.setAliasValue(aliasResponse.newAliasValue(null));
//    	 aliasData.setCalValue(aliasResponse.calValues(null));
//    	 aliasIotDataRepo.save(aliasData);
//     }
//     
//     //get all aliases data present in our database...
//     
//     public List<AliasIotData> getAliasData(){
//    	 return aliasIotDataRepo.findAll();
//     }
//     
//     //Update aliases data from database...
//     
//     public void updateAlias(AliasIotData aliasIotData) {
//    	 aliasIotDataRepo.save(aliasIotData);
//     }
//     public AliasIotData getAliasIotDataById(long id) {
//    	 return aliasIotDataRepo.findById(id).get();
//     }
//     //delete aliasData from database...
//     public void delete(long id) {
//    	 aliasIotDataRepo.deleteById(id);
//     }
//     
// //    public List<>
//     public List<Object[]> getAliasReqData(String aliasDevice,String aliasChannel) {
//    	 return aliasIotDataRepo.findByData(aliasDevice, aliasChannel);
//     }
//     


