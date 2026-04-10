package com.notify.pigeon.sender;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenderRepository extends JpaRepository<SenderEntity,Long> {
}
