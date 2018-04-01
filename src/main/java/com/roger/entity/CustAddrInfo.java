package com.roger.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cust_addr_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustAddrInfo {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Column(name = "cust_no")
	private String custNo;
	
	@Column(name = "cust_addr")
	private String custAddr;
	
	@Column(name = "cust_code")
	private String custCode;
}
