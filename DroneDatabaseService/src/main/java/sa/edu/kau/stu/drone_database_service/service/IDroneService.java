package sa.edu.kau.stu.drone_database_service.service;

import java.util.List;

import sa.edu.kau.stu.drone_base_library.entity.Drone;

public interface IDroneService {
	void addDrone(Drone drone);

	List<Drone> getAllDrones();

	Drone getDroneInfo(String id);

	boolean deleteDrone(String id);

	boolean updateDrone(String id, Drone droneToupdate);

	String getDroneModel(String id);

	double getDroneMass(String id);

	int getDroneBatteryCapacity(String id);

	double getDroneCurrentCharge(String id);

	int[] getDroneXValues(String id);

	int[] getDroneYValues(String id);

	int[] getDroneZValues(String id);
}
