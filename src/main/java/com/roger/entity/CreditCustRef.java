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
@Table(name = "credit_cust_ref")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCustRef {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Column(name = "credit_no")
	private String creditNo;
	
	@NotNull
	@Column(name = "cust_no")
	private String custNo;
}
