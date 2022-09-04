package com.mb.article.api.controllers;

import com.mb.article.api.request.RequestPaging;
import com.mb.article.api.request.UserRequest;
import com.mb.article.api.response.ListResponse;
import com.mb.article.api.response.ObjectResponse;
import com.mb.article.models.User;
import com.mb.article.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController extends BaseController<User> {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ListResponse getAll(
            @RequestParam(defaultValue = "1", required = false) Integer page,
            @RequestParam(defaultValue = "30", required = false) Integer limit) {
        return this.listResponse("request success",
                this.userService.findPaging(RequestPaging.of(page - 1, limit)));
    }

    @GetMapping("{id}")
    public ObjectResponse<User> getById(@PathVariable("id") Long id) {
        return this.response("request success", this.userService.findOne(id));
    }

    @PostMapping
    public ObjectResponse<User> create(@RequestBody UserRequest userRequest) {
        return this.response("request success", this.userService.create(userRequest));
    }
}
