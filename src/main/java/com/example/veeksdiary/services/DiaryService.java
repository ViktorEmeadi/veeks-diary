package com.example.veeksdiary.services;

import com.example.veeksdiary.data.dto.request.CreateDiaryRequest;
import com.example.veeksdiary.data.dto.request.CreateEntryRequest;
import com.example.veeksdiary.data.dto.response.CreateDiaryResponse;
import com.example.veeksdiary.data.dto.response.CreateEntryResponse;

import java.util.List;

public interface DiaryService {
    CreateDiaryResponse createDiary(CreateDiaryRequest createDiaryRequest);
    CreateDiaryResponse login(CreateDiaryRequest request);
    CreateDiaryResponse findByEmail(CreateDiaryRequest createDiaryRequest);
    void deleteByEmailAndPassword(CreateDiaryRequest createDiaryRequest);
}