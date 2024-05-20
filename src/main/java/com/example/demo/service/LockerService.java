package com.example.demo.service;

import com.example.demo.model.Locker;
import com.example.demo.repository.LockerRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LockerService {
    private final LockerRepository lockerRepository;

// 獲取所有 lockers
    public LockerService(LockerRepository lockerRepository) {
        this.lockerRepository = lockerRepository;
    }

// 利用Locker_ID獲取單個locker

// 利用Locker_ID刪除一個 locker
public void deleteLocker(Long Locker_ID) {
    lockerRepository.deleteById(Locker_ID);
}
}
