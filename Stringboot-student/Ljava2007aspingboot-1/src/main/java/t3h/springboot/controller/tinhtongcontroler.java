package t3h.springboot.controller;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //API
public class tinhtongcontroler {
	
	@RequestMapping(value="/tinhtong", method=RequestMethod.GET)
	public ResponseEntity<String>tinhtong (@RequestParam int num1, @RequestParam int num2)
	{
		int total=num1+num2;
		return new ResponseEntity<String>(String.valueOf(total),HttpStatus.OK);
	}
}
