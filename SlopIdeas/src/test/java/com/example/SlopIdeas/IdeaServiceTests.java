package com.example.SlopIdeas;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IdeaServiceTests {
    
    @Test
    public IdeaService ideaService(){
        return new IdeaService();
    }
}
