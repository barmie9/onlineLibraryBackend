package com.bartekOnlineLibrary.onlineLibrary.service;

import com.bartekOnlineLibrary.onlineLibrary.controller.ChangePasswordForm;
import com.bartekOnlineLibrary.onlineLibrary.controller.LoginData;
import com.bartekOnlineLibrary.onlineLibrary.controller.RegisterData;
import com.bartekOnlineLibrary.onlineLibrary.controller.Token;
import com.bartekOnlineLibrary.onlineLibrary.dto.ProfileDto2;
import com.bartekOnlineLibrary.onlineLibrary.model.ShoppingCart;
import com.bartekOnlineLibrary.onlineLibrary.model.Transaction;
import com.bartekOnlineLibrary.onlineLibrary.model.UserLibrary;
import com.bartekOnlineLibrary.onlineLibrary.repository.ShoppingCartRepository;
import com.bartekOnlineLibrary.onlineLibrary.repository.TransactionRepository;
import com.bartekOnlineLibrary.onlineLibrary.repository.UserLibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserLibraryService {

    private final UserLibraryRepository userLibraryRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final TransactionRepository transactionRepository;

    public List<UserLibrary> getUserLibrary(){
        return userLibraryRepository.findAll();
    }

    public UserLibrary getUserByUsernameAndPassword(String username, String password){
        return userLibraryRepository.findByUsernameAndPassword(username,password);
    }

    public boolean login (LoginData loginData){
        UserLibrary userLibrary = userLibraryRepository.findByUsernameAndPassword(loginData.getLogin(),loginData.getPass());

        if(userLibrary == null) return false; // Nieudane logowanie
        else return true; // Udane logowanie
    }

    public String register(RegisterData registerData){

        if(userLibraryRepository.findByUsername(registerData.getUsername()) == null){ // Sprawdzenie czy uzytkownik istnieje
            UserLibrary userLibrary = new UserLibrary();
            userLibrary.setName(registerData.getName());
            userLibrary.setEmail(registerData.getEmail());
            userLibrary.setPassword(registerData.getPassword());
            userLibrary.setLastName(registerData.getSurname());
            userLibrary.setUsername(registerData.getUsername());
            userLibrary.setDateOfBirth(LocalDate.now());
            userLibrary.setPicture(null);
            UserLibrary response = userLibraryRepository.save(userLibrary);

            // Tworzenie koszyka dla użytkownika
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setUser(response);
            shoppingCart.setTransaction(null);
            ShoppingCart cartResponse = shoppingCartRepository.save(shoppingCart);
            if(response != null && cartResponse != null){
                LoginData loginData = new LoginData();
                loginData.setLogin(registerData.getUsername());
                loginData.setPass(registerData.getPassword());
                String token = Token.setToken(loginData);
                return token;
            }
            else{
                return null;
            }
        }
        else return null;
    }

    public boolean pay(LoginData loginData){
        UserLibrary user = userLibraryRepository.findByUsernameAndPassword(loginData.getLogin(), loginData.getPass());
        ShoppingCart shoppingCart = shoppingCartRepository.findByUserIdAndTransactionId(user.getId(),null);

        //Tworzenie nowej transakcji
        Transaction newTransaction = new Transaction();
        newTransaction.setDateTransaction(LocalDate.now());
        Transaction transaction = transactionRepository.save(newTransaction);

        // Zminana poprzedniego koszyka użytkownika. Zminana transakcji na id nowo powstałej tranzakcji
        shoppingCartRepository.updateTransactionById(transaction.getId(), user.getId());

        //Tworzenie nowego koszyka
        ShoppingCart newShoppingCart = new ShoppingCart();
        newShoppingCart.setTransaction(null);
        newShoppingCart.setUser(user);
        shoppingCartRepository.save(newShoppingCart);

        return true;

    }

    public boolean updateProfile(ProfileDto2 profileDto2,LoginData loginData) {
        UserLibrary user = userLibraryRepository.findByUsernameAndPassword(loginData.getLogin(), loginData.getPass());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDate localDate = LocalDate.parse(profileDto2.getDob(), formatter);

        userLibraryRepository.updateUser(profileDto2.getEmail(),user.getUsername(),user.getPassword(),profileDto2.getName(),profileDto2.getSurname(),localDate, user.getPicture(), user.getId());
        return true;
    }

    public boolean changePassword(ChangePasswordForm changePasswordForm, LoginData loginData){
        UserLibrary user = userLibraryRepository.findByUsernameAndPassword(loginData.getLogin(), loginData.getPass());
        userLibraryRepository.updatePassword(changePasswordForm.getNewPassword(),user.getId());
        return true;
    }

    public String savePhoto(MultipartFile file, LoginData loginData){
        Long idUser = userLibraryRepository.findByUsernameAndPassword(loginData.getLogin(),loginData.getPass()).getId();

        String fileName = "profile_5.jpg";
//        String fileName = file.getOriginalFilename();
//        Path filePath = photosDirectory.resolve(fileName);
        Path path = Paths.get("zdj/");
        Path newPath = path.resolve(fileName);
        try {
            file.transferTo(newPath);
        } catch (IOException e) {
            throw new RuntimeException("Błąd podczas zapisywania zdjęcia " + fileName, e);
        }
        return fileName;
    }

    //Moze sie przydac
//    private  MultipartFile convertPngToJpg(MultipartFile file) throws IOException {
//        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
//        return new ByteArrayMultipartFile(byteArrayOutputStream.toByteArray(), "image/jpeg", "convertedImage.jpg");
//    }

}
