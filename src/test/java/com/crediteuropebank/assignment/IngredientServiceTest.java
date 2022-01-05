package com.crediteuropebank.assignment;


import com.crediteuropebank.assignment.repository.IngredientRepository;
import com.crediteuropebank.assignment.service.impl.IngredientServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class IngredientServiceTest {
    @Mock
    IngredientRepository ingredientRepository;

    @InjectMocks
    private IngredientServiceImpl ingredientService;

    @Test
    public void whenDeleteReceiptId_thenInvokeIngredientRepositoryOneTime(){
        doNothing().when(ingredientRepository).deleteByReceiptId(anyLong());
        //when
        ingredientService.deleteByReceiptId(1L);
        //then
        verify(ingredientRepository, times(1)).deleteByReceiptId(anyLong());
    }
}