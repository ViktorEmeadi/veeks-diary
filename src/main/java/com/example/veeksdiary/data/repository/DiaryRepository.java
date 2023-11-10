package com.example.veeksdiary.data.repository;


import com.example.veeksdiary.data.model.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {

//    Optional<Diary> findByNameAndEmail(String name, String email);

    Optional<Diary> findByName(String name);

//    Optional<Diary> findByEmail(String email);
    Optional<Diary> findDiaryByName(String name);

    Optional<Diary> findByEmailAndPassword(String name, String password);

    Optional<Diary> findByEmail(String email);
}
