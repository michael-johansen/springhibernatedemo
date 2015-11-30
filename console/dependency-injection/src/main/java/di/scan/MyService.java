package di.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class MyService {
    private final MyRepository myRepository;

    @Autowired
    MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }
}
