package com.mb.article.api.controllers;

import com.mb.article.api.request.RequestPaging;
import com.mb.article.api.request.UserRequest;
import com.mb.article.api.response.ListResponse;
import com.mb.article.api.response.ObjectResponse;
import com.mb.article.models.User;
import com.mb.article.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ListResponse getAll(
            @RequestParam(defaultValue = "1", required = false) Integer page,
            @RequestParam(defaultValue = "30", required = false) Integer limit) {
        return this.listResponse("Request is success",
                this.userService.findPaging(RequestPaging.of(page, limit)));
    }

    @GetMapping("{id}")
    public ObjectResponse<User> getById(@PathVariable("id") Long id) {
        return this.response("Request is success", this.userService.findOne(id));
    }

    @PostMapping
    public ObjectResponse<User> create(@Valid @RequestBody UserRequest userRequest) {
        return this.response("Request is success", this.userService.create(userRequest));
    }
}
