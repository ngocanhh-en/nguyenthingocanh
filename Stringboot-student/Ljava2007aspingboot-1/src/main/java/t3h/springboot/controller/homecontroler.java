package t3h.springboot.controller;


import java.util.ArrayList;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import t3h.springboot.pojo.student;

@Controller

public class homecontroler {
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getHome(Model model)
	{
		System.out.println("Hello wordl");
		model.addAttribute("hello","Helloworld");
		model.addAttribute("liststudent", getListstudent());
		model.addAttribute("gender","F");
		model.addAttribute("student", new student ("", ""));
		
		return "home";
	}
	
	private List<student> getListstudent()
	{
		List<student>result= new ArrayList<>();
		result.add(new student("0001","Nguyen Van A"));
		result.add(new student("0002","Nguyen Van B"));
		result.add(new student("0003","Nguyen Van C"));
		return result;
	}
	
	@RequestMapping(value="/viewStudent/{id}", method=RequestMethod.GET)
	public String viewStudent(@ModelAttribute(name="student")student student)
	{
		return"View";
	}
	
	@RequestMapping(value="/submitStudent", method=RequestMethod.POST)
	public String submitStudent(@ModelAttribute(name="student")student student)
	{
		System.out.println("id:" +student.getId());
		System.out.println("name:" +student.getName());
		return "success";
	}
	
	@RequestMapping(value="/updateStudent/{id}",method=RequestMethod.GET)
	public String updateStudent(@ModelAttribute(name="student")student student)
	{
		return"Update";
	}
	
	@RequestMapping(value="/deleteStudent/{id}",method=RequestMethod.GET)
	public String deleteStudent(@ModelAttribute(name="student")student student)
	{
		return"Delete";
	}
}
