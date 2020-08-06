package spring.web.app01.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.web.app01.domain.Participant;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    List<Participant> findAll();
    Participant readById(int id);

//    private List<Participant> participants = new ArrayList<>();

//    public void save(Participant participant) throws Exception {
//        Boolean valueExists = participants.stream().map(p->p.getId()==participant.getId()).anyMatch(d->d);
//        if(valueExists){
//            throw new Exception("There is already an entry with such id!");
//        }
//        participants.add(participant);
//    }
//
//    public List<Participant> readAll(){
//        return participants;
//    }
//
//    public Participant readById(int id){
//       return participants.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
//    }
//
//    public void updateById(int id, Participant participant){
//        Participant updatedParticipant = readById(id);
//        int indexOfParticip = participants.indexOf(updatedParticipant);
//        participants.set(indexOfParticip,participant);
//    }
//
//    public void deleteById(int id){
//        Participant participant = readById(id);
//        participants.remove(participant);
//    }
}
