package com.wang.languages.project.repositories;

import com.wang.languages.project.models.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
    public List<Language> findAll();
//    public List<Book> findByDescriptionContaining(String search);
//    public Long countByTitleContaining(String search);
//    public Long deleteByTitleStartingWith(String search);
}
