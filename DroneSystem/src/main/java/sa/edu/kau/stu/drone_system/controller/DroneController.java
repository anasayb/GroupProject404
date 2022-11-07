package sa.edu.kau.stu.drone_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import sa.edu.kau.stu.drone_base_library.entity.Drone;
import sa.edu.kau.stu.drone_database_service.service.IDroneService;

@Controller
public class DroneController {
	@Autowired
	IDroneService myDrones;

	@Autowired
	public DroneController(IDroneService _droneService) {
	}

	@PostMapping
	public void addDrone(@RequestBody Drone drone) {
		myDrones.addDrone(drone);
	}

	@GetMapping("/")
	public String getAllDrone(Model model) {
		model.addAttribute("Drones",myDrones.getAllDrones());
		return "index";
	}

	@GetMapping(path = "{id}")
	public Drone getDroneById(@PathVariable("id") long id) {
		return myDrones.getDroneInfo(id);
	}

	@DeleteMapping(path = "{id}")
	public boolean deleteDroneById(@PathVariable("id") long id) {
		return myDrones.deleteDrone(id);
	}

	@PutMapping(path = "{id}")
	public boolean updateDrone(@PathVariable("id") long id, @RequestBody Drone droneToupdate) {
		return myDrones.updateDrone(id, droneToupdate);
	}

	@GetMapping(path = "model/{id}")
	public StringResponseWrapper getDroneModel(@PathVariable("id") long id) {
		StringResponseWrapper s = new StringResponseWrapper(myDrones.getDroneModel(id));
		return s;
	}

	@GetMapping(path = "mass/{id}")
	public double getDroneMass(@PathVariable("id") long id) {
		return myDrones.getDroneMass(id);
	}

	@GetMapping(path = "batteryCapacity/{id}")
	public int getDroneBatterCapacity(@PathVariable("id") long id) {
		return myDrones.getDroneBatteryCapacity(id);
	}

	@GetMapping(path = "currentCharge/{id}")
	public double getDroneCurrentCharege(@PathVariable("id") long id) {
		return myDrones.getDroneCurrentCharge(id);
	}
}
