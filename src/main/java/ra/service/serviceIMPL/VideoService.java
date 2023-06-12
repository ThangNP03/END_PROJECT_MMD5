package ra.service.serviceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.entity.Videos;
import ra.repository.IVideoRepository;
import ra.service.IVideoService;

import java.util.List;
@Service
public class VideoService implements IVideoService {
    @Autowired
    private IVideoRepository videoRepository;

    @Override
    public List<Videos> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public boolean save(Videos video) {
         videoRepository.save(video);
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
         videoRepository.deleteById(id);
        return true;
    }

    @Override
    public Videos findById(Long id) {
        return videoRepository.findById(id).get();
    }
}
