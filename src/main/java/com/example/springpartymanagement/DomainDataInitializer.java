package com.example.springpartymanagement;

import com.example.springpartymanagement.entity.*;
import com.example.springpartymanagement.repository.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Component
public class DomainDataInitializer implements ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = false;
    private final GuestRepository guestRepository;
    private final WeddingRepository weddingRepository;
    private final RoomRepository roomRepository;
    private final AppUserRepository appUserRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public DomainDataInitializer(GuestRepository guestRepository,
                                 WeddingRepository weddingRepository,
                                 RoomRepository roomRepository,
                                 AppUserRepository appUserRepository,
                                 UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.guestRepository = guestRepository;
        this.weddingRepository = weddingRepository;
        this.roomRepository = roomRepository;
        this.appUserRepository = appUserRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup) {return;}

        guestRepository.save(
                new Guest(
                        "cin859",
                        "Aze",
                        "Las",
                        GuestStatus.GROOM_GUEST
                )
        );

        guestRepository.save(
                new Guest(
                        "cin9856",
                        "Uol" ,
                        "Pfu",
                        GuestStatus.BRIDE_GUEST
                )
        );

        for (int i = 0; i < 5; i++) {
            guestRepository.save(
                    new Guest(
                            "cin" + i,
                            "firstName" + i,
                            "lastName" + i,
                            GuestStatus.WITNESS
                    )
            );
        }

        Room room1 = new Room("room1", "Rabat", "Address 1", 10);
        Room room2 = new Room("room2", "Casablanca", "Address 2", 20);
        roomRepository.save(room1);
        roomRepository.save(room2);

        Wedding wedding1 = new Wedding(
                LocalDate.of(2023, 1, 8),
                room1
        );
        Wedding wedding2 = new Wedding(
                LocalDate.of(2023, 6, 8),
                room2
        );

        weddingRepository.save(wedding1);
        weddingRepository.save(wedding2);

        UserRole roleUSER = new UserRole("USER");
        UserRole roleADMIN = new UserRole("ADMIN");

        userRoleRepository.save(roleUSER);
        userRoleRepository.save(roleADMIN);

        for (int i = 0; i < 3; i++) {
            appUserRepository.save(
                    new AppUser(
                            "user" + i,
                            passwordEncoder.encode("user" + i),
                            roleUSER
                    )
            );
        }

        for (int i = 0; i < 3; i++) {
            appUserRepository.save(
                    new AppUser(
                            "admin" + i,
                            passwordEncoder.encode("admin" + i),
                            roleADMIN
                    )
            );
        }


        alreadySetup = true;
    }

}
