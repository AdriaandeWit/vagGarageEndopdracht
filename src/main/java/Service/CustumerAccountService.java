package Service;

import Repository.CustomerAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustumerAccountService {

@Autowired
    private final CustomerAccountRepository cARepos;

    public CustumerAccountService(CustomerAccountRepository cARepos) {
        this.cARepos = cARepos;
    }




}
