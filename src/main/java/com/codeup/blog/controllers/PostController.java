package com.codeup.blog.controllers;

import com.codeup.blog.model.Post;
import com.codeup.blog.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;


@Controller
public class PostController {

//    this is the service placeholder that will be final that means it will not be changed
    private final PostSvc postSvc;

//    dependency injection everything ties together Services + controller / class
@Autowired
public PostController(PostSvc postSvc) {
    this.postSvc = postSvc;
}

    @GetMapping("/posts")
    public  String showAll(Model model) {


        ArrayList<Post> posts = new ArrayList<>();

        postSvc.findall();
        model.addAttribute("posts",postSvc.findall());

        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable int id, Model model) {

     postSvc.findOne(id );
     model.addAttribute("show",postSvc.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create/")
    public String showCreateForm() {



        return "wtf happened.....";
    }


    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreate(String create, Model model) {
    postSvc.createPost();
    model.addAttribute("create",create);
        return "";
    }
}