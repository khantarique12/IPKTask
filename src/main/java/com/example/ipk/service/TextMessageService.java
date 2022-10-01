package com.example.ipk.service;

import com.example.ipk.dto.TextMessageDto;
import com.example.ipk.repository.TextMessage;
import com.example.ipk.repository.TextMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TextMessageService {

    @Autowired
    TextMessageRepository textMessageRepository;

    public boolean saveTextMessage(TextMessageDto dto){
        try{
            TextMessage textMessage = dtoToEntity(dto);
            textMessageRepository.save(textMessage);
            return true;
        }catch (Exception e){
            System.out.println("Exception "+e);
            return false;
        }
    }

    public List<TextMessageDto> getByContact(String contact)
    {
        List<TextMessage> textMessages = textMessageRepository.findByContact(contact);
        return entityToDtos(textMessages);
    }

    public List<TextMessageDto> getAll()
    {
        List<TextMessage> textMessages = (List<TextMessage>) textMessageRepository.findAll();
        return entityToDtos(textMessages);
    }

    public TextMessage dtoToEntity(TextMessageDto dto)
    {
        TextMessage textMessage = new TextMessage();
        textMessage.setContact(dto.getContact());
        textMessage.setTextMessage(dto.getText());

        return textMessage;
    }

    public List<TextMessageDto> entityToDtos(List<TextMessage> textMessages){
        List<TextMessageDto> textMessageDtos = new ArrayList<>();
        for (TextMessage textMessage:textMessages) {
            TextMessageDto textMessageDto = new TextMessageDto();
            textMessageDto.setText(textMessage.getTextMessage());
            textMessageDto.setContact(textMessage.getContact());
            textMessageDto.setId(textMessageDto.getId());
            textMessageDtos.add(textMessageDto);
        }
        return textMessageDtos;
    }

}
