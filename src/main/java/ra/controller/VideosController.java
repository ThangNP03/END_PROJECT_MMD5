package ra.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.dto.requets.ResponseMessage;
import ra.entity.Videos;
import ra.service.IVideoService;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v4/videos")
public class VideosController {
    @Autowired
    private IVideoService videoService;
    @GetMapping()
    public List<Videos> findAll(){
        List<Videos> list_video = videoService.findAll();
        return list_video;
    }
    @PostMapping("/create")
    public ResponseEntity<?> createChannel(@RequestBody Videos videos) {
        videos.setCreate_at(new Date());
        videoService.save(videos);
        return ResponseEntity.ok(new ResponseMessage("Thêm mới videos thành công "));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateChannel(@PathVariable Long id, @RequestBody Videos videos) {
        Videos update = videoService.findById(id);
        if (update != null) {
            videos.setVideo_id(update.getVideo_id());
            videos.setCreate_at(new Date());
            videoService.save(videos);
            return ResponseEntity.ok(new ResponseMessage("Chỉnh sửa videos thành công ") );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tim thấy videos muốn chỉnh sửa !!!!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        videoService.deleteById(id);
        return ResponseEntity.ok(new ResponseMessage("xóa thành công"));
    }
    @PutMapping("/increase-likes/{id}")
    public ResponseEntity<?> increase_likes (@PathVariable Long id, @RequestBody Videos videos) {
        Videos update = videoService.findById(id);
        if (update != null) {
            videos.setLike(update.getLike() + 1);
            videoService.save(videos);
            return ResponseEntity.ok(new ResponseMessage("Bạn đã thích video"  ) );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tiìm thấy video !!!!");
    }
}
