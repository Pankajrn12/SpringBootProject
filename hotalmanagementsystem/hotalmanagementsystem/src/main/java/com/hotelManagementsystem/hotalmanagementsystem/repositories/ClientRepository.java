package com.hotelManagementsystem.hotalmanagementsystem.repositories;

import com.hotelManagementsystem.hotalmanagementsystem.entities.Client;
import com.hotelManagementsystem.hotalmanagementsystem.modeles.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    public Client findByClientId(Long clientId);
}
