package ra.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.dto.requets.ResponseMessage;
import ra.entity.Channel;
import ra.service.IChanelService;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v4/channel")

public class ChannelController {
    private IChanelService chanelService;
    @GetMapping
    public List<Channel> findAll(){
        List<Channel> list_chanel = chanelService.findAll();
        return list_chanel;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createChannel(@RequestBody Channel channel) {
        channel.setCreate_at(new Date());
        chanelService.save(channel);
        return ResponseEntity.ok(new ResponseMessage("Tạo kênh mới thành công "));
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateChannel(@RequestBody Channel c) {
        Channel update = chanelService.findById(c.getChannel_id());
        if (update != null) {
            boolean savedChannel = chanelService.save(c);
            return ResponseEntity.ok(savedChannel);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tim thấy kênh muốn chỉnh sửa !!!!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        chanelService.deleteById(id);
        return ResponseEntity.ok(new ResponseMessage("xóa thành công"));
    }


}

