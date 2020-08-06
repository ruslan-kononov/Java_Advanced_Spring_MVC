package spring.web.app01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.web.app01.dao.ParticipantRepository;
import spring.web.app01.domain.Participant;

import java.util.List;


@Service
public class ParticipantService{
    @Autowired
    private ParticipantRepository repository;

    public void save(Participant participant) {
        repository.save(participant);
    }

    public List<Participant> readAll(){
        return repository.findAll();
    }

    public Participant readById(int id){
        return repository.readById(id);
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }


}
