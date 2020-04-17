package com.avatar.bank.Avatar_Bank.Controllers;
import com.avatar.bank.Avatar_Bank.model.Account;
import com.avatar.bank.Avatar_Bank.model.Address;
import com.avatar.bank.Avatar_Bank.model.Customer;
import com.avatar.bank.Avatar_Bank.service.CustomerService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerControllerTest {


    @Mock
    private CustomerService customerService;

    private MockMvc mockMvc;

    @BeforeAll
    void initialize() {
        MockitoAnnotations.initMocks(this);
        CustomerController customerController = new CustomerController(customerService);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(customerController)
                .build();
    }

    @Test
    void getAllCustomers() {
    }

    @Test
    void getCustomersById() throws Exception {
        Address address = new Address(1,"123 Testing Rd","","Blain","MN","878787");
        Account account = new Account("Individual",2000.0,1);
        Customer repoCustomer = new Customer(1, "Greg", "", "Pope", "1234567890", "email@email.com", address, account);

        given(customerService.getCustomerById(1))
                .willReturn(repoCustomer);

        /*MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/customer/1")
                .contentType(MediaType.APPLICATION_JSON)*/

        MockHttpServletResponse response = mockMvc.perform(
                MockMvcRequestBuilders.get("/customer/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void addCustomer() {
    }

    @Test
    void deleteCustomerById() {
    }
}