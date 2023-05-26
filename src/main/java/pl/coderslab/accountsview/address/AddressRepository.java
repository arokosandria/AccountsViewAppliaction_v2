package pl.coderslab.accountsview.address;

import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
