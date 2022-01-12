package com.crediteuropebank.assignment;

import com.crediteuropebank.assignment.model.Ingredient;
import com.crediteuropebank.assignment.model.Instruction;
import com.crediteuropebank.assignment.model.Receipt;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;


public class ControllerTestsClass extends  AbstractTest{
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    String testId = "54";

    @Test
    @Order(2)
    public void givenNothing_whenGetReceipt_thenStatus200() throws Exception {
        String uri = "/receipt";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Receipt[] receiptList = super.mapFromJson(content, Receipt[].class);
        assertTrue(receiptList.length > 0);
    }
    @Test
    @Order(1)
    public void givenReceipt_whenCreateReceipt_thenStatus200() throws Exception {
        String uri = "/receipt";
        Receipt receipt = new Receipt();
        receipt.setName("TEST");
        receipt.setCreatedDate(new Date());
        receipt.setVegetarian(true);
        receipt.setPortion(2);
        Ingredient ing = new Ingredient();
        ing.setContent("test test test");
        Set<Ingredient> set = new HashSet<Ingredient>(){{
            add(ing);
        }};
        receipt.setIngredients(set);
        Instruction ins = new Instruction();
        ins.setContent("sole yap bole yap");
        Set<Instruction> set2 = new HashSet<Instruction>(){{
            add(ins);
        }};
        receipt.setInstructions(set2);
        String inputJson = super.mapToJson(receipt);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "");
    }
    @Test
    @Order(4)
    public void givenReceiptAndReceiptId_whenUpdateReceipt_thenStatus200() throws Exception {
        String uri = "/receipt/"+testId;
        Receipt receipt = new Receipt();
        receipt.setName("Updated test receipt");
        receipt.setVegetarian(false);
        receipt.setPortion(21);
        Ingredient ing = new Ingredient();
        ing.setContent("test test test update");
        Set<Ingredient> set = new HashSet<Ingredient>(){{
            add(ing);
        }};
        receipt.setIngredients(set);
        Instruction ins = new Instruction();
        ins.setContent("sole yap bole yap update");
        Set<Instruction> set2 = new HashSet<Instruction>(){{
            add(ins);
        }};
        receipt.setInstructions(set2);
        String inputJson = super.mapToJson(receipt);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "");
    }
    @Test
    @AfterAll
    public void givenReceiptId_whenDeleteReceipt_thenStatus200() throws Exception {
        String uri = "/receipt/"+testId;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "");
    }

    @Test
    @Order(3)
    public void givenReceiptId_whenGetReceipt_thenStatus200() throws Exception {
        String uri = "/receipt/"+testId;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Receipt receipt = super.mapFromJson(content, Receipt.class);
        assertNotNull(receipt);
    }
}

