package com.service;

import com.model.Music;
import com.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService implements IMusicService {
    @Autowired
    MusicRepository musicRepository;
    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public List<Music> findByName(String name) {
        return null;
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void delete(Music music) {
        musicRepository.delete(music);
    }

    @Override
    public Music findById(Long id) {
        return musicRepository.findById(id).orElse(null);
    }
}
