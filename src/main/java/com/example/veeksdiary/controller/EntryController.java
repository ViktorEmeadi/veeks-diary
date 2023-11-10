package com.example.veeksdiary.controller;

import com.example.veeksdiary.data.dto.request.CreateEntryRequest;
import com.example.veeksdiary.data.dto.response.CreateEntryResponse;
import com.example.veeksdiary.data.model.Entry;
import com.example.veeksdiary.services.EntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Controller
@RequiredArgsConstructor
public class EntryController {
    private final EntryService service;
    @GetMapping("/createEntry")
    public ResponseEntity<String> createEntry(@RequestBody CreateEntryRequest request){
        Entry createdEntry = service.createEntry(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Entry created successfully");
    }
    @PostMapping("/findEntry")
    public ResponseEntity<?> findEntry(@RequestBody CreateEntryRequest request){
        CreateEntryResponse foundEntry = service.findByTitle(request);
        return ResponseEntity.status(HttpStatus.FOUND).body(foundEntry);
    }
    @PostMapping("/viewAllEntries")
    public ResponseEntity<List<?>> viewAllEntries(@RequestBody CreateEntryRequest request){
        List<CreateEntryResponse> entries = service.viewAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(entries);
    }
    @GetMapping("/editEntry")
    public ResponseEntity<?> editEntry(@RequestBody CreateEntryRequest request){
        CreateEntryResponse editedEntry = service.editEntry(request);
        return ResponseEntity.status(HttpStatus.OK).body(editedEntry);
    }
    @DeleteMapping("/deleteEntry")
    public ResponseEntity<?> deleteEntry(@RequestBody CreateEntryRequest request){
        service.deleteByTitle(request);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
