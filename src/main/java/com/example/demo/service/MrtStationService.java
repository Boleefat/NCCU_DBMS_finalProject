package com.example.demo.service;

import com.example.demo.model.MrtStation;
import com.example.demo.model.User;
import com.example.demo.repository.MrtStationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MrtStationService {

    private final MrtStationRepository mrtStationRepository;

    // 新增一個 mrtStation
    public MrtStation createMrtStation(MrtStation mrtstation) {
        return mrtStationRepository.save(mrtstation);
    }

    // 獲取所有 mrtStation
    public List<MrtStation> getAllStation() {
        return mrtStationRepository.findAll();
    }

    // 獲取單個 mrtStation
    public MrtStation getStationByStationID(Long stationID) {
        return mrtStationRepository.findBystation_id(stationID);

    // 更新一個 mrtStation
    public MrtStation updateMrtStation(Long stationID, MrtStation newMrtStation) {
        MrtStation mrtStation = this.getStationByStationID(stationID);
        mrtStation.setStationName(mrtStation.getStationName());
        mrtStation.setStationID(mrtStation.getStationID());
        mrtStation.setLocation(mrtStation.getLocation());
        mrtStation.setLockerAreas(mrtStation.getLockerAreas());
        return mrtStationRepository.save(mrtStation);
    }


    // 刪除一個 mrtStation
    public void deleteMrtStation(Long stationID) {
        mrtStationRepository.deleteBystation_id(stationID);
    }
    

 

}