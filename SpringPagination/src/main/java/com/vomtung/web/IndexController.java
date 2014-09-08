package com.vomtung.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vomtung.entity.Product;
import com.vomtung.service.ProductService;

@Controller
@RequestMapping(value="/index")
public class IndexController {
	
	@Autowired(required = true)
	private ProductService productService;
	
	@RequestMapping(method=RequestMethod.GET)
	String index(){
		//List<Product>products=productService.findAll(page);
		//mm.put("products", products);
		return "index";
	}
	
	@RequestMapping(value="/getproduct",method=RequestMethod.GET)
	@ResponseBody
	ResponseEntity<String> showProducts(@RequestParam(value="page",defaultValue="1")int page){
		List<Product>products=productService.findAll(page);
		long totalProduct=productService.countAll();
		String productString=Product.toJsonArray(products);
		return new ResponseEntity("{"+"\"products\":"+productString+","+"\"totalProduct\":"+totalProduct+"}",HttpStatus.OK);
	}
}
