package spring.web.app01.dao;

import org.springframework.stereotype.Repository;
import spring.web.app01.domain.Level;
import spring.web.app01.domain.Participant;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ParticipantRepository {
    private List<Participant> participants = new ArrayList<>();

    @PostConstruct
    public void init(){

        Participant part1 = new Participant();
        part1.setId(1);
        part1.setName("Alex Sikorskii");
        part1.setEmail("Sikorskii@gmail.com");
        part1.setLevel(Level.L2);
        part1.setPrimarySkill("analytical");

        Participant part2 = new Participant();
        part2.setId(2);
        part2.setName("Maria Curie");
        part2.setEmail("Curie@gmail.com");
        part2.setLevel(Level.L4);
        part2.setPrimarySkill("resilient");

        Participant part3 = new Participant();
        part3.setId(3);
        part3.setName("Robert Oppenheimer");
        part3.setEmail("Oppenheimer@gmail.com");
        part3.setLevel(Level.L5);
        part3.setPrimarySkill("industrious");

        participants.add(part1);
        participants.add(part2);
        participants.add(part3);
    }

    public void save(Participant participant) throws Exception {
        Boolean valueExists = participants.stream().map(p->p.getId()==participant.getId()).anyMatch(d->d);
        if(valueExists){
            throw new Exception("There is already an entry with such id!");
        }
        participants.add(participant);
    }

    public List<Participant> readAll(){
        return participants;
    }

    public Participant readById(int id){
       return participants.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
    }

    public void updateById(int id, Participant participant){
        Participant updatedParticipant = readById(id);
        int indexOfParticip = participants.indexOf(updatedParticipant);
        participants.set(indexOfParticip,participant);
    }

    public void deleteById(int id){
        Participant participant = readById(id);
        participants.remove(participant);
    }
}
