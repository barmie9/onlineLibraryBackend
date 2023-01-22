package com.bartekOnlineLibrary.onlineLibrary.service;

import com.bartekOnlineLibrary.onlineLibrary.model.UserLibrary;
import com.bartekOnlineLibrary.onlineLibrary.repository.UserLibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserLibraryService {

    private final UserLibraryRepository userLibraryRepository;

    public List<UserLibrary> getUserLibrary(){
        return userLibraryRepository.findAll();
    }
}
