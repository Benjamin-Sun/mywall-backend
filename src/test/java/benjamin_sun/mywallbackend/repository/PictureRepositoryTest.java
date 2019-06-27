package benjamin_sun.mywallbackend.repository;

import benjamin_sun.mywallbackend.MywallBackendApplicationTests;
import benjamin_sun.mywallbackend.entity.Picture;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PictureRepositoryTest extends MywallBackendApplicationTests {

    @Autowired
    private PictureRepository pictureRepository;

    @Test
    public void insert() {
//        Picture picture = new Picture("hello", 1, "4028096b6b696984016b6969993f0000");
//        pictureRepository.save(picture);
    }

    @Test
    public void selectAllByLatest(){
        List<Picture> list = pictureRepository.selectAllByLatest();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void selectAllByRandom(){
        List<Picture> list = pictureRepository.selectAllByRandom();
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    @Test
    public void selectAllByFavorTimes(){
        List<Picture> list = pictureRepository.selectAllByFavorTimes();
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}