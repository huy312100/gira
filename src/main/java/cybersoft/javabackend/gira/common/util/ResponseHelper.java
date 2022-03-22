package cybersoft.javabackend.gira.common.util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.mapstruct.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class ResponseHelper {

	public static ResponseEntity<Object> getResponse(Object obj,HttpStatus status){
		Map<String,Object> map=new HashMap<String, Object>();
		
		map.put("content", obj);
		map.put("hasErrors",false);
		map.put("error", "");
		map.put("timestamp", LocalDateTime.now());
		map.put("status", status.value());
		return new ResponseEntity<>(map,status);
	}
	
	public static ResponseEntity<Object> getErrorResponse(BindingResult errors,HttpStatus status){
		Map<String,Object> map=new HashMap<String, Object>();
		
		map.put("content", null);
		map.put("hasErrors",false);
		map.put("error", ErrorHelper.getAllError(errors));
		map.put("timestamp", LocalDateTime.now());
		map.put("status", status.value());
		return new ResponseEntity<>(map,status);
	}
	
	public static ResponseEntity<Object> getErrorResponse(String error,HttpStatus status){
		Map<String,Object> map=new HashMap<String, Object>();
		
		map.put("content", null);
		map.put("hasErrors",false);
		map.put("error", error);
		map.put("timestamp", LocalDateTime.now());
		map.put("status", status.value());
		return new ResponseEntity<>(map,status);
	}
}
