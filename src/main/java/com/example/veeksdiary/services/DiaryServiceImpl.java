package com.example.veeksdiary.services;

import com.example.veeksdiary.data.dto.request.CreateDiaryRequest;
import com.example.veeksdiary.data.dto.request.CreateEntryRequest;
import com.example.veeksdiary.data.dto.response.CreateDiaryResponse;
import com.example.veeksdiary.data.dto.response.CreateEntryResponse;
import com.example.veeksdiary.data.model.Diary;
import com.example.veeksdiary.data.model.Entry;
import com.example.veeksdiary.data.repository.DiaryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DiaryServiceImpl implements DiaryService{
    private final DiaryRepository repository;
    private final EntryService entryService;
    @Autowired
    public DiaryServiceImpl(DiaryRepository repository, EntryService entryService){
        this.entryService = entryService;
        this.repository = repository;
    }
    private Long id;



    @Override
    public CreateDiaryResponse createDiary(CreateDiaryRequest request) {
        CreateDiaryResponse response = new CreateDiaryResponse();
        Optional<Diary> foundDiary = repository.findByEmail(request.getEmail());
            if(foundDiary.isPresent()){ throw new RuntimeException("Title already exist");}
            else {
                Diary diary = Diary.builder()
                        .name(request.getName())
                        .password(request.getPassword())
                        .email(request.getEmail())
                        .creationDate(LocalDateTime.now())
                        .build();
                Diary savedDiary = repository.save(diary);
                id = savedDiary.getId();
                BeanUtils.copyProperties(savedDiary, response);
            }
        return response;
        }
        @Override
        public CreateDiaryResponse login(CreateDiaryRequest request) {
        CreateDiaryResponse response = new CreateDiaryResponse();
        Optional<Diary> foundDiary = repository.findByEmailAndPassword(request.getEmail(), request.getPassword());
        if (foundDiary.isPresent()){
            Diary diary = foundDiary.get();
            BeanUtils.copyProperties(diary, response);
        }else throw new RuntimeException("Incorrect Details");
        return response;
    }
    @Override
    public CreateDiaryResponse findByEmail(CreateDiaryRequest request) {
            CreateDiaryResponse response = new CreateDiaryResponse();
            Optional<Diary> diary = repository.findByEmail(request.getEmail());
            diary.ifPresent(value -> BeanUtils.copyProperties(value, response));
            return response;
    }

    @Override
    public void deleteByEmailAndPassword(CreateDiaryRequest createDiaryRequest) {
        Optional<Diary> foundDiary = repository.findByEmailAndPassword(createDiaryRequest.getEmail(), createDiaryRequest.getPassword());
        foundDiary.ifPresent(repository::delete);
    }
}
