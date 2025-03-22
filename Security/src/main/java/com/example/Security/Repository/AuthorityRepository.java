package com.example.Security.Repository;

import com.example.Security.Entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authorities,Long> {

}
