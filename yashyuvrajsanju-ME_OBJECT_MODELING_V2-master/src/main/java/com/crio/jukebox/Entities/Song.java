package com.crio.jukebox.Entities;

import java.util.List;

public class Song {
    private String id;
    public String getId() {
        return id;
    }
    private String name;
    public String getName() {
        return name;
    }
    private String album;
    public String getAlbum() {
        return album;
    }
    private List<String> artists;

    public List<String> getArtists() {
        return artists;
    }
    public Song(Song song)
    {
        this(song.id,song.name,song.album,song.artists);
    }
    public Song(String name, String album,  List<String> artists) {
        this.name = name;
        this.album = album;
        this.artists = artists;
    }
    public Song(String id, String name, String album, List<String> artists) {
        this(name,album,artists);
        this.id = id;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Song other = (Song) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Song [album=" + album + ", artists=" + artists + ", id=" + id + ", name=" + name
                + "]";
    }
   


}
