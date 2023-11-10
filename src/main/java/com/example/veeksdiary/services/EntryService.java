package com.example.veeksdiary.services;


import com.example.veeksdiary.data.dto.request.CreateEntryRequest;
import com.example.veeksdiary.data.dto.response.CreateEntryResponse;
import com.example.veeksdiary.data.model.Entry;

import java.util.List;
public interface EntryService {
    Entry createEntry(CreateEntryRequest createEntryRequest);
    CreateEntryResponse findByTitle(CreateEntryRequest createEntryRequest);
    List<CreateEntryResponse> viewAll();
    void deleteByTitle(CreateEntryRequest request);
    CreateEntryResponse editEntry(CreateEntryRequest createEntryRequest);
    void save(Entry entry);
}
