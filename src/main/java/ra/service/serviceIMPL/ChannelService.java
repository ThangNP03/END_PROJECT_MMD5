package ra.service.serviceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.entity.Channel;
import ra.repository.IChanelRepository;
import ra.service.IChanelService;

import java.util.List;
@Service
public class ChannelService implements IChanelService {
    @Autowired
    private IChanelRepository chanelRepository;
    @Override
    public List<Channel> findAll() {
        return chanelRepository.findAll();
    }

    @Override
    public boolean save(Channel channel) {
        chanelRepository.save(channel);
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        chanelRepository.deleteById(id);
        return true;
    }

    @Override
    public Channel findById(Long id) {
        return chanelRepository.findById(id).get();
    }
}
