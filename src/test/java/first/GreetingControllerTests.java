package first;

/*import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


public class ControllerTest {

    @Mock
    private UserRepository userRepository;

    private Controller controller;

    private String name="Jennifer";
    private String name1="Xavi";

    @Before
    public void setUp() {
        /**
         * Genetares a clean instance for each @Test we will have

        this.controller = new Controller();
        MockitoAnnotations.initMocks(this);
    }

   @Test
    public void shouldSayHelloIfUserIsInDatabase(){
        when(userRepository.findByUserName(name)).thenReturn(name1);
        assertThat(userRepository.findByUserName(name).equals(name1));
    }

    @Test
    public void shouldSayHello() {
        assertThat(controller.sayHello("Hello")).isEqualTo("Hello");
    }
}

*/


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value(xpath("Hello World!"));
    }

    private SuppressWarnings jsonPath(String s) {

    }

    @Test
    public void paramGreetingShouldReturnTailoredMessage() throws Exception {

        this.mockMvc.perform(get("/greeting").param("name", "Spring Community"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
    }

}