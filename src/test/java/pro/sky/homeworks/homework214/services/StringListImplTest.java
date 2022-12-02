package pro.sky.homeworks.homework214.services;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pro.sky.homeworks.homework214.excaptions.ElementAlreadyExistsException;
import pro.sky.homeworks.homework214.excaptions.ElementNotFoundException;
import pro.sky.homeworks.homework214.excaptions.OutOfBoundsExceptions;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StringListImplTest {
    final String item = "New string";
    final int index = 0;
    final int minus = -1;
    StringList stringList = new StringListImpl();

    @Test
    void shouldAddStringToArray() {
        assertEquals(stringList.add(item), item);
    }

    @Test
    void shouldAddStringToArrayByIndex() {
        assertEquals(stringList.add(index, item), item);
    }

    @Test
    void shouldThrowOutOfBoundsExceptionWhenAddStringToArray() {
        Throwable thrown = catchThrowable(() -> stringList.add(stringList.size(), item));
        assertThat(thrown).isInstanceOf(OutOfBoundsExceptions.class);
        assertThat(thrown.getMessage()).isNotBlank();
    }

    @Test
    void shouldThrowElementAlreadyExistsExceptionWhenAddStringToArray() {
        assertEquals(stringList.add(item), item);
        Throwable thrown = catchThrowable(() -> stringList.add(index, item));
        assertThat(thrown).isInstanceOf(ElementAlreadyExistsException.class);
        assertThat(thrown.getMessage()).isNotBlank();
    }


    @Test
    void shouldSetStringToArray() {
        assertEquals(stringList.set(index, item), item);
    }

    @Test
    void shouldThrowOutOfBoundsExceptionWhenSetStringToArray() {
        Throwable thrown = catchThrowable(() -> stringList.set(stringList.size(), item));
        assertThat(thrown).isInstanceOf(OutOfBoundsExceptions.class);
        assertThat(thrown.getMessage()).isNotBlank();
    }

    @Test
    void shouldRemoveItemFromArray() {
        stringList.add(item);
        assertEquals(stringList.remove(item), item);

    }

    @Test
    void shouldThrowExceptionWhenTryToRemoveNotExistingItemFromArray() {
        Throwable thrown = catchThrowable(() -> stringList.remove(item));
        assertThat(thrown).isInstanceOf(ElementNotFoundException.class);
        assertThat(thrown.getMessage()).isNotBlank();
    }

    @Test
    void shouldRemoveItemByIndexFromArray() {
        stringList.add(item);
        assertEquals(stringList.remove(index), item);
    }

    @Test
    void shouldThrowExceptionWhenTryToRemoveNotExistingItemByIndexFromArray() {
        Throwable thrown = catchThrowable(() -> stringList.remove(index));
        assertThat(thrown).isInstanceOf(ElementNotFoundException.class);
        assertThat(thrown.getMessage()).isNotBlank();
    }

    @Test
    void shouldFindItemInArray() {
        stringList.add(item);
        assertTrue(stringList.contains(item));
    }

    @Test
    void shouldReturnFalseIfCantFindItem() {
        assertFalse(stringList.contains(item));
    }

    @Test
    void shouldReturnIndexOfItemCorrectly() {
        stringList.add(item);
        stringList.add(item);
        assertEquals(stringList.indexOf(item), index);
    }

    @Test
    void shouldReturnMinusOneForIndexOf() {
        assertEquals(stringList.indexOf(item), minus);
    }

    @Test
    void shouldReturnLastIndexOfItemCorrectly() {
        stringList.add(item);
        stringList.add(item);
        assertEquals(stringList.lastIndexOf(item), index + 1);
    }

    @Test
    void shouldReturnMinusOneForLastIndexOf() {
        assertEquals(stringList.lastIndexOf(item), minus);
    }

    @Test
    void shouldGetItemCorrectly() {
        stringList.add(item);
        assertEquals(stringList.get(index), item);
    }


    @Test
    void shouldShowSizeCorrectly() {
        stringList.add(item);
        stringList.add(item);
        assertEquals(stringList.size(), 2);
    }

    @Test
    void shouldShowThatArrayIsEmpty() {
        assertTrue(stringList.isEmpty());
    }


    @Test
    void shouldClearArray() {
        stringList.add(item);
        stringList.clear();
        assertTrue(stringList.isEmpty());
    }

    @Test
    void shouldCheckEquality() {
        stringList.add(item);
        String[] check = {item};
        assertTrue(stringList.equals(check));
    }
}