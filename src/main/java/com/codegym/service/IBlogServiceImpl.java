package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class IBlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public void save(Blog blog) {
        if(blog.getId() != null){
            blogRepository.saveAndFlush(blog);
        } else {
            blogRepository.save(blog);
        }
    }

    @Override
    public void remove(Blog blog) {
        blogRepository.delete(blog);
    }
}
