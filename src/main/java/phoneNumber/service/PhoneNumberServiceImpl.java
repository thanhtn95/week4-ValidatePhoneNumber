package phoneNumber.service;

import org.springframework.beans.factory.annotation.Autowired;
import phoneNumber.model.PhoneNumber;
import phoneNumber.repository.PhoneNumberRepository;

public class PhoneNumberServiceImpl implements PhoneNumberService {
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;
    @Override
    public void save(PhoneNumber phoneNumber) {
        phoneNumberRepository.save(phoneNumber);
    }
}
