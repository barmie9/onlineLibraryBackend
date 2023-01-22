package com.bartekOnlineLibrary.onlineLibrary.controller;

import com.bartekOnlineLibrary.onlineLibrary.model.UserLibrary;
import com.bartekOnlineLibrary.onlineLibrary.service.UserLibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserLibraryController {

    private final UserLibraryService userLibraryService;

    @GetMapping("/usersLibrary")
    public List<UserLibrary> getUserLibrary(){
        return userLibraryService.getUserLibrary();
    }
}
