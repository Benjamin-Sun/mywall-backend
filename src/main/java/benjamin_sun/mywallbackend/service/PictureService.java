package benjamin_sun.mywallbackend.service;

import benjamin_sun.mywallbackend.entity.Picture;

import java.util.List;

public interface PictureService {

    List<Picture> selectAllByLatest();
    List<Picture> selectAllByRandom();
    List<Picture> selectAllByFavorTimes();

    Picture getOne(String id);

    Picture insert(Picture picture);

    int deleteById(String id);
}
