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
@Table(name = "card_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardInfo {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Column(name = "account_no")
	private String accountNo;
	
	@NotNull
	@Column(name = "card_no")
	private String cardNo;
	
	@NotNull
	@Column(name = "bank_id")
	private String bankId;
}
