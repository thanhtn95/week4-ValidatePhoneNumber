package phoneNumber.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import phoneNumber.model.PhoneNumber;

public interface PhoneNumberRepository extends PagingAndSortingRepository<PhoneNumber,Integer> {
}
