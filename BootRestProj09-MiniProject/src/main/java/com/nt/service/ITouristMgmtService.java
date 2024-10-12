package com.nt.service;

import java.util.List;

import com.nt.entity.Tourist;

public interface ITouristMgmtService {
	 public  String  registerTourist(Tourist  tourist);
	 public  List<Tourist>  showAllTourists();
	 public   Tourist  showTouristById(int id);
	 public  String     updateTourist(Tourist  tourist);
	 public   String    updateTouristBudget(int  tid,double hikePercentage);
	 public  String   deleteTouristById(int id);  
}
