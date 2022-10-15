package com.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name = "musics")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String artist;
    private String type;
    private String urlSong;
    @Transient
    private MultipartFile fileMusic;
    private String publicId;

    public Music() {
    }

    public Music(Long id, String name, String artist, String type, String urlSong, MultipartFile fileMusic, String publicId) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.type = type;
        this.urlSong = urlSong;
        this.fileMusic = fileMusic;
        this.publicId = publicId;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public MultipartFile getFileMusic() {
        return fileMusic;
    }


    public void setFileMusic(MultipartFile fileMusic) {
        this.fileMusic = fileMusic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrlSong() {
        return urlSong;
    }

    public void setUrlSong(String urlSong) {
        this.urlSong = urlSong;
    }
}
