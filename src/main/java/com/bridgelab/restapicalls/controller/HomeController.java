package com.bridgelab.restapicalls.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelab.restapicalls.entities.User;

@RestController
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(value = { "", "/", "/hello" })
	public String sayHello() {
		return "Hello World";
	}

	// localhost:8080/home/query/?name=Amit
	@RequestMapping(value = { "/query" }, method = RequestMethod.GET)
	public String sayHelloWithName(@RequestParam(value = "name") String name) {
		return "Hello " + name;
	}

	// localhost:8080/home/param/Pooja
	@GetMapping("/param/{name}")
	public String sayHelloWithPathVariable(@PathVariable String name) {
		return "Hello " + name + " , using path variable";
	}

	// localhost:8080/home/adduser
	// {
	// "fName":"Amit",
	// "lName":"Sisodiya"
	// }
	@PostMapping("/adduser")
	public String addUser(@RequestBody User user) {
		return "Hello " + user.getfName() + " " + user.getlName() + " !!";
	}

	// localhost:8080/home/put/sisodiya/?fname=Amit
	@PutMapping("/put/{lname}")
	public String putUser(@PathVariable String lname, @RequestParam(value = "fname") String fname) {
		return "Hello " + fname + " " + lname + "!!";
	}
}
