package com.crediteuropebank.assignment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.crediteuropebank.assignment.controller.ReceiptController;
import com.crediteuropebank.assignment.model.Ingredient;
import com.crediteuropebank.assignment.model.Instruction;
import com.crediteuropebank.assignment.model.Receipt;
import com.crediteuropebank.assignment.service.ReceiptService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ControllerTestsClass extends  AbstractTest{
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
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
    public void givenReceiptAndReceiptId_whenUpdateReceipt_thenStatus200() throws Exception {
        String uri = "/receipt/1";
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
    public void givenReceiptId_whenDeleteReceipt_thenStatus200() throws Exception {
        String uri = "/receipt/67";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "");
    }
}

