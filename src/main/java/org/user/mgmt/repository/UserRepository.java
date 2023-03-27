package org.user.mgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.user.mgmt.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}