package com.example.librarysystem.ejb;

import com.example.librarysystem.common.UserDto;
import com.example.librarysystem.entities.*;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UsersBean {

    @Inject
    PasswordBean passwordBean;

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

            List<Long> rids = new ArrayList<>();

            for (Returned_Book rbook : user.getReturnedBooks()){
                rids.add(rbook.getId());
            }

            UserDto userDto = new UserDto(user.getId(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getEmail(),
                    ids,
                    rids);

            UserDtos.add(userDto);
        }

        return UserDtos;
    }

    public void createUser(String username, String email, String password, Collection<String> groups) {
        LOG.info("createUser");
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(passwordBean.convertToSha256(password));
        entityManager.persist(newUser);
        assignGroupsToUser(username, groups);
    }
    private void assignGroupsToUser(String username, Collection<String> groups) {
        LOG.info("assignGroupsToUser");
        for (String group : groups) {
            UserGroup userGroup = new UserGroup();
            userGroup.setUsername(username);
            userGroup.setUsergroup(group);
            entityManager.persist(userGroup);
        }
    }

}
