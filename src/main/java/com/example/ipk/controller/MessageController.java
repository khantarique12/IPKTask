package com.example.ipk.controller;

import com.example.ipk.dto.TextMessageDto;
import com.example.ipk.service.TextMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/message")
public class MessageController {

    @Autowired
    private TextMessageService textMessageService;

    @PostMapping("/create")
    public ResponseEntity<String> receiveTextMessage (@RequestBody TextMessageDto textMessageDto){
        System.out.println("IN ReceiveTextMessage DTO ："+textMessageDto.toString());
        Boolean result = textMessageService.saveTextMessage(textMessageDto);

        return new ResponseEntity<>(result ? "Text Message Saved":"Couldn't Save Text Message", result ? HttpStatus.CREATED:HttpStatus.BAD_REQUEST);
    }

    @GetMapping("getByContact/{contact}")
    public ResponseEntity<List<TextMessageDto>> getByContact(@PathVariable String contact){
        System.out.println("In GetByContact contact is "+contact);
        List<TextMessageDto> result = textMessageService.getByContact(contact);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<TextMessageDto>> getAll(){
        System.out.println("In getAll ");
        List<TextMessageDto> result = textMessageService.getAll();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}