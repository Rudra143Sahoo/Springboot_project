package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Tourist;
import com.nt.repository.ITouristRepository;

@Service
public class TouristMgmtServiceImpl  implements ITouristMgmtService {
	@Autowired
	private  ITouristRepository  touristRepo;

	@Override
	public String registerTourist(Tourist tourist) {
		//use  repo
		int idVal=touristRepo.save(tourist).getTid();
		return "Tourist is saved with the id Value::"+idVal;
	}
	
	@Override
	public List<Tourist> showAllTourists() {
		return touristRepo.findAll().stream().sorted((t1,t2)->t1.getTid()<t2.getTid()?1:-1).toList();
	}
	
	@Override
	public   Tourist   showTouristById(int id) {
		return   touristRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
	}
	
	@Override
	public String updateTourist(Tourist tourist) {
	    //load tourist
		Optional<Tourist> opt=touristRepo.findById(tourist.getTid());
		if(opt.isPresent()) {
			//updte  the object
			touristRepo.save(tourist);
			return  tourist.getTid()+" Tourist details are updated";
		}
		return  tourist.getTid()+" Tourist is not found for  updation";
	}
	
	@Override
	public String updateTouristBudget(int tid, double hikePercentage) {
		  //load tourist
				Optional<Tourist> opt=touristRepo.findById(tid);
				if(opt.isPresent()) {
					//get  Tourist object
					Tourist  tourist=opt.get();
					// calculate new budget
					tourist.setBudget(tourist.getBudget()+(tourist.getBudget()*hikePercentage/100.0));
					//update  the object
					touristRepo.save(tourist);
					return  tourist.getTid()+" Tourist Budget details are updated";
				}
				return  tid+" Tourist is not found for  updation";
	}
	
	@Override
	public String deleteTouristById(int id) {
		//Load  Object
		Optional<Tourist> opt=touristRepo.findById(id);
		if(opt.isPresent()) {
			//delete the object
			touristRepo.deleteById(id);
			return  id+" Tourist is found  and deleted";
		}
		return  id+" Tourist is not found for  deletion";

	}

}
