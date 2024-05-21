package com.example.demo.service;

import com.example.demo.model.MrtStation;
import com.example.demo.repository.MrtStationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MrtStationService {

    private  MrtStationRepository mrtStationRepository;

    // 新增一個 mrtStation
    public MrtStation createMrtStation(MrtStation mrtstation) {
        return mrtStationRepository.save(mrtstation);
    }

    // 獲取所有 mrtStation
    public List<MrtStation> getAllStation() {
        return mrtStationRepository.findAll();
    }

    // 獲取單個 mrtStation
    public Optional<MrtStation> getStationByStationID(int stationID) {
        return mrtStationRepository.findBystation_id(stationID);
    }

    // 更新一個 mrtStation
    public MrtStation updateMrtStation(int stationID, MrtStation newMrtStation) {
        Optional<MrtStation> mrtStationOptional = mrtStationRepository.findBystation_id(stationID);
        if(mrtStationOptional.isPresent()){
            MrtStation mrtStation = mrtStationOptional.get();
            mrtStation.setLocation(newMrtStation.getLocation());
            mrtStation.setStationID(newMrtStation.getStationID());
            mrtStation.setStationName(newMrtStation.getStationName());
            return mrtStationRepository.save(mrtStation);
        }
        return null;
    }


    // 刪除一個 mrtStation
    public void deleteMrtStation(int stationID) {
        mrtStationRepository.deleteBystation_id(stationID);
    }
}