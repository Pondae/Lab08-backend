package se331.lab.rest.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class OrganizerDaoImp1 implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(111L)
                .name("AAA")
                .address("A")
                .build());
        organizerList.add(Organizer.builder()
                .id(222L)
                .name("BBB")
                .address("B")
                .build());
        organizerList.add(Organizer.builder()
                .id(333L)
                .name("CCC")
                .address("C")
                .build());
        organizerList.add(Organizer.builder()
                .id(444L)
                .name("DDD")
                .address("D")
                .build());
        organizerList.add(Organizer.builder()
                .id(555L)
                .name("EEE")
                .address("E")
                .build());
        organizerList.add(Organizer.builder()
                .id(666L)
                .name("FFF")
                .address("F")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return new PageImpl<Organizer>(organizerList.subList(firstIndex,firstIndex+pageSize));
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(organizer -> organizer.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer) {
        organizer.setId(organizerList.get(organizerList.size() -1).getId()+1);
        organizerList.add(organizer);
        return organizer;
    }
}