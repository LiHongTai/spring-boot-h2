package com.roger.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cis_schema_config")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CisSchemaConfig {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "column_name")
	private String columnName;
	
	@Column(name = "table_name")
	private String tableName;
	
	@Column(name = "level")
	private String level;
	
	@Column(name = "priority")
	private String priority;
	
	@Column(name = "key")
	private String key;
	
	@Column(name = "necessary")
	private String necessary;
}
