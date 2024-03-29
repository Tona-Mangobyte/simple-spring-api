package com.mb.article.services.impl;

import com.mb.article.api.request.RequestPaging;
import com.mb.article.api.request.UserRequest;
import com.mb.article.api.response.ItemsPagination;
import com.mb.article.api.response.PagingResponse;
import com.mb.article.models.User;
import com.mb.article.repositories.UserRepository;
import com.mb.article.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public ItemsPagination<User> findPaging(RequestPaging paging) {
        Page<User> userPage = this.userRepository.findAll(paging);
        return new ItemsPagination<>(userPage.stream().toList()
                , new PagingResponse(userPage.getNumber(), paging.getPageSize()
                , userPage.getTotalPages(), userPage.hasNext(), userPage.hasPrevious()));
    }

    @Override
    public User findOne(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Could not find user"));
    }

    @Override
    public User create(UserRequest userRequest) {
        User user = new User();
        user.setId(userRequest.id());
        user.setUsername(userRequest.username());
        user.setPassword(userRequest.password());
        user.setRole(userRequest.role());
        return this.userRepository.save(user);
    }
}
