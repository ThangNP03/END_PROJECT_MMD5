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
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateChannel(@PathVariable Long id, @RequestBody Channel channel) {
        Channel update = chanelService.findById(id);
        if (update != null) {
            channel.setChannel_id(update.getChannel_id());
            channel.setCreate_at(new Date());
            chanelService.save(channel);
            return ResponseEntity.ok(new ResponseMessage("Chỉnh sửa thông  tin thành công") );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tim thấy kênh muốn chỉnh sửa !!!!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        chanelService.deleteById(id);
        return ResponseEntity.ok(new ResponseMessage("xóa thành công"));
    }
}

