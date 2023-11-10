package com.example.veeksdiary.services;

import com.example.veeksdiary.data.dto.request.CreateEntryRequest;
import com.example.veeksdiary.data.dto.response.CreateEntryResponse;
import com.example.veeksdiary.data.model.Entry;
import com.example.veeksdiary.data.repository.EntryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EntryServiceImpl implements EntryService{
    @Autowired
    private EntryRepository repository;
    private List<CreateEntryResponse> responses = new ArrayList<>();

    @Override
    public Entry createEntry(CreateEntryRequest request) {
        Entry entry = Entry.builder().entryTitle(request.getTitle()).entryBody(request.getBody()).build();
        Optional<Entry> foundEntry = repository.findEntryByEntryTitle(request.getTitle());
        if(foundEntry.isPresent()){ throw new RuntimeException("Title already exist");}
        return repository.save(entry);
    }

    private Entry findByTitle(String title){
        Optional<Entry> foundEntry = repository.findEntryByEntryTitle(title);
        if(foundEntry.isEmpty()){ throw new RuntimeException("User does not exist"); }
        return foundEntry.get();
    }
    @Override
    public CreateEntryResponse findByTitle(CreateEntryRequest request) {
        CreateEntryResponse response = new CreateEntryResponse();
        Entry foundEntry = findByTitle(request.getTitle());
        BeanUtils.copyProperties(foundEntry, response);
        return response;
    }
    @Override
    public List<CreateEntryResponse> viewAll() {
        List<Entry> entries = repository.findAll();
        for(Entry entry : entries){
            CreateEntryResponse response = CreateEntryResponse.builder()
                    .title(entry.getEntryTitle())
                    .body(entry.getEntryBody())
                    .build();
            responses.add(response);
        }
        return responses;
    }

    @Override
    public void deleteByTitle(CreateEntryRequest request) {
        Entry foundEntry = findByTitle(request.getTitle());
        repository.delete(foundEntry);
    }

    @Override
    public CreateEntryResponse editEntry(CreateEntryRequest request) {
        CreateEntryResponse response = new CreateEntryResponse();
        Entry entry = findByTitle(request.getTitle());
        entry.setEntryBody(request.getBody());
        Entry editedEntry = repository.save(entry);
        BeanUtils.copyProperties(editedEntry, request);
        return response;
    }

    @Override
    public void save(Entry entry) {
        repository.save(entry);
    }
}
