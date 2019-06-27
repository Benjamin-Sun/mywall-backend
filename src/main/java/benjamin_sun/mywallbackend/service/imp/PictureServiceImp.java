package benjamin_sun.mywallbackend.service.imp;

import benjamin_sun.mywallbackend.entity.Picture;
import benjamin_sun.mywallbackend.repository.PictureRepository;
import benjamin_sun.mywallbackend.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImp implements PictureService {

    @Autowired
    PictureRepository pictureRepository;

    @Override
    public List<Picture> selectAllByLatest() {
        return pictureRepository.findAll();
    }

    @Override
    public List<Picture> selectAllByRandom() {
        return pictureRepository.findAll();
    }

    @Override
    public List<Picture> selectAllByFavorTimes() {
        return pictureRepository.findAll();
    }

    @Override
    public Picture getOne(String id) {
        return pictureRepository.getOne(id);
    }

    @Override
    public int insert(Picture picture) {
        try {
            if(picture.getImagePath() == null){
                return 0;
            }
            pictureRepository.save(picture);
            return 1;
        } catch (Exception e){
            return 0;
        }
    }

    @Override
    public int deleteById(String id) {
        try {
            pictureRepository.deleteById(id);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

}
