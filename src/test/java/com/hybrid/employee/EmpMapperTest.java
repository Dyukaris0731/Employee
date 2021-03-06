package com.hybrid.employee;

import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.EmpMapper;
import com.hybrid.model.Dept;
import com.hybrid.model.Emp;

public class EmpMapperTest {

	static Log log = LogFactory.getLog(EmpMapperTest.class);
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("spring/beans_oracle.xml");
		
		EmpMapper empMapper = ctx.getBean(EmpMapper.class);
		
//		List<Emp> list = empMapper.selectAll();
		List<Emp> list = empMapper.selectAllWithDept();
		
		list.forEach(new Consumer<Emp>() {

			@Override
			public void accept(Emp e) {
				String msg=null;
				
				msg = e.getEmpno() + " "
					+ e.getEname() + " "
					+ e.getJob() + " "
					+ e.getMgr() + " "
					+ e.getHiredate() + " ";
				log.info(msg);
				
				Dept d = e.getDept();
				
				msg = "\t\t"
					+ d.getDeptno() + " "
				    + d.getDname() + " "
				    + d.getLoc();
				log.info(msg);
				
				
			}
		});
//		
////		Dept dept = deptMapper.selectByDeptno(20);
//		Dept dept = deptMapper.selectByDeptnoWithEmps(10);
//		
//		String msg = dept.getDeptno() + " "
//				   + dept.getDname() + " "
//				   + dept.getLoc();
//		log.info(msg);
//		
//		List<Emp> emps = dept.getEmps();
//		
//		if (emps != null)
//		for (Emp e : emps) {
//			msg = "\t\t"
//				+ e.getEmpno() + " "
//				+ e.getEname() + " "
//				+ e.getJob() + " "
//				+ e.getMgr() + " "
//				+ e.getHiredate() + " "
//				+ e.getSal() + " "
//				+ e.getDept().getDeptno() + " "
//				+ e.getDept().getDname() + " ";
//			log.info(msg);
//		}
//
	}

}
