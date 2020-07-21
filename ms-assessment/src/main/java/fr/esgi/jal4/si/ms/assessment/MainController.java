package fr.esgi.jal4.si.ms.assessment;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/text")
public class MainController {
    public Integer last_length = null;
    
    @GetMapping("")
    public String helloWorld() {
        return "HelloWorld";
    }
            
    @PostMapping("/concat")
    public ResponseEntity<String> concatString(@RequestBody TwoString t){
        if(t.str1 == null || t.str2 == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        String result = t.str1 + " " + t.str2;
        last_length = result.length();
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/last_length")
    public ResponseEntity<Integer> returnLastLength(){
        if(last_length == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(last_length);
    }
}
