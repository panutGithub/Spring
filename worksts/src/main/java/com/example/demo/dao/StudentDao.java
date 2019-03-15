package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import com.example.demo.Model.StdentModel;
import com.example.demo.Model.StudentModel1;

public interface StudentDao {

	void insert(StdentModel stdentModel);
  
	void insertClass(String[] checkNullMethod, StdentModel studentModel, Map mapKeyUpdate);
	
	void insertClass(String name);

	void insertTeacher(String name);
	
    List<StdentModel> findAll();
    
    List<StudentModel1> searchby(String namecolumn,String valueColumn);
    
    List<StdentModel> showcolumn(String nameColumn);
        
	void updateCell(String username,String valueName);
 

	
    
    
}
