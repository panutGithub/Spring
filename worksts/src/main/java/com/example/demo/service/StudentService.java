package com.example.demo.service;

import java.util.List;

import com.example.demo.Model.StdentModel;

public interface StudentService {
	
	String insert(StdentModel stdentModel);
	List searchAll(StdentModel stdentModel); 
	List searchby(String namecolumn,String valueColumn);
	List showcolumn(String nameColumn); 
	
	void updateCell(String username , String valueName );
}
