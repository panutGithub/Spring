package com.example.demo.service.imp;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.StdentModel;
import com.example.demo.Model.StudentModel1;
import com.example.demo.dao.StudentDao;
import com.example.demo.service.StudentService;

//import th.co.maximus.bean.MapGLBean;

@Service
public class StdentServiceImp implements StudentService {

	@Autowired
	StudentDao studentDao;

	Map<String, String> mapKey = new HashMap<String, String>();

	@Override
	public String insert(StdentModel studentModel) {
		studentDao.insert(studentModel);
		return "Success";
	}

	@Override
	public List<StdentModel> searchAll(StdentModel studentModel) {
		System.out.println("Select * form");
		return studentDao.findAll();
	}

	@Override
	public List<StudentModel1> searchby(String namecolumn,String valueColumn) {
		return studentDao.searchby(namecolumn,valueColumn);
	}

	@Override
	public List<StdentModel> showcolumn(String nameColumn) {
		return studentDao.showcolumn(nameColumn);
	}
 
	@Override
	public void updateCell(String username , String valueName ) {
		studentDao.updateCell(username, valueName);
	}

}
