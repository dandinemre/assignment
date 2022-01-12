package com.crediteuropebank.assignment;

import com.crediteuropebank.assignment.model.Ingredient;
import com.crediteuropebank.assignment.model.Instruction;
import com.crediteuropebank.assignment.model.Receipt;
import com.crediteuropebank.assignment.repository.ReceiptRepository;
import com.crediteuropebank.assignment.service.IngredientService;
import com.crediteuropebank.assignment.service.InstructionService;
import com.crediteuropebank.assignment.service.impl.ReceiptServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReceiptServiceTest {
    @Mock
    ReceiptRepository receiptRepository;

    @Mock
    IngredientService ingredientService;

    @Mock
    InstructionService instructionService;

    @InjectMocks
    private ReceiptServiceImpl receiptService;

    @Test
    public void whenFindAll_thenReturnReceiptList() {
        // given
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

        List<Receipt> expectedReceipts = Arrays.asList(receipt);

        doReturn(expectedReceipts).when(receiptRepository).findAll();
        // when
        List<Receipt> actualReceipts = receiptService.findAll(0,10,"id");

        // then
        assertThat(actualReceipts).isEqualTo(expectedReceipts);
    }
    @Test
    public void whenUpdateReceipt_thenInvokeReceiptRepositoryOneTime(){
        // given
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
        //List<Receipt> expectedReceipts = Arrays.asList(receipt);
        Optional o = Optional.ofNullable(receipt);
        doReturn(o).when(receiptRepository).findById(1L);
        doReturn(receipt).when(receiptRepository).save(any());
        //when
        receiptService.update(receipt,1L);

        verify(receiptRepository, atLeast(1)).findById(anyLong());
        verify(receiptRepository, times(1)).save(any());

    }

    @Test
    public void whenDeleteReceiptId_thenInvokeReceiptRepositoryOneTime(){
        doNothing().when(receiptRepository).deleteById(anyLong());
        //when
        receiptService.delete(1L);
        //then
        verify(receiptRepository, times(1)).deleteById(anyLong());
    }

    @Test
    public void whenSaveReceipt_thenInvokeReceiptRepositoryOneTime(){
        // given
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
        doReturn(receipt).when(receiptRepository).save(any());
        //when
        receiptService.save(receipt);
        //then
        verify(receiptRepository, times(1)).save(any());
    }

    @Test
    public void whenFindById_thenReturnReceipt() {
        // given
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
        Optional<Receipt> opt = Optional.of(receipt);
        doReturn(opt).when(receiptRepository).findById(anyLong());
        // when
        Optional<Receipt> actualReceipt = receiptService.findById(1L);

        // then
        assertThat(actualReceipt).isEqualTo(opt);
    }
}