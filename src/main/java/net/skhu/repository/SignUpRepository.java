package net.skhu.repository;

import net.skhu.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignUpRepository extends JpaRepository<Users,Long> {
}
