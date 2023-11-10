package com.example.veeksdiary.controller;


import com.example.veeksdiary.data.dto.request.CreateDiaryRequest;
import com.example.veeksdiary.data.dto.request.CreateEntryRequest;
import com.example.veeksdiary.data.dto.response.CreateDiaryResponse;
import com.example.veeksdiary.data.dto.response.CreateEntryResponse;
import com.example.veeksdiary.services.DiaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diary")
@Controller
public class DiaryController {
    private final DiaryService service;

    public DiaryController(DiaryService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<?> createDiary(@RequestBody CreateDiaryRequest request){
        CreateDiaryResponse register = service.createDiary(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(register);
    }
    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody CreateDiaryRequest request){
        CreateDiaryResponse login = service.login(request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(login);
    }
    @GetMapping("/findDiary")
    public ResponseEntity<?> findDiary(@RequestBody CreateDiaryRequest request){
        CreateDiaryResponse foundDiary = service.findByEmail(request);
        return ResponseEntity.status(HttpStatus.FOUND).body(foundDiary);
    }
    @DeleteMapping("/deleteDiary")
    public ResponseEntity<?> deleteDiary(@RequestBody CreateDiaryRequest request){
        service.deleteByEmailAndPassword(request);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }

}
