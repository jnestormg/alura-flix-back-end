package com.aluraflix.alura_flix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aluraflix.alura_flix.entities.Videos;
import com.aluraflix.alura_flix.repositories.VideosRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api")
public class VideosController {

    @Autowired
    private VideosRepository repository;

    @GetMapping("/videos")
    public List<Videos> mostrarVideos() {
        return repository.findAll();
    }

    @GetMapping("/videos/{id}")
    public Videos mostrarPorId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping("/videos")
    public Videos guardarVideo(@RequestBody Videos video) {
        return repository.save(video);
    }

    @DeleteMapping("/videos/{id}")
    public void borrarVideo(@PathVariable Long id){
        Videos video=repository.findById(id).orElseThrow();
        repository.delete(video);
    }

    @PutMapping("/videos/{id}")
    public Videos actualizarVideo(@RequestBody Videos video, @PathVariable Long id){
        Videos vid= repository.findById(id).orElseThrow();
        vid.setTitulo(video.getTitulo());
        vid.setCategoria(video.getCategoria());
        vid.setImagen(video.getImagen());
        vid.setVideo(video.getVideo());
        vid.setDescripcion(video.getDescripcion());
        return repository.save(vid);
    }
}
