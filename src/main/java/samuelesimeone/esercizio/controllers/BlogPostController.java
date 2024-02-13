package samuelesimeone.esercizio.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import samuelesimeone.esercizio.entities.BlogPost;
import samuelesimeone.esercizio.services.BlogPostService;

import java.util.List;

@RestController
@RequestMapping("/blogpost")
public class BlogPostController {

    @Autowired
    BlogPostService blogPostService;

    @GetMapping
    public List<BlogPost> getAll(){
        return this.blogPostService.getAll();
    }

    @GetMapping("/{id}")
    public BlogPost getBlogPostById(@PathVariable long id){
        return this.blogPostService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost save(@RequestBody BlogPost post){
        return this.blogPostService.save(post);
    }

    @PutMapping("/{id}")
    public BlogPost update(@PathVariable long id, @RequestBody BlogPost post){
        return this.blogPostService.update(id,post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        this.blogPostService.deletePost(id);
    }


}
