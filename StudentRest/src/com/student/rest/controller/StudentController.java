package com.student.rest.controller;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.rest.bean.StudentBean;
import com.student.rest.dao.StudentDao;

@CrossOrigin
@RestController
@RequestMapping("/stds")
public class StudentController {

@Autowired
StudentDao dao;
	
/*@RequestMapping(value="/{saveStu}", method=RequestMethod.POST)
public ResponseEntity<Void> save(@RequestBody StudentBean data){
	Integer id = data.getStudentId();
	if(id!=null){
		dao.saveStudent(data);
		return new ResponseEntity<Void>(HttpStatus.OK);
			
	}else{
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
	
}
*/
@RequestMapping(value="/{id}",method=RequestMethod.GET)
public ResponseEntity<StudentBean> getStudentbyId(@PathVariable("id") Integer id){
	System.out.println("Id"+id);
	StudentBean studentData = dao.getStudentById(id);
	if(studentData!=null){
		ResponseEntity<StudentBean> data = new ResponseEntity<StudentBean>(studentData,HttpStatus.OK);
		return data;	
	}
	else{
		ResponseEntity<StudentBean> data = new ResponseEntity<StudentBean>(studentData,HttpStatus.NO_CONTENT);
		return data;
	}
	
}

@RequestMapping(value="/{saveStu}",method=RequestMethod.POST)
public ResponseEntity<Void> saveStudent(@RequestBody StudentBean data){
	dao.saveStudent(data);
	ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.CREATED);
	return response;
	
}

@RequestMapping(value="/",method=RequestMethod.GET)
public ResponseEntity<List<StudentBean>> listStudents(){
	
	List<StudentBean> list = dao.load();
	ResponseEntity<List<StudentBean>> responseJSON = new ResponseEntity<List<StudentBean>>(list,HttpStatus.OK);
	return responseJSON;
	
} 
@RequestMapping(value="/{cl}/{name}" ,method=RequestMethod.GET)
public ResponseEntity<List<StudentBean>> getStudentByNameAndID(@PathVariable("cl") String cl,@PathVariable("name") String name){
System.out.println("-----cl="+cl);
System.out.println("-----name="+name);

	List<StudentBean> searchData = dao.getDetails(cl,name);
	ResponseEntity<List<StudentBean>> response = new ResponseEntity<List<StudentBean>>(searchData, HttpStatus.OK);
	return response;
}

@RequestMapping(value="/{cl}/{id}",method=RequestMethod.GET)
public ResponseEntity<StudentBean> studentDetailsById(@PathVariable("cl") String clName,@PathVariable("id") Integer id){
	StudentBean data=dao.getDetailsById(clName, id);
	ResponseEntity<StudentBean> d = new ResponseEntity<StudentBean>(data,HttpStatus.OK);
	return d;
}

}
