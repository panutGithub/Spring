package com.example.demo.impement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.demo.Constants;
import com.example.demo.Model.StdentModel;
import com.example.demo.Model.StudentModel1;
import com.example.demo.dao.StudentDao;

//import th.co.maximus.constants.Constants;

//import th.co.maximus.dao.MasterDataDaoImpl.masterData;

//import th.co.maximus.dao.MasterDataDaoImpl.masterData;

@Service
public class StdentDaoImp implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final class mapper implements RowMapper<StdentModel> {

		
		  @Override public StdentModel mapRow(ResultSet rs, int rowNum) throws
		  SQLException { StdentModel model = new StdentModel();
		  model.setId(rs.getLong("id_test")); model.setName(rs.getString("name_test"));
		  model.setEmail(rs.getString("email_test"));
		  model.setAddress(rs.getString("address_test"));
		  model.setUsername(rs.getString("username_test"));
		  
		  return model; }
		 
		
	}
	
	private static final class mapper2 implements RowMapper<StudentModel1> {

		@Override
		public StudentModel1 mapRow(ResultSet rs, int rowNum) throws SQLException {
			StudentModel1 model = new StudentModel1();
			model.setId(rs.getLong("id"));
			model.setName(rs.getString("name"));
			model.setUsername(rs.getString("username"));

			return model;
		}	
		
	}

	@Override
	public void insert(StdentModel stdentModel) {
		String sql = "INSERT INTO t_test (name_test, email_test, address_test , username_test )  VALUES (?,?,?,?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(sql, new String[] { "id_test" });
				pst.setString(1, stdentModel.getName());
//				pst.setString(2, stdentModel.getEmail());
//				pst.setString(3, stdentModel.getAddress());
				pst.setString(4, stdentModel.getUsername());
				return pst;
			}
		});
	}

	@Override
	public List<StdentModel> findAll() {
//		String sql = "select * from t_test WHERE name_test = *";
		String sql = "SELECT * FROM `student`";
		List<StdentModel> arr = new ArrayList<>();
		arr = jdbcTemplate.query(sql.toString(), new mapper());
		return arr;
	}

	@Override
	public List<StudentModel1> searchby(String namecolumn,String valueColumn) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM `student` WHERE `"+namecolumn+"` = '"+valueColumn+"'");
		List<StudentModel1> arr = new ArrayList<>();
		arr = jdbcTemplate.query(sql.toString(), new mapper2());
		return arr;
	}
	
	@Override
	public List<StdentModel> showcolumn(String nameColumn) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT "+"'"+nameColumn+"'"+" FROM `t_test`");
		sql.append(" WHERE  username_test = 'userNew1'");
//		sql.append(" WHERE  username_test = '" + stdentModel.getUsername() + "'");  SELECT username_test FROM `t_test` WHERE username_test = 'userNew1'
		List<StdentModel> arr = new ArrayList<>();
		arr = jdbcTemplate.query(sql.toString(), new mapper());
		return arr;
	}
  
	@Override
	public void insertClass(String[] checkNullMethod, StdentModel studentModel, Map mapKeyUpdate) {

		Map<String, String> key = mapKeyUpdate;

		for (int i = 0; i < checkNullMethod.length; i++) {
			int around = 0;
			if (!checkNullMethod[i].equals("null")) {
				if (around == i) {
					for (Map.Entry me : key.entrySet()) {
						around++;
						StringBuilder sqlStmt = new StringBuilder();
						sqlStmt.append("UPDATE t_test SET '" + me.getKey() + "' = '" + checkNullMethod[i] + "'");
						sqlStmt.append(" WHERE  username_test = ?");
						Map<String, Object> params = new HashMap<String, Object>();
						params.put("username", studentModel.getUsername());
						jdbcTemplate.update(sqlStmt.toString(), new Object[] { params.get("username") });
					}
				}
			} else
				System.out.println(checkNullMethod[i] + " : null");

		}

	}

	@Override
	public void insertClass(String name) {
		System.out.println("xxx");
	}

	@Override
	public void insertTeacher(String name) {
		System.out.println("zzz");
	}

	@Override
	public void updateCell(String username,String valueName) {
//		StudentModel1 studentModel1 = new StudentModel1();
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE student");
		sql.append(" SET name = '"+valueName+"' WHERE username = '"+username+"'");
		
//		List<Object> param = new LinkedList<Object>();
//		param.add(username);
//		param.add(valueName);
		jdbcTemplate.update(sql.toString());
		
	}

}
