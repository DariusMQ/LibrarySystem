package com.example.librarysystem.ejb;

import com.example.librarysystem.common.UserDto;
import com.example.librarysystem.entities.Book;
import com.example.librarysystem.entities.Borrowed_Book;
import com.example.librarysystem.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UsersBean {

    public static final Logger LOG = Logger.getLogger(UsersBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<UserDto> findAllUsers(){
        LOG.info("findAllUsers");

        try{
            TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM User u",User.class);

            List<User> users = typedQuery.getResultList();
            return copyUsersToDto(users);
        }

        catch (Exception ex){
            throw new EJBException(ex);
        }

    }

    public List<UserDto> copyUsersToDto(List<User> users){
        List<UserDto> UserDtos = new ArrayList<>();

        for(User user: users){

            List<Long> ids = new ArrayList<>();

            for (Borrowed_Book bbook : user.getBorrowedBooks()) {
                ids.add(bbook.getId());
            }

            UserDto userDto = new UserDto(user.getId(),user.getUsername(),user.getPassword(),user.getEmail(),ids);

            UserDtos.add(userDto);
        }

        return UserDtos;
    }
}
