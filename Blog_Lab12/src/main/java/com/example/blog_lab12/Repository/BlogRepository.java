package com.example.blog_lab12.Repository;

import com.example.blog_lab12.Model.Blog;
import com.example.blog_lab12.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    Blog findBlogById(Integer id);

    List<Blog> findBlogsByUser(User user);

    Blog findBlogByTitle(String title);
}
