//Tourist.java
package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Table(name="REST_TOURIST")
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tourist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer tid;
	@NonNull
	@Column(length = 30)
	private  String  tname;
	@Column(length = 30)
	@NonNull
	private  String packageType;
	@Column(length = 30)
	@NonNull
	private  String  startLocation;
	@Column(length = 30)
	@NonNull
	private  String  endLocation;
	@NonNull
	private   Double budget; 

}
