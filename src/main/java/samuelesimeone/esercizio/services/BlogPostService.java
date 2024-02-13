package samuelesimeone.esercizio.services;


import org.springframework.stereotype.Service;
import samuelesimeone.esercizio.entities.BlogPost;
import samuelesimeone.esercizio.exceptions.NotFoundException;

import java.util.*;

@Service
public class BlogPostService {

    Random rdm = new Random();
    List<BlogPost> blogPosts = new ArrayList<>();

    public List<BlogPost> getAll(){
        return  this.blogPosts;
    }

    public BlogPost save(BlogPost post){
        post.setId(rdm.nextLong(1, 100000));
        post.setCover("https://picsum.photos/" + rdm.nextInt(100, 200) + "/" + rdm.nextInt(200, 300));
        post.setTempoDiLettura(rdm.nextDouble(1.0, 60.0));
        this.blogPosts.add(post);
        return post;
    }

    public BlogPost findById(long id){
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPosts) {
            if (blogPost.getId() == id) {
                found = blogPost;
            }
        }
        if (found == null) {
            throw new NotFoundException(id);
        }else {
            return found;
        }
    }

    public BlogPost update(long id, BlogPost postUp){
        postUp.setCover("https://picsum.photos/" + rdm.nextInt(100, 200) + "/" + rdm.nextInt(200, 300));
        postUp.setTempoDiLettura(rdm.nextDouble(1.0, 60.0));
        BlogPost found = findById(id);
        found.setCategoria(postUp.getCategoria());
        found.setContenuto(postUp.getContenuto());
        found.setTitolo(postUp.getTitolo());
        found.setCover(postUp.getCover());
        found.setTempoDiLettura(postUp.getTempoDiLettura());
        return found;
    }

    public void deletePost(long id){
        Iterator<BlogPost> postIterator = this.blogPosts.iterator();
        while (postIterator.hasNext()){
            BlogPost current = postIterator.next();
            if (current.getId() == id) {
                postIterator.remove();
            }
        }
    }
}
