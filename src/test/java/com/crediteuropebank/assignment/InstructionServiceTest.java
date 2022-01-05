package com.crediteuropebank.assignment;

import com.crediteuropebank.assignment.repository.IngredientRepository;
import com.crediteuropebank.assignment.repository.InstructionRepository;
import com.crediteuropebank.assignment.service.impl.IngredientServiceImpl;
import com.crediteuropebank.assignment.service.impl.InstructionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class InstructionServiceTest {
    @Mock
    InstructionRepository instructionRepository;

    @InjectMocks
    private InstructionServiceImpl instructionService;

    @Test
    public void whenDeleteReceiptId_thenInvokeInstructionRepositoryOneTime(){
        doNothing().when(instructionRepository).deleteByReceiptId(anyLong());
        //when
        instructionService.deleteByReceiptId(1L);
        //then
        verify(instructionRepository, times(1)).deleteByReceiptId(anyLong());
    }
}