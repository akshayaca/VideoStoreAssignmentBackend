    package com.backend.backend.repository;

    import com.backend.backend.model.User;
    import org.springframework.data.mongodb.repository.MongoRepository;
    import org.springframework.stereotype.Repository;

    import java.util.Optional;

    @Repository
    public interface UserRepository extends MongoRepository<User, String> {
        boolean existsByEmail(String email);

        Optional<User> findByEmail(String email);
    }
