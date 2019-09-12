package br.com.meatApp.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.meatApp.domain.Orders;
import br.com.meatApp.services.OrderService;

@Controller
@RequestMapping(value="orders")
public class OrderResources {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Orders>> findAll(){
		List<Orders> orders = orderService.findAll();
		return ResponseEntity.ok().body(orders);
	}
	
	@RequestMapping(value="id/{id}",method=RequestMethod.GET)
	public ResponseEntity<Orders> findById(@PathVariable Integer id){
		Orders orders = orderService.findById(id);
		return ResponseEntity.ok().body(orders);
	}

	public ResponseEntity<Orders> insert(@Valid @RequestBody Orders order){
		order = orderService.insert(order);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id/{id}").buildAndExpand(order.getId()).toUri();
		return ResponseEntity.created(uri).body(order);
	}
}
