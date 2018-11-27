package com.wang.languages.project.services;
import com.wang.languages.project.models.Language;
import com.wang.languages.project.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LanguageService {
    @Autowired
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> findAll() {
        List<Language> languages = languageRepository.findAll();
        return languages;
    }

    public Language createLanguage(Language l) {
        return languageRepository.save(l);
    }

    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }

    public Language updateLanguage(Language language, Long id) {
        Language languageToUpdate = findLanguage(id);
        languageToUpdate.setName(language.getName());
        languageToUpdate.setCreator(language.getCreator());
        languageToUpdate.setCurrentVersion(language.getCurrentVersion());
        languageRepository.save(languageToUpdate);
        return languageToUpdate;
    }

    public void deleteLanguage(Long id) {
        languageRepository.deleteById(id);
    }
}