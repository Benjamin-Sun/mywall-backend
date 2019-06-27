package benjamin_sun.mywallbackend.repository;

import benjamin_sun.mywallbackend.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, String> {

    @Query(value = "select new Picture(p.picId, p.picName, p.picCate, p.viewTimes, p.userId, p.uploadTime, p.favoTimes, p.imagePath) " +
            "from Picture p order by p.uploadTime")
    List<Picture> selectAllByLatest();

    @Query(value = "select new Picture(p.picId, p.picName, p.picCate, p.viewTimes, p.userId, p.uploadTime, p.favoTimes, p.imagePath) " +
            "from Picture p")
    List<Picture> selectAllByRandom();

    @Query(value = "select new Picture(p.picId, p.picName, p.picCate, p.viewTimes, p.userId, p.uploadTime, p.favoTimes, p.imagePath) " +
            "from Picture p order by p.favoTimes desc")
    List<Picture> selectAllByFavorTimes();
}
