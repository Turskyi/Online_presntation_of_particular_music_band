package io.github.turskyi.data.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.github.turskyi.data.database.SongDao;
import io.github.turskyi.domain.entities.pojo.Song;
import io.github.turskyi.domain.repository.SongsRepository;
import io.reactivex.Single;

public class SongsRepositoryImpl implements SongsRepository {
    private final SongDao dao;

    @Inject
    SongsRepositoryImpl(SongDao dao){
        this.dao = dao;
    }


    @Override
    public Single<List<Song>> getSongsFromAlbum(String album) {
        return dao.getAlbumSongs(album).map((entities)-> {
            List<Song> songs = new ArrayList<>();
            for (int i = 0; i < entities.size(); i++) {
                Song song = entities.get(i).mapToDomain();
                songs.add(song);
            }
            return songs;
        });
    }
}
