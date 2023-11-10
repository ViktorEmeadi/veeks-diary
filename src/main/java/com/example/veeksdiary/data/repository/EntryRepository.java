package com.example.veeksdiary.data.repository;


import com.example.veeksdiary.data.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
    Optional<Entry> findEntryByEntryTitle(String title);
}
