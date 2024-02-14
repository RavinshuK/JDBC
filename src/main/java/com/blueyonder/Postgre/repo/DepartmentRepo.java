package com.blueyonder.Postgre.repo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.blueyonder.Postgre.model.Department;

@Repository
public class DepartmentRepo {
	
	@Autowired
	private JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void save(Department dep) {
		String sql="Insert into department (depid,depname,deplocation) values (?,?,?)";
		template.update(sql,dep.getDepid(),dep.getDepname(),dep.getDeplocation());
	}
	
	public List<Department> findAll(){
		
//		return template.query("Select * from department", new RowMapper<Department>() {
//			public Department mapRow(ResultSet rs,int rowNum) throws SQLException{
//				Department d=new Department();
//				d.setDepid(rs.getInt(1));
//				d.setDepname(rs.getString(2));
//				d.setDeplocation(rs.getString(3));
//				return d;
//			}
//		});
		String sql="Select * from department";
		
		RowMapper<Department> mapper=new RowMapper<Department>() {
			
			@Override
			public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
				Department d=new Department();
				d.setDepid(rs.getInt(1));
				d.setDepname(rs.getString(2));
				d.setDeplocation(rs.getString(3));
				return d;
			}
		};
		
		List<Department> deps=template.query(sql, mapper);
		return deps;
	
	}
}
