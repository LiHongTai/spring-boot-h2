package com.roger.request;

import com.roger.annotation.NodeName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationModel {

	@NodeName(value = "opertaion")
	private String opertaion;
	
	@NodeName(value = "inputData")
	private Object inputData;
	
	@NodeName(value = "outputSchema")
	private String outputSchema;
	
	private String invokeKey;
	
}
